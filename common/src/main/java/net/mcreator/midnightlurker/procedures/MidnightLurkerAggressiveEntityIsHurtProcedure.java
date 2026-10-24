package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.ICancellableEvent;

import net.mcreator.midnightlurker.port.bus.FMLPaths;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.LivingIncomingDamageEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@EventBusSubscriber
public class MidnightLurkerAggressiveEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File lurker = new File("");
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("lurker_invulnerable").getAsBoolean() == true) {
					if ((entity instanceof MidnightLurkerAggressiveEntity || entity instanceof MidnightLurkerBackturnedEntity || entity instanceof MidnightLurkerHiderEntity || entity instanceof MidnightLurkerRuntrueEntity
							|| entity instanceof MidnightLurkerSeenAngressiveEntity || entity instanceof MidnightLurkerStalkingEntity || entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity)
							&& sourceentity instanceof Player) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
					}
				} else if (mainjsonobject.get("lurker_invulnerable").getAsBoolean() == false) {
					if ((entity instanceof MidnightLurkerUnprovokedEntity || entity instanceof MidnightlurkerNEEntity || entity instanceof MidnightLurkerBackturnedEntity) && sourceentity instanceof Player) {
						if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getBooleanOr("Stunned", false) == false) {
							net.mcreator.midnightlurker.port.PortUtil.data(entity).putBoolean("Stunned", true);
						}
						if (net.mcreator.midnightlurker.port.PortUtil.data(entity).getDoubleOr("StunTimer", 0) > 0) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
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
