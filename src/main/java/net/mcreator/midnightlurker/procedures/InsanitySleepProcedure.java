package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InsanitySleepProcedure {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityAktive > 0) {
			{
				double _setval = 0;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.InsanityAktive = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage < 7
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage > 0) {
			{
				double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).InsanityStage - 1;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.InsanityStage = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
