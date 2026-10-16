package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class InvisibleCaveSoundsOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("CaveSoundTime") < 1200) {
			entity.getPersistentData().putDouble("CaveSoundTime", (entity.getPersistentData().getDouble("CaveSoundTime") + 1));
		}
		if (entity.getPersistentData().getDouble("CaveSoundTime") == 1200) {
			entity.getPersistentData().putDouble("CaveSoundTime", 0);
			if (Math.random() > 0.5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.AMBIENT, 50, (float) Mth.nextDouble(RandomSource.create(), 0.2, 1));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.AMBIENT, 50, (float) Mth.nextDouble(RandomSource.create(), 0.2, 1), false);
					}
				}
			}
		}
	}
}
