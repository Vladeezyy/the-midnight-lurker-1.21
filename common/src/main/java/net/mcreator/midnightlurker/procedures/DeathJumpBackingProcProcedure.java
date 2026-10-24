package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class DeathJumpBackingProcProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (MidnightlurkerModVariables.of(entity).DeathJumpActive == 1
				&& MidnightlurkerModVariables.of(entity).DeathJumpTimer >= 40) {
			return true;
		}
		return false;
	}
}
