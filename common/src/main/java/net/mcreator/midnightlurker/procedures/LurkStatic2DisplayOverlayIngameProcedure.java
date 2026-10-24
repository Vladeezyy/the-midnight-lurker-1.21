package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class LurkStatic2DisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.STATIC_EFFECT.holder())
				&& (MidnightlurkerModVariables.of(entity).StaticRender == 1
						|| MidnightlurkerModVariables.of(entity).StaticRender == 3
						|| MidnightlurkerModVariables.of(entity).StaticRender == 5
						|| MidnightlurkerModVariables.of(entity).StaticRender == 7
						|| MidnightlurkerModVariables.of(entity).StaticRender == 9)) {
			return true;
		}
		return false;
	}
}
