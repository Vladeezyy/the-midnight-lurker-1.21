package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@EventBusSubscriber
public class InsanityStageTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer < 6001) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer == 6000
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7) {
							if (Math.random() > 0.3) {
								{
									double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage + 1;
									MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
									_vars.InsanityStage = _setval;
									_vars.syncPlayerVariables(entity);
								}
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 6001) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityTimer = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset < 90) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 89) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityStage = _setval;
								_vars.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 90) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityReset = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset > 0) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer < 12001) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer == 12000
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7) {
							if (Math.random() > 0.3) {
								{
									double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage + 1;
									MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
									_vars.InsanityStage = _setval;
									_vars.syncPlayerVariables(entity);
								}
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 12001) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityTimer = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset < 90) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 89) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityStage = _setval;
								_vars.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 90) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityReset = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset > 0) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer < 24001) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer == 24000
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityStage = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 24001) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityTimer = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset < 90) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 89) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityStage = _setval;
								_vars.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 90) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityReset = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset > 0) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer < 36001) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer == 36000
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityStage = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 36001) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityTimer = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset < 90) {
							{
								double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 89) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityStage = _setval;
								_vars.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityTimer = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset == 90) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
							_vars.InsanityReset = _setval;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
							&& !net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 7
								&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityReset > 0) {
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
								_vars.InsanityReset = _setval;
								_vars.syncPlayerVariables(entity);
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
