package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

public class LurkerinwaterconditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.isInWater()) {
			return true;
		}
		return false;
	}
}
