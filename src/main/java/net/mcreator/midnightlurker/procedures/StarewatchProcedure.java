package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class StarewatchProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("StareCountdown") <= 400 && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
