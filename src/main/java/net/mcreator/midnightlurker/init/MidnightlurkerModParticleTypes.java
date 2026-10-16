
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MidnightlurkerMod.MODID);
	public static final RegistryObject<SimpleParticleType> VOID_GATEWAY_PARTICLE = REGISTRY.register("void_gateway_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> VOID_DOT = REGISTRY.register("void_dot", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> LURKERFACEPARTICLE = REGISTRY.register("lurkerfaceparticle", () -> new SimpleParticleType(true));
}
