package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class EncounterProcProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
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
				BufferedReader bufferedReader = new BufferedReader(new FileReader(lurker));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainjsonobject.get("encounters_progress_stages").getAsBoolean() == true) {
					if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).encounternumber >= 6) {
						{
							double _setval = 0;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.encounternumber = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage < 7) {
							{
								double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage + 1;
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
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
