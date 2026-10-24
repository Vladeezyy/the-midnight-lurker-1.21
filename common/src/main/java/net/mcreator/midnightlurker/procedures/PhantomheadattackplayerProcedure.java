package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

public class PhantomheadattackplayerProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("lookingatphantomhead", 0) > 0 || net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("AttackOnSight", 0) == 50) {
			return true;
		}
		return false;
	}
}
