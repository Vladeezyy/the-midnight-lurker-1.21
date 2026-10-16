package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MidnightLurkerAggressiveCrawlingPlayReturnedAnimationProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		if (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x + 1, y + 1, z)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.EAST) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return "climb3";
			}
		} else if (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x - 1, y + 1, z)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.WEST) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return "climb3";
			}
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z + 1)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.SOUTH) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return "climb3";
			}
		} else if (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z - 1)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) && (entity.getDirection()) == Direction.NORTH) {
			if (entity.getDeltaMovement().y() == 0.2) {
				return "climb3";
			}
		}
		return "empty";
	}
}
