
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModParticleTypes {
	public static final Registrar<ParticleType<?>> REGISTRY = Registrar.create(Registries.PARTICLE_TYPE, MidnightlurkerMod.MODID);
	public static final RegistryEntry<ParticleType<?>, SimpleParticleType> VOID_GATEWAY_PARTICLE = REGISTRY.register("void_gateway_particle", () -> new SimpleParticleType(true) {});
	public static final RegistryEntry<ParticleType<?>, SimpleParticleType> VOID_DOT = REGISTRY.register("void_dot", () -> new SimpleParticleType(true) {});
	public static final RegistryEntry<ParticleType<?>, SimpleParticleType> LURKERFACEPARTICLE = REGISTRY.register("lurkerfaceparticle", () -> new SimpleParticleType(true) {});
}
