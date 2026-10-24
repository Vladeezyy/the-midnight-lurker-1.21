package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.ItemFishedEvent;

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
		if (MidnightlurkerModVariables.of(entity).InsanityStage < 7) {
			if (MidnightlurkerModVariables.of(entity).InsanityTimer >= 400) {
				{
					double _setval = MidnightlurkerModVariables.of(entity).InsanityTimer - 200;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.InsanityTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
