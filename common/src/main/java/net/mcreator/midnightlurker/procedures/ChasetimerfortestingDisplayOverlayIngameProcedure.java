package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class ChasetimerfortestingDisplayOverlayIngameProcedure {
	public static boolean execute(LevelAccessor world) {
		if (MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay == true) {
			return true;
		} else if (MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay == false) {
			return false;
		}
		return false;
	}
}
