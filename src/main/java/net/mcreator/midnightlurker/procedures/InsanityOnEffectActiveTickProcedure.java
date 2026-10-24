package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FogType;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber(value = {Dist.CLIENT})
public class InsanityOnEffectActiveTickProcedure {
	@SubscribeEvent
	public static void renderFog(ViewportEvent.RenderFog event) {
		try {
			// 1.21.6: the terrain fog is the atmospheric environment fog (the camera is not in a fluid)
			if (event.getType() == FogType.ATMOSPHERIC) {
				Entity entity = event.getCamera().entity();
				execute(null, entity, event);
			}
		} catch (Exception e) {
		}
	}

	public static void execute(Entity entity, ViewportEvent viewport) {
		execute(null, entity, viewport);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent viewport) {
		if (entity == null || viewport == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof Player) {
				if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
					_renderFog.setNearPlaneDistance(1);
					_renderFog.setFarPlaneDistance((float) entity.getPersistentData().getDoubleOr("InsanityFog", 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
						&& entity.getPersistentData().getDoubleOr("InsanityFog", 0) >= 201) {
					entity.getPersistentData().putDouble("InsanityFog", 200);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 53
						&& entity.getPersistentData().getDoubleOr("InsanityFog", 0) > 14) {
					entity.getPersistentData().putDouble("InsanityFog", (entity.getPersistentData().getDoubleOr("InsanityFog", 0) - 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 52
						&& entity.getPersistentData().getDoubleOr("InsanityFog", 0) < 200) {
					if (entity instanceof Player) {
						entity.getPersistentData().putDouble("InsanityFog", (entity.getPersistentData().getDoubleOr("InsanityFog", 0) + 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MidnightlurkerModMobEffects.INSANITY))) {
			if (entity instanceof Player) {
				entity.getPersistentData().putDouble("InsanityFog", 201);
			}
		} else if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof Player && entity.getPersistentData().getDoubleOr("InsanityFog", 0) < 1) {
				entity.getPersistentData().putDouble("InsanityFog", 201);
			}
		}
	}
}
