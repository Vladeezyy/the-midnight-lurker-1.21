package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.PlayerTickEvent;

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
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) {
			if (entity instanceof Player) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) >= 45
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityOverlayTime") >= 11) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityOverlayTime", 0);
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) >= 45
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityOverlayTime") < 10) {
					net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityOverlayTime", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityOverlayTime") + 1));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()) ? _livEnt.getEffect(MidnightlurkerModMobEffects.INSANITY.holder()).getDuration() : 0) <= 44
						&& net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityOverlayTime") > 0) {
					if (entity instanceof Player) {
						net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityOverlayTime", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityOverlayTime") - 1));
					}
				}
			}
		}
		if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder()))) {
			if (entity instanceof Player) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityOverlayTime", 11);
			}
		} else if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) {
			if (entity instanceof Player && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDouble("InsanityOverlayTime") < 0) {
				net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InsanityOverlayTime", 11);
			}
		}
	}
}
