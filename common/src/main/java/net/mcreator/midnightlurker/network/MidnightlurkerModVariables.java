package net.mcreator.midnightlurker.network;

import net.mcreator.midnightlurker.port.bus.PlayerEvent;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.midnightlurker.MidnightlurkerMod;
import net.mcreator.midnightlurker.port.PortUtil;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.PlayerEvent;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.platform.Platform;


public class MidnightlurkerModVariables {
	/** The id of the player variables attachment (NeoForge and Fabric), as in 3.3.7 */
	public static final ResourceLocation PLAYER_VARIABLES_ID = ResourceLocation.fromNamespaceAndPath(MidnightlurkerMod.MODID, "player_variables");

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
			midnightlurkeroverhauledrewardrandom = nbt.getDouble("midnightlurkeroverhauledrewardrandom");
			midnightlurkeroverhauledinsanitytimer = nbt.getDouble("midnightlurkeroverhauledinsanitytimer");
			midnightlurkeroverhauledinstage = nbt.getDouble("midnightlurkeroverhauledinstage");
			midnightlurkerinsanitytimactivate = nbt.getDouble("midnightlurkerinsanitytimactivate");
			midnightlurkerinsanityactive = nbt.getDouble("midnightlurkerinsanityactive");
			NeutralrunRandom = nbt.getDouble("NeutralrunRandom");
			midnighthealthboost = nbt.getDouble("midnighthealthboost");
			lurkerdevoverlay = nbt.getBoolean("lurkerdevoverlay");
		}

		@Override
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
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load, null), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "midnightlurker_mapvars";

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
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
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load, null), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MidnightlurkerMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
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
					MapVariables.clientSide.read(message.data.save(new CompoundTag(), registries), registries);
				else
					WorldVariables.clientSide.read(message.data.save(new CompoundTag(), registries), registries);
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
			DeathJumpActive = nbt.getDouble("DeathJumpActive");
			DeathJumpTimer = nbt.getDouble("DeathJumpTimer");
			DeathJumpShake = nbt.getDouble("DeathJumpShake");
			ScreenShake = nbt.getDouble("ScreenShake");
			InsanityStage = nbt.getDouble("InsanityStage");
			InsanityTimer = nbt.getDouble("InsanityTimer");
			InsanityAktive = nbt.getDouble("InsanityAktive");
			InsanityReset = nbt.getDouble("InsanityReset");
			JumpscareActive = nbt.getDouble("JumpscareActive");
			JumpscareTimer = nbt.getDouble("JumpscareTimer");
			JumpscareRandom = nbt.getDouble("JumpscareRandom");
			StaticRender = nbt.getDouble("StaticRender");
			encounternumber = nbt.getDouble("encounternumber");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				Platform.INSTANCE.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MidnightlurkerMod.MODID, "player_variables_sync"));
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
