package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class JumpscareFrame17Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (MidnightlurkerModVariables.of(entity).JumpscareTimer == 30
				&& MidnightlurkerModVariables.of(entity).JumpscareActive == 1) {
			return true;
		}
		return false;
	}
}
