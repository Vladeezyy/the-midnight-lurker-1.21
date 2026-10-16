package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class MidnightPhantomHeadOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("InvisNumb", (Mth.nextInt(RandomSource.create(), 0, 1)));
		entity.getPersistentData().putDouble("AttackOnSight", (Mth.nextInt(RandomSource.create(), 0, 100)));
	}
}
