package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

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

@Mod.EventBusSubscriber
public class InsanityStageTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
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
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityAktive == 1) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer < 6001) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer == 6000
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
							if (Math.random() > 0.3) {
								{
									double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage + 1;
									entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.InsanityStage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 6001) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset < 90) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 89) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityStage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 90) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityReset = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset > 0) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityAktive == 1) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer < 12001) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer == 12000
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
							if (Math.random() > 0.3) {
								{
									double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage + 1;
									entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.InsanityStage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 12001) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset < 90) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 89) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityStage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 90) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityReset = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset > 0) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityAktive == 1) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer < 24001) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer == 24000
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityStage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 24001) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset < 90) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 89) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityStage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 90) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityReset = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset > 0) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityAktive == 1) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer < 36001) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer == 36000
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityStage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityTimer >= 36001) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty())) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset < 90) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset + 1;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 89) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityStage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityTimer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset == 90) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityReset = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
							&& !world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).isEmpty()) {
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage == 7
								&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityReset > 0) {
							{
								double _setval = 0;
								entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.InsanityReset = _setval;
									capability.syncPlayerVariables(entity);
								});
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
