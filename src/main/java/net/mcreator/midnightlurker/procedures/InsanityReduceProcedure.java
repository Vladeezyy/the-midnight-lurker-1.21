package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

import java.io.File;

@EventBusSubscriber
public class InsanityReduceProcedure {
	@SubscribeEvent
	public static void onPlayerFishItem(ItemFishedEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer >= 400) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityTimer - 200;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
