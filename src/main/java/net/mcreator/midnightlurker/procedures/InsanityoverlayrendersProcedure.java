package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InsanityoverlayrendersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof Player) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 45
						&& entity.getPersistentData().getDoubleOr("InsanityOverlayTime", 0) >= 11) {
					entity.getPersistentData().putDouble("InsanityOverlayTime", 0);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) >= 45
						&& entity.getPersistentData().getDoubleOr("InsanityOverlayTime", 0) < 10) {
					entity.getPersistentData().putDouble("InsanityOverlayTime", (entity.getPersistentData().getDoubleOr("InsanityOverlayTime", 0) + 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY).getDuration() : 0) <= 44
						&& entity.getPersistentData().getDoubleOr("InsanityOverlayTime", 0) > 0) {
					if (entity instanceof Player) {
						entity.getPersistentData().putDouble("InsanityOverlayTime", (entity.getPersistentData().getDoubleOr("InsanityOverlayTime", 0) - 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MidnightlurkerModMobEffects.INSANITY))) {
			if (entity instanceof Player) {
				entity.getPersistentData().putDouble("InsanityOverlayTime", 11);
			}
		} else if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MidnightlurkerModMobEffects.INSANITY)) {
			if (entity instanceof Player && entity.getPersistentData().getDoubleOr("InsanityOverlayTime", 0) < 0) {
				entity.getPersistentData().putDouble("InsanityOverlayTime", 11);
			}
		}
	}
}
