package net.mcreator.midnightlurker.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class MidnightLurkerNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				}
				if (mainjsonobject.get("multi_spawning").getAsBoolean() == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("multi_spawning").getAsBoolean() == true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				}
				if (mainjsonobject.get("cave_spawning").getAsBoolean() == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("cave_spawning").getAsBoolean() == true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (mainjsonobject.get("cave_spawning").getAsBoolean() == true) {
			if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.9
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.8
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.6
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.4
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 0.5 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.98
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			}
			if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.9
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.8
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.6
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.4
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 0.5 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
					&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.98
					&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
				return true;
			}
		} else if (mainjsonobject.get("cave_spawning").getAsBoolean() == false) {
			if (y > 60) {
				if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.9
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.8
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.6
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.4
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 0.5 && mainjsonobject.get("multi_spawning").getAsBoolean() == true && Math.random() >= 0.98
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				}
				if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 1 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.9
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 2 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.8
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 3 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.6
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 4 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.4
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 5 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("lurker_spawn_rate").getAsDouble() == 0.5 && mainjsonobject.get("multi_spawning").getAsBoolean() == false
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.98
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				}
			}
		}
		return false;
	}
}
