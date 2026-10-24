package net.mcreator.midnightlurker.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.bus.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
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

public class VoidGatewayNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD && (world.getBlockState(BlockPos.containing(x, y - 0, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
				|| world.getBlockState(BlockPos.containing(x, y - 2, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 3, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y - 4, z)).canOcclude())) {
			lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
			{
				try {
					mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
					if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 3) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 4) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 5) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 0.5) {
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
				if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 1 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.9
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 2 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.8
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 3 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.6
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 4 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.4
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 5 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 0.5 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
						&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.98
						&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				}
			} else if (mainjsonobject.get("cave_spawning").getAsBoolean() == false) {
				if (y > 60) {
					if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 1 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.9
							&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 2 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.8
							&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 3 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.6
							&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 4 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.4
							&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 5 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					} else if (mainjsonobject.get("void_gateway_spawn_rate").getAsDouble() == 0.5 && !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
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
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidGatewayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, VoidHandsEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) && Math.random() >= 0.98
							&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
