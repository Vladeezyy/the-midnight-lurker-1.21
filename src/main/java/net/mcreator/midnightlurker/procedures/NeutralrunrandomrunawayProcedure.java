package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class NeutralrunrandomrunawayProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (MidnightlurkerModVariables.WorldVariables.get(world).NeutralrunRandom > 5) {
			return true;
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 13, 13, 13), e -> true).isEmpty()) {
			return true;
		}
		return false;
	}
}
