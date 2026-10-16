
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.midnightlurker.client.particle.VoidGatewayParticleParticle;
import net.mcreator.midnightlurker.client.particle.VoidDotParticle;
import net.mcreator.midnightlurker.client.particle.LurkerfaceparticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MidnightlurkerModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(MidnightlurkerModParticleTypes.VOID_GATEWAY_PARTICLE.get(), VoidGatewayParticleParticle::provider);
		event.registerSpriteSet(MidnightlurkerModParticleTypes.VOID_DOT.get(), VoidDotParticle::provider);
		event.registerSpriteSet(MidnightlurkerModParticleTypes.LURKERFACEPARTICLE.get(), LurkerfaceparticleParticle::provider);
	}
}
