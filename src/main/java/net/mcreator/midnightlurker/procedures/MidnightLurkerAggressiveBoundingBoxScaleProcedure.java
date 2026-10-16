package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class MidnightLurkerAggressiveBoundingBoxScaleProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x + 1, y + 1, z)).canOcclude() && (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x + 1, y + 2, z)).canOcclude()
						|| (world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
								&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.3;
		} else if (!world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x - 1, y + 1, z)).canOcclude() && (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x - 1, y + 2, z)).canOcclude()
						|| (world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.3;
		} else if (!world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 1, z + 1)).canOcclude() && (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 2, z + 1)).canOcclude()
						|| (world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
								&& (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.3;
		} else if (!world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 1)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 1, z - 1)).canOcclude() && (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 2, z - 1)).canOcclude()
						|| (world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
								&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.3;
		}
		if (!world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x + 1, y + 1, z)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x + 1, y + 2, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x + 1, y + 1, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x + 1, y + 3, z)).canOcclude()
								|| (world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.7;
		} else if (!world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x - 1, y + 1, z)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x - 1, y + 2, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x - 1, y + 1, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x - 1, y + 3, z)).canOcclude()
								|| (world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.7;
		} else if (!world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z + 1)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x, y + 2, z + 1)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 2, z + 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z + 1)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 0, z + 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 3, z + 1)).canOcclude()
								|| (world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.7;
		} else if (!world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z - 1)).canOcclude()
				&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 1)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 0, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(BlockPos.containing(x, y + 2, z - 1)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 1, z - 1)).canOcclude()
						&& (world.getBlockState(BlockPos.containing(x, y + 0, z - 1)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 3, z - 1)).canOcclude()
								|| (world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.7;
		}
		return 1;
	}
}
