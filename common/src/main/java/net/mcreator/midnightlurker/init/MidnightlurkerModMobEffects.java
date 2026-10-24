
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.midnightlurker.potion.StaticEffectMobEffect;
import net.mcreator.midnightlurker.potion.LurkerAngeredMobEffect;
import net.mcreator.midnightlurker.potion.InsanityShowinInvMobEffect;
import net.mcreator.midnightlurker.potion.InsanityMobEffect;
import net.mcreator.midnightlurker.potion.InsanityFacesMobEffect;
import net.mcreator.midnightlurker.potion.AmnesiaShowInInvMobEffect;
import net.mcreator.midnightlurker.potion.AmnesiaMobEffect;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModMobEffects {
	public static final Registrar<MobEffect> REGISTRY = Registrar.create(Registries.MOB_EFFECT, MidnightlurkerMod.MODID);
	public static final RegistryEntry<MobEffect, MobEffect> INSANITY = REGISTRY.register("insanity", () -> new InsanityMobEffect());
	public static final RegistryEntry<MobEffect, MobEffect> INSANITY_FACES = REGISTRY.register("insanity_faces", () -> new InsanityFacesMobEffect());
	public static final RegistryEntry<MobEffect, MobEffect> LURKER_ANGERED = REGISTRY.register("lurker_angered", () -> new LurkerAngeredMobEffect());
	public static final RegistryEntry<MobEffect, MobEffect> AMNESIA = REGISTRY.register("amnesia", () -> new AmnesiaMobEffect());
	public static final RegistryEntry<MobEffect, MobEffect> STATIC_EFFECT = REGISTRY.register("static_effect", () -> new StaticEffectMobEffect());
	public static final RegistryEntry<MobEffect, MobEffect> AMNESIA_SHOW_IN_INV = REGISTRY.register("amnesia_show_in_inv", () -> new AmnesiaShowInInvMobEffect());
	public static final RegistryEntry<MobEffect, MobEffect> INSANITY_SHOWIN_INV = REGISTRY.register("insanity_showin_inv", () -> new InsanityShowinInvMobEffect());
}
