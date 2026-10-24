package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

public class PhantomheadattackplayerProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDoubleOr("lookingatphantomhead", 0) > 0 || entity.getPersistentData().getDoubleOr("AttackOnSight", 0) == 50) {
			return true;
		}
		return false;
	}
}
