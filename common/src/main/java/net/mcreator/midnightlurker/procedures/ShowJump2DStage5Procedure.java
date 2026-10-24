package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import java.io.File;

public class ShowJump2DStage5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		if (MidnightlurkerModVariables.of(entity).JumpscareActive == 1
				&& MidnightlurkerModVariables.of(entity).InsanityStage == 5) {
			return true;
		}
		return false;
	}
}
