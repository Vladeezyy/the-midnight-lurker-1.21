
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.midnightlurker.client.particle.VoidGatewayParticleParticle;
import net.mcreator.midnightlurker.client.particle.VoidDotParticle;
import net.mcreator.midnightlurker.client.particle.LurkerfaceparticleParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MidnightlurkerModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE.get(), VoidGatewayParticleParticle::provider);
		event.registerSpriteSet(MidnightlurkerModParticleTypes.VOID_DOT.get(), VoidDotParticle::provider);
		event.registerSpriteSet(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE.get(), LurkerfaceparticleParticle::provider);
	}
}
