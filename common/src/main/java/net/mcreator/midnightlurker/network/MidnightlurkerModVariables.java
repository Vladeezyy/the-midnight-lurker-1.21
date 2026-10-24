package net.mcreator.midnightlurker.network;

import net.mcreator.midnightlurker.port.bus.PlayerEvent;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.mcreator.midnightlurker.port.bus.FMLCommonSetupEvent;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtAccounter;
import net.minecraft.world.level.storage.LevelResource;

import javax.annotation.Nullable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import net.minecraft.core.HolderLookup;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.port.PortUtil;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.PlayerEvent;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.platform.Platform;

import java.util.function.Supplier;

@EventBusSubscriber
public class MidnightlurkerModVariables {
	/** The id of the player variables attachment (NeoForge and Fabric), as in 3.3.7 */
	public static final Identifier PLAYER_VARIABLES_ID = Identifier.fromNamespaceAndPath(MidnightlurkerMod.MODID, "player_variables");

	/** The player variables of an entity (NeoForge's {@code getData(PLAYER_VARIABLES)}) */
	public static PlayerVariables of(Entity entity) {
		return Platform.INSTANCE.playerVariables(entity);
	}

	/** Both loaders call this once at init */
	public static void registerPackets() {
		Platform.INSTANCE.registerClientbound(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		Platform.INSTANCE.registerClientbound(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				of(player).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				of(player).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				of(player).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = of(event.getOriginal());
			PlayerVariables clone = new PlayerVariables();
			clone.DeathJumpActive = original.DeathJumpActive;
			clone.DeathJumpTimer = original.DeathJumpTimer;
			clone.DeathJumpShake = original.DeathJumpShake;
			clone.ScreenShake = original.ScreenShake;
			clone.InsanityStage = original.InsanityStage;
			clone.InsanityTimer = original.InsanityTimer;
			clone.InsanityAktive = original.InsanityAktive;
			clone.InsanityReset = original.InsanityReset;
			clone.JumpscareActive = original.JumpscareActive;
			clone.JumpscareTimer = original.JumpscareTimer;
			clone.JumpscareRandom = original.JumpscareRandom;
			clone.StaticRender = original.StaticRender;
			if (!event.isWasDeath()) {
				clone.encounternumber = original.encounternumber;
			}
			Platform.INSTANCE.setPlayerVariables(event.getEntity(), clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					Platform.INSTANCE.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					Platform.INSTANCE.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					Platform.INSTANCE.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "midnightlurker_worldvars";
		// 26.1: saved data lives in data/<namespace>/ of the dimension (vanilla type: a no-op data fix, the one the Rats port uses); a world from an older version still has the
		// file where 1.21 kept it, which the game's own file fix does not move, so it is read once from there
		public static final SavedDataType<WorldVariables> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MidnightlurkerMod.MODID, DATA_NAME), () -> {
			CompoundTag legacy = legacyData(Platform.INSTANCE.currentServer(), DATA_NAME);
			return legacy != null ? load(legacy, null) : new WorldVariables();
		}, CompoundTag.CODEC.xmap(tag -> load(tag, null), data -> data.save(new CompoundTag(), null)), DataFixTypes.SAVED_DATA_WANDERING_TRADER);
		public double midnightlurkeroverhauledrewardrandom = 0;
		public double midnightlurkeroverhauledinsanitytimer = 0.0;
		public double midnightlurkeroverhauledinstage = 0;
		public double midnightlurkerinsanitytimactivate = 0;
		public double midnightlurkerinsanityactive = 0;
		public double NeutralrunRandom = 0;
		public double midnighthealthboost = 0;
		public boolean lurkerdevoverlay = false;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			midnightlurkeroverhauledrewardrandom = nbt.getDoubleOr("midnightlurkeroverhauledrewardrandom", 0);
			midnightlurkeroverhauledinsanitytimer = nbt.getDoubleOr("midnightlurkeroverhauledinsanitytimer", 0);
			midnightlurkeroverhauledinstage = nbt.getDoubleOr("midnightlurkeroverhauledinstage", 0);
			midnightlurkerinsanitytimactivate = nbt.getDoubleOr("midnightlurkerinsanitytimactivate", 0);
			midnightlurkerinsanityactive = nbt.getDoubleOr("midnightlurkerinsanityactive", 0);
			NeutralrunRandom = nbt.getDoubleOr("NeutralrunRandom", 0);
			midnighthealthboost = nbt.getDoubleOr("midnighthealthboost", 0);
			lurkerdevoverlay = nbt.getBooleanOr("lurkerdevoverlay", false);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("midnightlurkeroverhauledrewardrandom", midnightlurkeroverhauledrewardrandom);
			nbt.putDouble("midnightlurkeroverhauledinsanitytimer", midnightlurkeroverhauledinsanitytimer);
			nbt.putDouble("midnightlurkeroverhauledinstage", midnightlurkeroverhauledinstage);
			nbt.putDouble("midnightlurkerinsanitytimactivate", midnightlurkerinsanitytimactivate);
			nbt.putDouble("midnightlurkerinsanityactive", midnightlurkerinsanityactive);
			nbt.putDouble("NeutralrunRandom", NeutralrunRandom);
			nbt.putDouble("midnighthealthboost", midnighthealthboost);
			nbt.putBoolean("lurkerdevoverlay", lurkerdevoverlay);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				Platform.INSTANCE.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "midnightlurker_mapvars";
		// 26.1: saved data lives in data/<namespace>/ of the dimension (vanilla type: a no-op data fix, the one the Rats port uses); a world from an older version still has the
		// file where 1.21 kept it, which the game's own file fix does not move, so it is read once from there
		public static final SavedDataType<MapVariables> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MidnightlurkerMod.MODID, DATA_NAME), () -> {
			CompoundTag legacy = legacyData(Platform.INSTANCE.currentServer(), DATA_NAME);
			return legacy != null ? load(legacy, null) : new MapVariables();
		}, CompoundTag.CODEC.xmap(tag -> load(tag, null), data -> data.save(new CompoundTag(), null)), DataFixTypes.SAVED_DATA_WANDERING_TRADER);

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				Platform.INSTANCE.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(TYPE);
			} else {
				return clientSide;
			}
		}
	}

	/** The contents of a saved data file of 1.21 (world/data/<name>.dat, or where 26.1's file fix moves the data folder), or null. */
	static CompoundTag legacyData(@Nullable net.minecraft.server.MinecraftServer server, String name) {
		if (server == null)
			return null;
		Path root = server.getWorldPath(LevelResource.ROOT);
		for (Path file : List.of(root.resolve("data").resolve(name + ".dat"), root.resolve("dimensions/minecraft/overworld/data/minecraft").resolve(name + ".dat"))) {
			if (Files.isRegularFile(file)) {
				try {
					return NbtIo.readCompressed(file, NbtAccounter.unlimitedHeap()).getCompoundOrEmpty("data");
				} catch (IOException e) {
					MidnightlurkerMod.LOGGER.warn("Could not read the old saved data {}", file, e);
				}
			}
		}
		return null;
	}

	// 1.21.5: SavedData has no save(CompoundTag) of its own any more
	static CompoundTag saveData(SavedData data, HolderLookup.Provider lookupProvider) {
		return data instanceof MapVariables mapVariables ? mapVariables.save(new CompoundTag(), lookupProvider) : ((WorldVariables) data).save(new CompoundTag(), lookupProvider);
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(MidnightlurkerMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(saveData(message.data, buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		/** Client thread */
		public static void handleData(final SavedDataSyncMessage message) {
			HolderLookup.Provider registries = PortUtil.clientRegistries.get();
			if (message.data != null && registries != null) {
				if (message.dataType == 0)
					MapVariables.clientSide.read(saveData(message.data, registries), registries);
				else
					WorldVariables.clientSide.read(saveData(message.data, registries), registries);
			}
		}

	}

	public static class PlayerVariables {
		public double DeathJumpActive = 0;
		public double DeathJumpTimer = 0;
		public double DeathJumpShake = 0;
		public double ScreenShake = 0;
		public double InsanityStage = 0;
		public double InsanityTimer = 0;
		public double InsanityAktive = 0;
		public double InsanityReset = 0;
		public double JumpscareActive = 0;
		public double JumpscareTimer = 0;
		public double JumpscareRandom = 0;
		public double StaticRender = 0;
		public double encounternumber = 0;

		public void serialize(ValueOutput output) {
			output.putDouble("DeathJumpActive", DeathJumpActive);
			output.putDouble("DeathJumpTimer", DeathJumpTimer);
			output.putDouble("DeathJumpShake", DeathJumpShake);
			output.putDouble("ScreenShake", ScreenShake);
			output.putDouble("InsanityStage", InsanityStage);
			output.putDouble("InsanityTimer", InsanityTimer);
			output.putDouble("InsanityAktive", InsanityAktive);
			output.putDouble("InsanityReset", InsanityReset);
			output.putDouble("JumpscareActive", JumpscareActive);
			output.putDouble("JumpscareTimer", JumpscareTimer);
			output.putDouble("JumpscareRandom", JumpscareRandom);
			output.putDouble("StaticRender", StaticRender);
			output.putDouble("encounternumber", encounternumber);
		}

		public void deserialize(ValueInput input) {
			DeathJumpActive = input.getDoubleOr("DeathJumpActive", 0);
			DeathJumpTimer = input.getDoubleOr("DeathJumpTimer", 0);
			DeathJumpShake = input.getDoubleOr("DeathJumpShake", 0);
			ScreenShake = input.getDoubleOr("ScreenShake", 0);
			InsanityStage = input.getDoubleOr("InsanityStage", 0);
			InsanityTimer = input.getDoubleOr("InsanityTimer", 0);
			InsanityAktive = input.getDoubleOr("InsanityAktive", 0);
			InsanityReset = input.getDoubleOr("InsanityReset", 0);
			JumpscareActive = input.getDoubleOr("JumpscareActive", 0);
			JumpscareTimer = input.getDoubleOr("JumpscareTimer", 0);
			JumpscareRandom = input.getDoubleOr("JumpscareRandom", 0);
			StaticRender = input.getDoubleOr("StaticRender", 0);
			encounternumber = input.getDoubleOr("encounternumber", 0);
		}

		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("DeathJumpActive", DeathJumpActive);
			nbt.putDouble("DeathJumpTimer", DeathJumpTimer);
			nbt.putDouble("DeathJumpShake", DeathJumpShake);
			nbt.putDouble("ScreenShake", ScreenShake);
			nbt.putDouble("InsanityStage", InsanityStage);
			nbt.putDouble("InsanityTimer", InsanityTimer);
			nbt.putDouble("InsanityAktive", InsanityAktive);
			nbt.putDouble("InsanityReset", InsanityReset);
			nbt.putDouble("JumpscareActive", JumpscareActive);
			nbt.putDouble("JumpscareTimer", JumpscareTimer);
			nbt.putDouble("JumpscareRandom", JumpscareRandom);
			nbt.putDouble("StaticRender", StaticRender);
			nbt.putDouble("encounternumber", encounternumber);
			return nbt;
		}

		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			DeathJumpActive = nbt.getDoubleOr("DeathJumpActive", 0);
			DeathJumpTimer = nbt.getDoubleOr("DeathJumpTimer", 0);
			DeathJumpShake = nbt.getDoubleOr("DeathJumpShake", 0);
			ScreenShake = nbt.getDoubleOr("ScreenShake", 0);
			InsanityStage = nbt.getDoubleOr("InsanityStage", 0);
			InsanityTimer = nbt.getDoubleOr("InsanityTimer", 0);
			InsanityAktive = nbt.getDoubleOr("InsanityAktive", 0);
			InsanityReset = nbt.getDoubleOr("InsanityReset", 0);
			JumpscareActive = nbt.getDoubleOr("JumpscareActive", 0);
			JumpscareTimer = nbt.getDoubleOr("JumpscareTimer", 0);
			JumpscareRandom = nbt.getDoubleOr("JumpscareRandom", 0);
			StaticRender = nbt.getDoubleOr("StaticRender", 0);
			encounternumber = nbt.getDoubleOr("encounternumber", 0);
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				Platform.INSTANCE.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(MidnightlurkerMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		/** Client thread */
		public static void handleData(final PlayerVariablesSyncMessage message) {
			Entity player = PortUtil.clientPlayer.get();
			if (message.data != null && player != null)
				of(player).deserializeNBT(player.registryAccess(), message.data.serializeNBT(player.registryAccess()));
		}

	}
}
