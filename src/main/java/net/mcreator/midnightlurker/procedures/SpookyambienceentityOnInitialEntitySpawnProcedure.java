package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class SpookyambienceentityOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		MidnightlurkerMod.queueServerWork(2, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("spooky_ambience").getAsBoolean() == true) {
					if (!world.getEntitiesOfClass(MidnightLurkerFakerEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerFakerAggroEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerFakerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerInvisibleEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerSeenAngressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerStalkingEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerBackturnedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerHiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerRunawayEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerShadowEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerShadowEyesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerShapeshifterEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerUnprovokedEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkertposeEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightlurkerNEEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerStareEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerWatcherEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()
							|| !world.getEntitiesOfClass(MidnightLurkerCreepEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/playsound midnightlurker:spookyambience record @a ~ ~ ~ 500 1");
						if (Math.random() >= 0.8) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/playsound midnightlurker:thirteen_ambient record @a ~ ~ ~ 500 1");
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
