package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.ViewportEvent;
import net.mcreator.midnightlurker.port.bus.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@EventBusSubscriber(value = {Dist.CLIENT})
public class InsanityOnEffectActiveTickProcedure {
	@SubscribeEvent
	public static void renderFog(ViewportEvent.RenderFog event) {
		try {
			if (event.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
				ClientLevel clientLevel = Minecraft.getInstance().level;
				Entity entity = event.getCamera().getEntity();
				execute(null, entity, event);
				event.setCanceled(true);
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
					_renderFog.setFarPlaneDistance((float) net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityFog"));
				}
				if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
					_renderFog.setFogShape(FogShape.SPHERE);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) >= 53
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityFog") >= 201) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", 200);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) >= 53
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityFog") > 14) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityFog") - 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) <= 52
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityFog") < 200) {
					if (entity instanceof Player) {
						net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityFog") + 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()))) {
			if (entity instanceof Player) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", 201);
			}
		} else if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) {
			if (entity instanceof Player && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityFog") < 1) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityFog", 201);
			}
		}
	}
}
