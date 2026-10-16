package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

public class LurkStatic1DisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.STATIC_EFFECT.get())
				&& ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).StaticRender == 2
						|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).StaticRender == 4
						|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).StaticRender == 6
						|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).StaticRender == 8
						|| (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).StaticRender == 10)) {
			return true;
		}
		return false;
	}
}
