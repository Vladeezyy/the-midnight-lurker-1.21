package net.mcreator.midnightlurker.procedures;

import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

public class InvisibleCaveSoundsOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("CaveSoundTime", 0) < 1200) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("CaveSoundTime", (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("CaveSoundTime", 0) + 1));
		}
		if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("CaveSoundTime", 0) == 1200) {
			net.mcreator.midnightlurker.port.PortUtil.data(entity).putDouble("CaveSoundTime", 0);
			if (Math.random() > 0.5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("ambient.cave")), SoundSource.AMBIENT, 50, (float) Mth.nextDouble(RandomSource.create(), 0.2, 1));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("ambient.cave")), SoundSource.AMBIENT, 50, (float) Mth.nextDouble(RandomSource.create(), 0.2, 1), false);
					}
				}
			}
		}
	}
}
