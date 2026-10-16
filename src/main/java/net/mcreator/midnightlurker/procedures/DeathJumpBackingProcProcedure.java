package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class DeathJumpBackingProcProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).DeathJumpActive == 1
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).DeathJumpTimer >= 40) {
			return true;
		}
		return false;
	}
}
