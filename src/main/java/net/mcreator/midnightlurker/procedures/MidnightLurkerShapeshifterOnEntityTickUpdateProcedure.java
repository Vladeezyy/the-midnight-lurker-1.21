package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;

public class MidnightLurkerShapeshifterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDoubleOr("Shapeshifternumber", 0) < 3) {
			entity.getPersistentData().putDouble("Shapeshifternumber", (entity.getPersistentData().getDoubleOr("Shapeshifternumber", 0) + 1));
		}
		if (entity.getPersistentData().getDoubleOr("Shapeshifternumber", 0) == 1 && entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) < 1) {
			entity.getPersistentData().putDouble("Shapeshifterrandom", (Mth.nextInt(RandomSource.create(), 1, 3)));
		}
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("plains"))) {
			if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsarmorer");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsbutcher");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainslibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("taiga"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("old_growth_pine_taiga"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("old_growth_spruce_taiga"))) {
			if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigaarmorer");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigabutcher");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigalibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("savanna"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("savanna_plateau"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("windswept_savanna"))) {
			if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannaarmorer");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannabutcher");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannalibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("jungle"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("bamboo_jungle"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("sparse_jungle"))) {
			if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglearmorer");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglebutcher");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglelibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("desert"))) {
			if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertarmorer");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertbutcher");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertlibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("snowy_plains"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("snowy_plains"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("snowy_slopes"))) {
			if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowarmorer");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowbutcher");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowlibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("swamp"))) {
			if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamparmorer");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swampbutcher");
			} else if (entity.getPersistentData().getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamplibrarian");
			}
		}
	}
}
