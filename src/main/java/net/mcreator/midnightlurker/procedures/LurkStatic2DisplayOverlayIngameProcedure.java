package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class LurkStatic2DisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.STATIC_EFFECT)
				&& (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender == 1
						|| entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender == 3
						|| entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender == 5
						|| entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender == 7
						|| entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender == 9)) {
			return true;
		}
		return false;
	}
}
