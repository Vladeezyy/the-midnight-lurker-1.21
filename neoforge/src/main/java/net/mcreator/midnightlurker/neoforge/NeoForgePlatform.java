package net.mcreator.midnightlurker.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.port.platform.Platform;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/** The Midnight Lurker on NeoForge: the APIs the MCreator code used */
public final class NeoForgePlatform implements Platform {
	/** Deferred registers per registry, filled by the common code before {@link #registerAll} */
	private static final Map<ResourceKey<?>, DeferredRegister<?>> REGISTERS = new LinkedHashMap<>();
	private static final List<Consumer<PayloadRegistrar>> PAYLOADS = new ArrayList<>();

	private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MidnightlurkerMod.MODID);
	static final Supplier<AttachmentType<MidnightlurkerModVariables.PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register(MidnightlurkerModVariables.PLAYER_VARIABLES_ID.getPath(),
			() -> AttachmentType.builder(MidnightlurkerModVariables.PlayerVariables::new).serialize(new IAttachmentSerializer<CompoundTag, MidnightlurkerModVariables.PlayerVariables>() {
				@Override
				public MidnightlurkerModVariables.PlayerVariables read(IAttachmentHolder holder, CompoundTag tag, HolderLookup.Provider provider) {
					MidnightlurkerModVariables.PlayerVariables variables = new MidnightlurkerModVariables.PlayerVariables();
					variables.deserializeNBT(provider, tag);
					return variables;
				}

				@Override
				public CompoundTag write(MidnightlurkerModVariables.PlayerVariables variables, HolderLookup.Provider provider) {
					return variables.serializeNBT(provider);
				}
			}).build());

	static void registerAll(IEventBus modBus) {
		REGISTERS.values().forEach(register -> register.register(modBus));
		ATTACHMENT_TYPES.register(modBus);
		modBus.addListener((RegisterPayloadHandlersEvent event) -> {
			PayloadRegistrar registrar = event.registrar(MidnightlurkerMod.MODID);
			PAYLOADS.forEach(payload -> payload.accept(registrar));
		});
	}

	@SuppressWarnings("unchecked")
	private static <R> DeferredRegister<R> registerFor(ResourceKey<? extends Registry<R>> registry) {
		return (DeferredRegister<R>) REGISTERS.computeIfAbsent(registry, key -> DeferredRegister.create((ResourceKey<? extends Registry<R>>) key, MidnightlurkerMod.MODID));
	}

	@Override
	public <R, T extends R> void register(ResourceKey<? extends Registry<R>> registry, ResourceLocation id, Supplier<? extends T> factory) {
		registerFor(registry).register(id.getPath(), factory);
	}

	@Override
	public Path gameDir() {
		return FMLPaths.GAMEDIR.get();
	}

	@Override
	public Path configDir() {
		return FMLPaths.CONFIGDIR.get();
	}

	@Override
	@Nullable
	public MinecraftServer currentServer() {
		return ServerLifecycleHooks.getCurrentServer();
	}

	@Override
	public CompoundTag persistentData(Entity entity) {
		return entity.getPersistentData();
	}

	@Override
	public CompoundTag persistentData(net.minecraft.world.level.block.entity.BlockEntity blockEntity) {
		return blockEntity.getPersistentData();
	}

	@Override
	public MidnightlurkerModVariables.PlayerVariables playerVariables(Entity entity) {
		return entity.getData(PLAYER_VARIABLES);
	}

	@Override
	public void setPlayerVariables(Entity entity, MidnightlurkerModVariables.PlayerVariables variables) {
		entity.setData(PLAYER_VARIABLES, variables);
	}

	@Override
	public <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> codec, Consumer<T> handler) {
		PAYLOADS.add(registrar -> registrar.playToClient(type, codec, (payload, context) -> context.enqueueWork(() -> handler.accept(payload))));
	}

	@Override
	public void sendToPlayer(ServerPlayer player, CustomPacketPayload payload) {
		PacketDistributor.sendToPlayer(player, payload);
	}

	@Override
	public void sendToPlayersInDimension(ServerLevel level, CustomPacketPayload payload) {
		PacketDistributor.sendToPlayersInDimension(level, payload);
	}

	@Override
	public void sendToAllPlayers(CustomPacketPayload payload) {
		PacketDistributor.sendToAllPlayers(payload);
	}

	@Override
	public <M extends AbstractContainerMenu> MenuType<M> menuType(MenuFactory<M> factory) {
		return IMenuTypeExtension.create(factory::create);
	}

	@Override
	public void openMenu(ServerPlayer player, MenuProvider provider, Consumer<RegistryFriendlyByteBuf> extraData) {
		player.openMenu(provider, extraData);
	}

	@Override
	public ServerPlayer fakePlayer(ServerLevel level) {
		return FakePlayerFactory.getMinecraft(level);
	}
}
