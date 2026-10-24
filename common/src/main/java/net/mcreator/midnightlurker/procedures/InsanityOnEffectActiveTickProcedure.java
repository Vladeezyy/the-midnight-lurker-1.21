package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.ViewportEvent;
import net.mcreator.midnightlurker.port.bus.Dist;

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
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) {
			if (entity instanceof Player) {
				if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
					_renderFog.setNearPlaneDistance(1);
					_renderFog.setFarPlaneDistance((float) net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("InsanityFog", 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) >= 53
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("InsanityFog", 0) >= 201) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", 200);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) >= 53
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("InsanityFog", 0) > 14) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("InsanityFog", 0) - 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) <= 52
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("InsanityFog", 0) < 200) {
					if (entity instanceof Player) {
						net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("InsanityFog", 0) + 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()))) {
			if (entity instanceof Player) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", 201);
			}
		} else if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) {
			if (entity instanceof Player && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("InsanityFog", 0) < 1) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", 201);
			}
		}
	}
}
