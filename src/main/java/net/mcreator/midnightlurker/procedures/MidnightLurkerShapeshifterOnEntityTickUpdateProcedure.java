package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;

public class MidnightLurkerShapeshifterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("Shapeshifternumber") < 3) {
			entity.getPersistentData().putDouble("Shapeshifternumber", (entity.getPersistentData().getDouble("Shapeshifternumber") + 1));
		}
		if (entity.getPersistentData().getDouble("Shapeshifternumber") == 1 && entity.getPersistentData().getDouble("Shapeshifterrandom") < 1) {
			entity.getPersistentData().putDouble("Shapeshifterrandom", (Mth.nextInt(RandomSource.create(), 1, 3)));
		}
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("plains"))) {
			if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsarmorer");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsbutcher");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainslibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("taiga"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("old_growth_pine_taiga"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("old_growth_spruce_taiga"))) {
			if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigaarmorer");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigabutcher");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigalibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("savanna"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("savanna_plateau"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("windswept_savanna"))) {
			if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannaarmorer");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannabutcher");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannalibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("jungle"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("bamboo_jungle"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("sparse_jungle"))) {
			if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglearmorer");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglebutcher");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglelibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("desert"))) {
			if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertarmorer");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertbutcher");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertlibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("snowy_plains"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("snowy_plains"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("snowy_slopes"))) {
			if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowarmorer");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowbutcher");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowlibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("swamp"))) {
			if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamparmorer");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swampbutcher");
			} else if (entity.getPersistentData().getDouble("Shapeshifterrandom") == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamplibrarian");
			}
		}
	}
}
