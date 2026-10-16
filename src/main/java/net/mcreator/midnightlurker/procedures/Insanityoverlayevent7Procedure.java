package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class Insanityoverlayevent7Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.get())) {
			if (entity instanceof Player) {
				if (entity.getPersistentData().getDouble("InsanityOverlayTime") == 7) {
					return true;
				}
			}
		}
		return false;
	}
}
