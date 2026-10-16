package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class JumpscarerFrame26Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareTimer == 14
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareActive == 1) {
			return true;
		} else if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareTimer == 6
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareActive == 1) {
			return true;
		}
		return false;
	}
}
