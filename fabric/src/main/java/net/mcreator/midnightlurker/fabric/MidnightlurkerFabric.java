package net.mcreator.midnightlurker.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityLevelChangeEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.port.bus.BuildCreativeModeTabContentsEvent;
import net.mcreator.midnightlurker.port.bus.EntityAttributeCreationEvent;
import net.mcreator.midnightlurker.port.bus.EntityJoinLevelEvent;
import net.mcreator.midnightlurker.port.bus.EntityLeaveLevelEvent;
import net.mcreator.midnightlurker.port.bus.FMLCommonSetupEvent;
import net.mcreator.midnightlurker.port.bus.LivingDeathEvent;
import net.mcreator.midnightlurker.port.bus.LivingIncomingDamageEvent;
import net.mcreator.midnightlurker.port.bus.LurkerBus;
import net.mcreator.midnightlurker.port.bus.PlayerEvent;
import net.mcreator.midnightlurker.port.bus.PlayerInteractEvent;
import net.mcreator.midnightlurker.port.bus.PlayerWakeUpEvent;
import net.mcreator.midnightlurker.port.bus.RegisterCommandsEvent;
import net.mcreator.midnightlurker.port.bus.RegisterSpawnPlacementsEvent;
import net.mcreator.midnightlurker.port.bus.ServerTickEvent;

/** Fabric entry point: common init, Fabric API events (and the mixins in .mixin) posted on {@link LurkerBus} */
public final class MidnightlurkerFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		MidnightlurkerMod.init();
		FabricPlatform.registerAll();
		LurkerBus.post(new EntityAttributeCreationEvent(FabricDefaultAttributeRegistry::register));
		LurkerBus.post(new RegisterSpawnPlacementsEvent(new RegisterSpawnPlacementsEvent.Sink() {
			@Override
			public <T extends Mob> void register(net.minecraft.world.entity.EntityType<T> type, net.minecraft.world.entity.SpawnPlacementType placement,
					net.minecraft.world.level.levelgen.Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate, RegisterSpawnPlacementsEvent.Operation operation) {
				// the mod only replaces (its own types, which have no placement yet)
				SpawnPlacements.register(type, placement, heightmap, predicate);
			}
		}));
		FabricBiomeModifiers.register();
		CreativeModeTabEvents.MODIFY_OUTPUT_ALL.register((tab, output) -> BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(tab)
				.ifPresent(key -> LurkerBus.post(new BuildCreativeModeTabContentsEvent(key, stack -> output.accept(stack)))));
		LurkerBus.post(new FMLCommonSetupEvent());

		ServerLifecycleEvents.SERVER_STARTING.register(server -> FabricPlatform.server = server);
		ServerLifecycleEvents.SERVER_STOPPED.register(server -> FabricPlatform.server = null);
		ServerTickEvents.END_SERVER_TICK.register(server -> LurkerBus.post(new ServerTickEvent.Post(server)));
		CommandRegistrationCallback.EVENT.register((dispatcher, context, selection) -> LurkerBus.post(new RegisterCommandsEvent(dispatcher, selection, context)));
		ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> !LurkerBus.post(new LivingIncomingDamageEvent(entity, source, amount)));
		ServerLivingEntityEvents.ALLOW_DEATH.register((entity, source, amount) -> !LurkerBus.post(new LivingDeathEvent(entity, source)));
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> LurkerBus.post(new PlayerEvent.PlayerLoggedInEvent(handler.getPlayer())));
		ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> LurkerBus.post(new PlayerEvent.Clone(newPlayer, oldPlayer, !alive)));
		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> LurkerBus.post(new PlayerEvent.PlayerRespawnEvent(newPlayer, alive)));
		ServerEntityLevelChangeEvents.AFTER_PLAYER_CHANGE_LEVEL.register((player, origin, destination) -> LurkerBus.post(new PlayerEvent.PlayerChangedDimensionEvent(player)));
		EntitySleepEvents.STOP_SLEEPING.register((entity, pos) -> {
			if (entity instanceof Player player)
				LurkerBus.post(new PlayerWakeUpEvent(player));
		});
		UseBlockCallback.EVENT.register((player, level, hand, hit) -> {
			LurkerBus.post(new PlayerInteractEvent.RightClickBlock(player, hand, hit.getBlockPos(), hit.getDirection()));
			return InteractionResult.PASS;
		});
		ServerEntityEvents.ENTITY_LOAD.register((entity, level) -> LurkerBus.post(new EntityJoinLevelEvent(entity, level)));
		ServerEntityEvents.ENTITY_UNLOAD.register((entity, level) -> LurkerBus.post(new EntityLeaveLevelEvent(entity, level)));
	}
}
