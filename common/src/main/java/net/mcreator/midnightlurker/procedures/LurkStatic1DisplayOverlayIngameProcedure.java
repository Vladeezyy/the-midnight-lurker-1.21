package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class LurkStatic1DisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.STATIC_EFFECT.holder())
				&& (MidnightlurkerModVariables.of(entity).StaticRender == 2
						|| MidnightlurkerModVariables.of(entity).StaticRender == 4
						|| MidnightlurkerModVariables.of(entity).StaticRender == 6
						|| MidnightlurkerModVariables.of(entity).StaticRender == 8
						|| MidnightlurkerModVariables.of(entity).StaticRender == 10)) {
			return true;
		}
		return false;
	}
}
