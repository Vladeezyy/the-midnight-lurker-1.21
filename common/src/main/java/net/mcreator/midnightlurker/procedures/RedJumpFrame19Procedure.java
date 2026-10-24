package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class RedJumpFrame19Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (MidnightlurkerModVariables.of(entity).JumpscareTimer == 28
				&& MidnightlurkerModVariables.of(entity).JumpscareActive == 1) {
			return true;
		}
		return false;
	}
}
