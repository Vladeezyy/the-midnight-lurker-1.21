package net.mcreator.midnightlurker.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.bus.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class MidnightLurkerShapeshifterNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("villager_shapeshifter_spawning").getAsBoolean() == true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				} else if (mainjsonobject.get("villager_shapeshifter_spawning").getAsBoolean() == false) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("midnightlurker:lurkerdisappear")), SoundSource.NEUTRAL, 0, 0, false);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD && mainjsonobject.get("villager_shapeshifter_spawning").getAsBoolean() == true) {
			if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
				sx = -30;
				found = false;
				for (int index0 = 0; index0 < 60; index0++) {
					sy = -30;
					for (int index1 = 0; index1 < 60; index1++) {
						sz = -30;
						for (int index2 = 0; index2 < 60; index2++) {
							if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BELL) {
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == true) {
					if (!(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty())) {
						return true;
					}
				}
			}
		} else if (mainjsonobject.get("villager_shapeshifter_spawning").getAsBoolean() == false) {
			return false;
		}
		return false;
	}
}
