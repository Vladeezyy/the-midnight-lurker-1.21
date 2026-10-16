package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import java.io.File;

public class ShowJump2DStage1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).JumpscareActive == 1
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 1) {
			return true;
		}
		return false;
	}
}
