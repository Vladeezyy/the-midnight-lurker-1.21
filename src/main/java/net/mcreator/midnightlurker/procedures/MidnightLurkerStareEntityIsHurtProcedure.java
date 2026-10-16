package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class MidnightLurkerStareEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
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
		if (entity instanceof MidnightLurkerStareEntity && sourceentity instanceof Player) {
			entity.getPersistentData().putDouble("StareCountdown", 400);
		}
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
				if (mainjsonobject.get("lurker_invulnerable").getAsBoolean() == true) {
					if (entity instanceof MidnightLurkerStareEntity && sourceentity instanceof Player) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				} else if (mainjsonobject.get("lurker_invulnerable").getAsBoolean() == false) {
					if (entity instanceof MidnightLurkerStareEntity && sourceentity instanceof Player) {
						if (entity.getPersistentData().getBoolean("Stunned") == false) {
							entity.getPersistentData().putBoolean("Stunned", true);
						}
						if (entity.getPersistentData().getDouble("StunTimer") > 0) {
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
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
