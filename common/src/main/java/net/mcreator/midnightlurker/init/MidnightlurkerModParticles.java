
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.RegisterParticleProvidersEvent;
import net.mcreator.midnightlurker.port.bus.Dist;

import net.mcreator.midnightlurker.client.particle.VoidGatewayParticleParticle;
import net.mcreator.midnightlurker.client.particle.VoidDotParticle;
import net.mcreator.midnightlurker.client.particle.LurkerfaceparticleParticle;

@EventBusSubscriber(value = Dist.CLIENT)
public class MidnightlurkerModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE.get(), VoidGatewayParticleParticle::provider);
		event.registerSpriteSet(MidnightlurkerModParticleTypes.VOID_DOT.get(), VoidDotParticle::provider);
		event.registerSpriteSet(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE.get(), LurkerfaceparticleParticle::provider);
	}
}
