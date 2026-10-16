package net.mcreator.midnightlurker.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MidnightlurkerModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MidnightlurkerMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		MidnightlurkerMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					MidnightlurkerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					MidnightlurkerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					MidnightlurkerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
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

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
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
		public CompoundTag save(CompoundTag nbt) {
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
			if (world instanceof Level level && !level.isClientSide())
				MidnightlurkerMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "midnightlurker_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				MidnightlurkerMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("midnightlurker", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
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

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				MidnightlurkerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
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

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
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
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.DeathJumpActive = message.data.DeathJumpActive;
					variables.DeathJumpTimer = message.data.DeathJumpTimer;
					variables.DeathJumpShake = message.data.DeathJumpShake;
					variables.ScreenShake = message.data.ScreenShake;
					variables.InsanityStage = message.data.InsanityStage;
					variables.InsanityTimer = message.data.InsanityTimer;
					variables.InsanityAktive = message.data.InsanityAktive;
					variables.InsanityReset = message.data.InsanityReset;
					variables.JumpscareActive = message.data.JumpscareActive;
					variables.JumpscareTimer = message.data.JumpscareTimer;
					variables.JumpscareRandom = message.data.JumpscareRandom;
					variables.StaticRender = message.data.StaticRender;
					variables.encounternumber = message.data.encounternumber;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
