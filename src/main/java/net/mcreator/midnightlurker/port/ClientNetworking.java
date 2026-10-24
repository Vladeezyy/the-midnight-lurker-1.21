package net.mcreator.midnightlurker.port;

import net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.midnightlurker.MidnightlurkerMod;

/** Client handlers of the mod's payloads (the same handlers, which check the packet flow themselves). */
@EventBusSubscriber(value = Dist.CLIENT)
public final class ClientNetworking {
	@SubscribeEvent
	public static void registerClientHandlers(RegisterClientPayloadHandlersEvent event) {
		MidnightlurkerMod.registerClientHandlers(event);
	}

	private ClientNetworking() {
	}
}
