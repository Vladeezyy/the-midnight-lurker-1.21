package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import java.io.File;

public class ShowJump2Stage3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		if (MidnightlurkerModVariables.of(entity).JumpscareActive == 1
				&& MidnightlurkerModVariables.of(entity).InsanityStage == 3
				&& MidnightlurkerModVariables.of(entity).JumpscareRandom == 1) {
			return true;
		}
		return false;
	}
}
