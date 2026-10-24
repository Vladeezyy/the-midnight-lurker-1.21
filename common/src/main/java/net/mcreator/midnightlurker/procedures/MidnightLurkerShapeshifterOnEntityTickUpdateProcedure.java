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
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifternumber", 0) < 3) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("Shapeshifternumber", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifternumber", 0) + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifternumber", 0) == 1 && net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) < 1) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("Shapeshifterrandom", (Mth.nextInt(RandomSource.create(), 1, 3)));
		}
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("plains"))) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsarmorer");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainsbutcher");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("plainslibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("taiga"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("old_growth_pine_taiga"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("old_growth_spruce_taiga"))) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigaarmorer");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigabutcher");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("taigalibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("savanna"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("savanna_plateau"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("windswept_savanna"))) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannaarmorer");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannabutcher");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("savannalibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("jungle"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("bamboo_jungle"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("sparse_jungle"))) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglearmorer");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglebutcher");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("junglelibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("desert"))) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertarmorer");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertbutcher");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("desertlibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("snowy_plains"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("snowy_plains"))
				|| world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("snowy_slopes"))) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowarmorer");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowbutcher");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("snowlibrarian");
			}
		} else if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(Identifier.parse("swamp"))) {
			if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 1) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamparmorer");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 2) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swampbutcher");
			} else if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("Shapeshifterrandom", 0) == 3) {
				if (entity instanceof MidnightLurkerShapeshifterEntity animatable)
					animatable.setTexture("swamplibrarian");
			}
		}
	}
}
