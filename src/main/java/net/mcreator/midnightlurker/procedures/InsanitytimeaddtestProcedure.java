package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class InsanitytimeaddtestProcedure {
	public static void execute(Entity entity) {
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
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 1) {
					if (entity instanceof Player) {
						{
							double _setval = 5900;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 2) {
					if (entity instanceof Player) {
						{
							double _setval = 11900;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 3) {
					if (entity instanceof Player) {
						{
							double _setval = 23900;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (mainjsonobject.get("insanity_countdown_time").getAsDouble() == 4) {
					if (entity instanceof Player) {
						{
							double _setval = 35900;
							entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InsanityTimer = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
