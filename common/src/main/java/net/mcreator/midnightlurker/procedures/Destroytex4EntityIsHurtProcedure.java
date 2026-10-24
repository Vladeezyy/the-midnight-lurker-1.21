package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.ICancellableEvent;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.LivingIncomingDamageEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.Destroytex4Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Destroytex4EntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Destroytex4Entity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
	}
}
