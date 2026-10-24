/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.mcreator.midnightlurker;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.mcreator.midnightlurker.port.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModTabs;
import net.mcreator.midnightlurker.init.MidnightlurkerModSounds;
import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.init.MidnightlurkerModMenus;
import net.mcreator.midnightlurker.init.MidnightlurkerModItems;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.init.MidnightlurkerModBlocks;
import net.mcreator.midnightlurker.init.MidnightlurkerModBlockEntities;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

@Mod("midnightlurker")
public class MidnightlurkerMod {
	public static final Logger LOGGER = LogManager.getLogger(MidnightlurkerMod.class);
	public static final String MODID = "midnightlurker";

	public MidnightlurkerMod(IEventBus modEventBus) {
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		MidnightlurkerModSounds.REGISTRY.register(modEventBus);
		MidnightlurkerModBlocks.REGISTRY.register(modEventBus);
		MidnightlurkerModBlockEntities.REGISTRY.register(modEventBus);
		MidnightlurkerModItems.REGISTRY.register(modEventBus);
		MidnightlurkerModEntities.REGISTRY.register(modEventBus);
		MidnightlurkerModTabs.REGISTRY.register(modEventBus);
		MidnightlurkerModVariables.ATTACHMENT_TYPES.register(modEventBus);
		MidnightlurkerModMobEffects.REGISTRY.register(modEventBus);
		MidnightlurkerModParticleTypes.REGISTRY.register(modEventBus);
		MidnightlurkerModMenus.REGISTRY.register(modEventBus);
	}

	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	// NeoForge 21.9+: the client side of clientbound payloads is registered by the client (port/ClientNetworking)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void registerClientHandlers(net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent event) {
		MESSAGES.forEach((id, networkMessage) -> event.register((CustomPacketPayload.Type) id, ((NetworkMessage) networkMessage).handler()));
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}
}
