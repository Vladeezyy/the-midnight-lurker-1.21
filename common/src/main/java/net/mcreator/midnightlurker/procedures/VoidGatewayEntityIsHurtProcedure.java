package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.ICancellableEvent;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.LivingIncomingDamageEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.entity.VoidGatewayEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VoidGatewayEntityIsHurtProcedure {
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
		if (entity instanceof VoidGatewayEntity) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
		}
	}
}
