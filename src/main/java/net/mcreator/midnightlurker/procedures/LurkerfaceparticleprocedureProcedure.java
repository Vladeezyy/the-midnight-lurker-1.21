package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@EventBusSubscriber
public class LurkerfaceparticleprocedureProcedure {
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
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("insanity_progress_effect").getAsBoolean() == true) {
					if (entity instanceof Player && entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer <= 200
							&& (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage > 0
									|| entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7)
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY, 55, 0, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer > 4800
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer > 10800
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer > 22800
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
					}
				} else if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if (entity instanceof Player && Math.random() > 0.5 && entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer > 34800
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage == 6
							&& MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive == 1
							&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY_FACES, 55, 0, false, false));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
