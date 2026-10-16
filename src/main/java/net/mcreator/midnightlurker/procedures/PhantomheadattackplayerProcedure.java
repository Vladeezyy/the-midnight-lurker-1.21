package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

public class PhantomheadattackplayerProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("lookingatphantomhead") > 0 || entity.getPersistentData().getDouble("AttackOnSight") == 50) {
			return true;
		}
		return false;
	}
}
