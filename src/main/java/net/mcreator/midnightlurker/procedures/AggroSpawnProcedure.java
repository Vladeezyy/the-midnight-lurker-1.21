package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModEntities;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class AggroSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawny = 0;
		double spawnz = 0;
		if (world instanceof Level _lvl0 && _lvl0.isDay() && y < 60) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7) {
				if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
					spawnx = x + Mth.nextInt(RandomSource.create(), -12, 12);
					spawny = y + Mth.nextInt(RandomSource.create(), -12, 12);
					spawnz = z + Mth.nextInt(RandomSource.create(), -12, 12);
				}
				if (world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz))
						&& !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.get().spawn(_level, BlockPos.containing(spawnx, spawny, spawnz), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
			}
			if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
				if (entity.getPersistentData().getDouble("DistantRoar") < 3) {
					entity.getPersistentData().putDouble("DistantRoar", (entity.getPersistentData().getDouble("DistantRoar") + 1));
					if (entity.getPersistentData().getDouble("DistantRoar") == 1) {
						{
							double _setval = 60;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ScreenShake = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MidnightlurkerMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdistantscream")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdistantscream")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						});
					}
				}
			}
			if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) && entity.getPersistentData().getDouble("DistantRoar") > 0) {
				entity.getPersistentData().putDouble("DistantRoar", 0);
			}
		} else if (!(world instanceof Level _lvl20 && _lvl20.isDay())) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7) {
				if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
					spawnx = x + Mth.nextInt(RandomSource.create(), -12, 12);
					spawny = y + Mth.nextInt(RandomSource.create(), -12, 12);
					spawnz = z + Mth.nextInt(RandomSource.create(), -12, 12);
				}
				if (world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 2, spawnz)) && world.isEmptyBlock(BlockPos.containing(spawnx, spawny + 3, spawnz))
						&& !world.isEmptyBlock(BlockPos.containing(spawnx, spawny - 1, spawnz))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MidnightlurkerModEntities.MIDNIGHT_LURKER_AGGRESSIVE.get().spawn(_level, BlockPos.containing(spawnx, spawny, spawnz), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
			}
			if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
				if (entity.getPersistentData().getDouble("DistantRoar") < 3) {
					entity.getPersistentData().putDouble("DistantRoar", (entity.getPersistentData().getDouble("DistantRoar") + 1));
					if (entity.getPersistentData().getDouble("DistantRoar") == 1) {
						{
							double _setval = 60;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ScreenShake = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MidnightlurkerMod.queueServerWork(1, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdistantscream")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("midnightlurker:lurkerdistantscream")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						});
					}
				}
			}
			if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) && entity.getPersistentData().getDouble("DistantRoar") > 0) {
				entity.getPersistentData().putDouble("DistantRoar", 0);
			}
		}
	}
}
