
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModSounds {
	public static final Registrar<SoundEvent> REGISTRY = Registrar.create(Registries.SOUND_EVENT, MidnightlurkerMod.MODID);
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERDISAPPEAR = REGISTRY.register("lurkerdisappear", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerdisappear")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERCHASE = REGISTRY.register("lurkerchase", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerchase")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERINVISIBLEJUMPSCARE = REGISTRY.register("lurkerinvisiblejumpscare", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerinvisiblejumpscare")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERCHASE2 = REGISTRY.register("lurkerchase2", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerchase2")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERPREFINALBREAK = REGISTRY.register("lurkerprefinalbreak", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerprefinalbreak")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERFINALBREAK = REGISTRY.register("lurkerfinalbreak", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerfinalbreak")));
	public static final RegistryEntry<SoundEvent, SoundEvent> SPOOKYAMBIENCE = REGISTRY.register("spookyambience", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "spookyambience")));
	public static final RegistryEntry<SoundEvent, SoundEvent> INSANITYGOESBACKSOUND = REGISTRY.register("insanitygoesbacksound", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "insanitygoesbacksound")));
	public static final RegistryEntry<SoundEvent, SoundEvent> INSANITYAMBIENCE = REGISTRY.register("insanityambience", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "insanityambience")));
	public static final RegistryEntry<SoundEvent, SoundEvent> INSANITYCHASE = REGISTRY.register("insanitychase", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "insanitychase")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERBREAKINGBLOCK = REGISTRY.register("lurkerbreakingblock", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerbreakingblock")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERDISTANTSCREAM = REGISTRY.register("lurkerdistantscream", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerdistantscream")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERDEATH = REGISTRY.register("lurkerdeath", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerdeath")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERDEATHJUMPSCARE = REGISTRY.register("lurkerdeathjumpscare", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerdeathjumpscare")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERSCREAM = REGISTRY.register("lurkerscream", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerscream")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERAMBIENT = REGISTRY.register("lurkerambient", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerambient")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERCHASESTEPS = REGISTRY.register("lurkerchasesteps", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerchasesteps")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERJUMPSCARE = REGISTRY.register("lurkerjumpscare", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerjumpscare")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERHURT = REGISTRY.register("lurkerhurt", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerhurt")));
	public static final RegistryEntry<SoundEvent, SoundEvent> NOSTEPSOUND = REGISTRY.register("nostepsound", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "nostepsound")));
	public static final RegistryEntry<SoundEvent, SoundEvent> VOIDHANDS_AGGRO = REGISTRY.register("voidhands_aggro", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "voidhands_aggro")));
	public static final RegistryEntry<SoundEvent, SoundEvent> VOIDHANDS_DEATH = REGISTRY.register("voidhands_death", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "voidhands_death")));
	public static final RegistryEntry<SoundEvent, SoundEvent> VOIDHANDS_HURT = REGISTRY.register("voidhands_hurt", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "voidhands_hurt")));
	public static final RegistryEntry<SoundEvent, SoundEvent> VOIDHANDS_SHRIEK = REGISTRY.register("voidhands_shriek", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "voidhands_shriek")));
	public static final RegistryEntry<SoundEvent, SoundEvent> STATIC = REGISTRY.register("static", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "static")));
	public static final RegistryEntry<SoundEvent, SoundEvent> PHANTOM_HEAD_SCREAM = REGISTRY.register("phantom_head_scream", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "phantom_head_scream")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERFOOTSTEPS = REGISTRY.register("lurkerfootsteps", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkerfootsteps")));
	public static final RegistryEntry<SoundEvent, SoundEvent> THIRTEEN_AMBIENT = REGISTRY.register("thirteen_ambient", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "thirteen_ambient")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKERANGER = REGISTRY.register("lurkeranger", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurkeranger")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKER_STUNNED = REGISTRY.register("lurker_stunned", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurker_stunned")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKER_TAUNT = REGISTRY.register("lurker_taunt", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurker_taunt")));
	public static final RegistryEntry<SoundEvent, SoundEvent> LURKER_STUN_OVER = REGISTRY.register("lurker_stun_over", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "lurker_stun_over")));
	public static final RegistryEntry<SoundEvent, SoundEvent> OUTCASTVILLAGER_HIT = REGISTRY.register("outcastvillager_hit", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "outcastvillager_hit")));
	public static final RegistryEntry<SoundEvent, SoundEvent> OUTCASTVILLAGER_DEATH = REGISTRY.register("outcastvillager_death", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "outcastvillager_death")));
	public static final RegistryEntry<SoundEvent, SoundEvent> OUTCASTVILLAGER_IDLE = REGISTRY.register("outcastvillager_idle", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("midnightlurker", "outcastvillager_idle")));
}
