package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.midnightlurker.init.MidnightlurkerModParticleTypes;

import java.io.File;

public class InsanityFacesEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File lurker = new File("");
		if (Math.random() > 0.7) {
			world.addParticle((SimpleParticleType) (MidnightlurkerModParticleTypes.LURKERFACEPARTICLE.get()), (x + Mth.nextDouble(RandomSource.create(), -6, 6)), (y + Mth.nextDouble(RandomSource.create(), 0, 6)),
					(z + Mth.nextDouble(RandomSource.create(), -6, 6)), 0, 0, 0);
		}
	}
}
