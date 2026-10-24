package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.PlayerWakeUpEvent;

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
		if (MidnightlurkerModVariables.of(entity).InsanityAktive > 0) {
			{
				double _setval = 0;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.InsanityAktive = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (MidnightlurkerModVariables.of(entity).InsanityStage < 7
				&& MidnightlurkerModVariables.of(entity).InsanityStage > 0) {
			{
				double _setval = MidnightlurkerModVariables.of(entity).InsanityStage - 1;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.InsanityStage = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
