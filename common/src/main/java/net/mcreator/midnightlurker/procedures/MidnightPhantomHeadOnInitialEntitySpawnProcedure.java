package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class MidnightPhantomHeadOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("InvisNumb", (Mth.nextInt(RandomSource.create(), 0, 1)));
		net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("AttackOnSight", (Mth.nextInt(RandomSource.create(), 0, 100)));
	}
}
