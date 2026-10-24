package net.mcreator.midnightlurker.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityLeaveLevelEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;


import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.port.LurkerEntities;
import net.mcreator.midnightlurker.port.bus.LurkerBus;

/** NeoForge entry point: common init, then NeoForge's events posted on {@link LurkerBus} */
@Mod(MidnightlurkerMod.MODID)
public final class MidnightlurkerNeoForge {
	public MidnightlurkerNeoForge(IEventBus modBus) {
		MidnightlurkerMod.init();
		NeoForgePlatform.registerAll(modBus);

		modBus.addListener((FMLCommonSetupEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.FMLCommonSetupEvent()));
		modBus.addListener((EntityAttributeCreationEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.EntityAttributeCreationEvent(event::put)));
		modBus.addListener((RegisterSpawnPlacementsEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.RegisterSpawnPlacementsEvent(
				new net.mcreator.midnightlurker.port.bus.RegisterSpawnPlacementsEvent.Sink() {
					@Override
					public <T extends net.minecraft.world.entity.Mob> void register(net.minecraft.world.entity.EntityType<T> type, net.minecraft.world.entity.SpawnPlacementType placement,
							net.minecraft.world.level.levelgen.Heightmap.Types heightmap, net.minecraft.world.entity.SpawnPlacements.SpawnPredicate<T> predicate,
							net.mcreator.midnightlurker.port.bus.RegisterSpawnPlacementsEvent.Operation operation) {
						event.register(type, placement, heightmap, predicate, RegisterSpawnPlacementsEvent.Operation.valueOf(operation.name()));
					}
				})));
		modBus.addListener((BuildCreativeModeTabContentsEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.BuildCreativeModeTabContentsEvent(event.getTabKey(), event::accept)));

		IEventBus bus = NeoForge.EVENT_BUS;
		bus.addListener((ServerTickEvent.Post event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.ServerTickEvent.Post(event.getServer())));
		bus.addListener((RegisterCommandsEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.RegisterCommandsEvent(event.getDispatcher(), event.getCommandSelection(), event.getBuildContext())));
		bus.addListener((LivingIncomingDamageEvent event) -> {
			var ours = new net.mcreator.midnightlurker.port.bus.LivingIncomingDamageEvent(event.getEntity(), event.getSource(), event.getAmount());
			if (LurkerBus.post(ours))
				event.setCanceled(true);
			else if (ours.getAmount() != event.getAmount())
				event.setAmount(ours.getAmount());
		});
		bus.addListener((LivingDeathEvent event) -> {
			if (LurkerBus.post(new net.mcreator.midnightlurker.port.bus.LivingDeathEvent(event.getEntity(), event.getSource())))
				event.setCanceled(true);
		});
		bus.addListener((PlayerTickEvent.Post event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerTickEvent.Post(event.getEntity())));
		bus.addListener((PlayerEvent.PlayerLoggedInEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerEvent.PlayerLoggedInEvent(event.getEntity())));
		bus.addListener((PlayerEvent.PlayerRespawnEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerEvent.PlayerRespawnEvent(event.getEntity(), event.isEndConquered())));
		bus.addListener((PlayerEvent.PlayerChangedDimensionEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerEvent.PlayerChangedDimensionEvent(event.getEntity())));
		bus.addListener((PlayerEvent.Clone event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerEvent.Clone(event.getEntity(), event.getOriginal(), event.isWasDeath())));
		bus.addListener((PlayerEvent.ItemCraftedEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerEvent.ItemCraftedEvent(event.getEntity(), event.getCrafting())));
		bus.addListener((PlayerEvent.ItemSmeltedEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerEvent.ItemSmeltedEvent(event.getEntity(), event.getSmelting())));
		bus.addListener((PlayerWakeUpEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.PlayerWakeUpEvent(event.getEntity())));
		bus.addListener((ItemFishedEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.ItemFishedEvent(event.getEntity(), event.getDrops())));
		bus.addListener((PlayerInteractEvent.RightClickBlock event) -> LurkerBus.post(
				new net.mcreator.midnightlurker.port.bus.PlayerInteractEvent.RightClickBlock(event.getEntity(), event.getHand(), event.getPos(), event.getFace())));
		bus.addListener((ItemEntityPickupEvent.Pre event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.ItemEntityPickupEvent.Pre(event.getPlayer(), event.getItemEntity())));
		bus.addListener((LivingEntityUseItemEvent.Finish event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.LivingEntityUseItemEvent.Finish(event.getEntity(), event.getItem())));
		// the only listener (EntityAnimationFactory) handles this mod's entities: skip the rest of the world's
		bus.addListener((EntityTickEvent.Pre event) -> {
			if (LurkerEntities.ours(event.getEntity()))
				LurkerBus.post(new net.mcreator.midnightlurker.port.bus.EntityTickEvent.Pre(event.getEntity()));
		});
		bus.addListener((EntityJoinLevelEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.EntityJoinLevelEvent(event.getEntity(), event.getLevel())));
		bus.addListener((EntityLeaveLevelEvent event) -> LurkerBus.post(new net.mcreator.midnightlurker.port.bus.EntityLeaveLevelEvent(event.getEntity(), event.getLevel())));
	}
}
