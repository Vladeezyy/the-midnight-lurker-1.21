
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, MidnightlurkerMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERDISAPPEAR = REGISTRY.register("lurkerdisappear", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerdisappear")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERCHASE = REGISTRY.register("lurkerchase", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerchase")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERINVISIBLEJUMPSCARE = REGISTRY.register("lurkerinvisiblejumpscare", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerinvisiblejumpscare")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERCHASE2 = REGISTRY.register("lurkerchase2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerchase2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERPREFINALBREAK = REGISTRY.register("lurkerprefinalbreak", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerprefinalbreak")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERFINALBREAK = REGISTRY.register("lurkerfinalbreak", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerfinalbreak")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SPOOKYAMBIENCE = REGISTRY.register("spookyambience", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "spookyambience")));
	public static final DeferredHolder<SoundEvent, SoundEvent> INSANITYGOESBACKSOUND = REGISTRY.register("insanitygoesbacksound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "insanitygoesbacksound")));
	public static final DeferredHolder<SoundEvent, SoundEvent> INSANITYAMBIENCE = REGISTRY.register("insanityambience", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "insanityambience")));
	public static final DeferredHolder<SoundEvent, SoundEvent> INSANITYCHASE = REGISTRY.register("insanitychase", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "insanitychase")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERBREAKINGBLOCK = REGISTRY.register("lurkerbreakingblock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerbreakingblock")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERDISTANTSCREAM = REGISTRY.register("lurkerdistantscream", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerdistantscream")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERDEATH = REGISTRY.register("lurkerdeath", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerdeath")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERDEATHJUMPSCARE = REGISTRY.register("lurkerdeathjumpscare", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerdeathjumpscare")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERSCREAM = REGISTRY.register("lurkerscream", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerscream")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERAMBIENT = REGISTRY.register("lurkerambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERCHASESTEPS = REGISTRY.register("lurkerchasesteps", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerchasesteps")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERJUMPSCARE = REGISTRY.register("lurkerjumpscare", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerjumpscare")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERHURT = REGISTRY.register("lurkerhurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerhurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NOSTEPSOUND = REGISTRY.register("nostepsound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "nostepsound")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VOIDHANDS_AGGRO = REGISTRY.register("voidhands_aggro", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "voidhands_aggro")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VOIDHANDS_DEATH = REGISTRY.register("voidhands_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "voidhands_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VOIDHANDS_HURT = REGISTRY.register("voidhands_hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "voidhands_hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VOIDHANDS_SHRIEK = REGISTRY.register("voidhands_shriek", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "voidhands_shriek")));
	public static final DeferredHolder<SoundEvent, SoundEvent> STATIC = REGISTRY.register("static", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "static")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PHANTOM_HEAD_SCREAM = REGISTRY.register("phantom_head_scream", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "phantom_head_scream")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERFOOTSTEPS = REGISTRY.register("lurkerfootsteps", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkerfootsteps")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THIRTEEN_AMBIENT = REGISTRY.register("thirteen_ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "thirteen_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKERANGER = REGISTRY.register("lurkeranger", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurkeranger")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKER_STUNNED = REGISTRY.register("lurker_stunned", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurker_stunned")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKER_TAUNT = REGISTRY.register("lurker_taunt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurker_taunt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LURKER_STUN_OVER = REGISTRY.register("lurker_stun_over", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "lurker_stun_over")));
	public static final DeferredHolder<SoundEvent, SoundEvent> OUTCASTVILLAGER_HIT = REGISTRY.register("outcastvillager_hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "outcastvillager_hit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> OUTCASTVILLAGER_DEATH = REGISTRY.register("outcastvillager_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "outcastvillager_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> OUTCASTVILLAGER_IDLE = REGISTRY.register("outcastvillager_idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("midnightlurker", "outcastvillager_idle")));
}
