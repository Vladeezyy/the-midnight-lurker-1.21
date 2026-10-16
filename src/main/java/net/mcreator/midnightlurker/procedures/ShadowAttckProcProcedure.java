package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;

public class ShadowAttckProcProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 7, 7, 7), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
