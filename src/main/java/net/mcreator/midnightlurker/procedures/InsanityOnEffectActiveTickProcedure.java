package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
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
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())) {
			if (entity instanceof Player) {
				if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
					_renderFog.setNearPlaneDistance(1);
					_renderFog.setFarPlaneDistance((float) entity.getPersistentData().getDouble("InsanityFog"));
				}
				if (viewport instanceof ViewportEvent.RenderFog _renderFog) {
					_renderFog.setFogShape(FogShape.SPHERE);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) >= 53
						&& entity.getPersistentData().getDouble("InsanityFog") >= 201) {
					entity.getPersistentData().putDouble("InsanityFog", 200);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) >= 53
						&& entity.getPersistentData().getDouble("InsanityFog") > 14) {
					entity.getPersistentData().putDouble("InsanityFog", (entity.getPersistentData().getDouble("InsanityFog") - 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) <= 52
						&& entity.getPersistentData().getDouble("InsanityFog") < 200) {
					if (entity instanceof Player) {
						entity.getPersistentData().putDouble("InsanityFog", (entity.getPersistentData().getDouble("InsanityFog") + 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()))) {
			if (entity instanceof Player) {
				entity.getPersistentData().putDouble("InsanityFog", 201);
			}
		} else if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())) {
			if (entity instanceof Player && entity.getPersistentData().getDouble("InsanityFog") < 1) {
				entity.getPersistentData().putDouble("InsanityFog", 201);
			}
		}
	}
}
