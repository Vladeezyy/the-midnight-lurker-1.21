package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class JumpscarerFrame25Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareTimer == 15
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareActive == 1) {
			return true;
		} else if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareTimer == 5
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareActive == 1) {
			return true;
		}
		return false;
	}
}
