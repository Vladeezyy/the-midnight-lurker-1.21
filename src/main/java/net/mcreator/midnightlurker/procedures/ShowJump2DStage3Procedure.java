package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import java.io.File;

public class ShowJump2DStage3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).JumpscareActive == 1
				&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 3) {
			return true;
		}
		return false;
	}
}
