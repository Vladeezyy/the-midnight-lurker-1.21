package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

public class StarerunProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDoubleOr("StareCountdown", 0) == 401) {
			return true;
		}
		return false;
	}
}
