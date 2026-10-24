package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.FMLPaths;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.PlayerTickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@EventBusSubscriber
public class EncounterProcProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		lurker = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "midnightlurkerconfig.json");
		{
			try {
				mainjsonobject = net.mcreator.midnightlurker.port.LurkerConfig.read(lurker);
				if (mainjsonobject.get("encounters_progress_stages").getAsBoolean() == true) {
					if (MidnightlurkerModVariables.of(entity).encounternumber >= 6) {
						{
							double _setval = 0;
							MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
							_vars.encounternumber = _setval;
							_vars.syncPlayerVariables(entity);
						}
						if (MidnightlurkerModVariables.of(entity).InsanityStage < 7) {
							{
								double _setval = MidnightlurkerModVariables.of(entity).InsanityStage + 1;
								MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
								_vars.InsanityStage = _setval;
								_vars.syncPlayerVariables(entity);
							}
							{
								double _setval = 0;
								MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
								_vars.InsanityTimer = _setval;
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
