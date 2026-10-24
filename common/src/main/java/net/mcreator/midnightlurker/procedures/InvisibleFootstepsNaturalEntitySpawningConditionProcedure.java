package net.mcreator.midnightlurker.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.bus.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.entity.InvisibleStaticEntity;
import net.mcreator.midnightlurker.entity.InvisibleShadowEntity;
import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class InvisibleFootstepsNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
			lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
			{
				try {
					mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
					if (mainjsonobject.get("invisible_entities_spawning").getAsBoolean() == true) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					} else if (mainjsonobject.get("invisible_entities_spawning").getAsBoolean() == false) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					}
					if (mainjsonobject.get("cave_spawning").getAsBoolean() == true) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					} else if (mainjsonobject.get("cave_spawning").getAsBoolean() == false) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerchase")), SoundSource.NEUTRAL, 0, 0, false);
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (mainjsonobject.get("cave_spawning").getAsBoolean() == true) {
				if (mainjsonobject.get("invisible_entities_spawning").getAsBoolean() == false) {
					return false;
				} else if (mainjsonobject.get("invisible_entities_spawning").getAsBoolean() == true) {
					if (!(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleFootstepsEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleShadowEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleStaticEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleLurkerFootstepsEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleCaveSoundsEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					}
				}
			} else if (mainjsonobject.get("cave_spawning").getAsBoolean() == false) {
				if (y > 60) {
					if (!(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleFootstepsEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleShadowEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleStaticEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleLurkerFootstepsEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, InvisibleCaveSoundsEntity.class, AABB.ofSize(new Vec3(x, y, z), 800, 800, 800), e -> true).isEmpty())
							&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
