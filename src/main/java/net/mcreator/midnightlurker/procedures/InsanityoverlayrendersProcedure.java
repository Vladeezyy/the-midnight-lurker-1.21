package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class InsanityoverlayrendersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())) {
			if (entity instanceof Player) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) >= 45
						&& entity.getPersistentData().getDouble("InsanityOverlayTime") >= 11) {
					entity.getPersistentData().putDouble("InsanityOverlayTime", 0);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) >= 45
						&& entity.getPersistentData().getDouble("InsanityOverlayTime") < 10) {
					entity.getPersistentData().putDouble("InsanityOverlayTime", (entity.getPersistentData().getDouble("InsanityOverlayTime") + 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.get()).getDuration() : 0) <= 44
						&& entity.getPersistentData().getDouble("InsanityOverlayTime") > 0) {
					if (entity instanceof Player) {
						entity.getPersistentData().putDouble("InsanityOverlayTime", (entity.getPersistentData().getDouble("InsanityOverlayTime") - 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MidnightlurkerModMobEffects.INSANITY.get()))) {
			if (entity instanceof Player) {
				entity.getPersistentData().putDouble("InsanityOverlayTime", 11);
			}
		} else if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())) {
			if (entity instanceof Player && entity.getPersistentData().getDouble("InsanityOverlayTime") < 0) {
				entity.getPersistentData().putDouble("InsanityOverlayTime", 11);
			}
		}
	}
}
