package net.mcreator.midnightlurker.procedures;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.ViewportEvent;
import net.mcreator.midnightlurker.port.bus.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber(value = {Dist.CLIENT})
public class InsanityEffectStartedappliedProcedure {
	@SubscribeEvent
	public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
		try {
			ClientLevel clientLevel = Minecraft.getInstance().level;
			Entity entity = event.getCamera().getEntity();
			execute(null, entity, event);
		} catch (Exception e) {
		}
	}

	public static void execute(Entity entity, ViewportEvent viewport) {
		execute(null, entity, viewport);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent viewport) {
		if (entity == null || viewport == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MidnightlurkerModMobEffects.INSANITY.holder())) {
			if (entity instanceof Player) {
				if (viewport instanceof ViewportEvent.ComputeFogColor _computeFogColor) {
					_computeFogColor.setRed(62 / 255.0F);
					_computeFogColor.setGreen(20 / 255.0F);
					_computeFogColor.setBlue(25 / 255.0F);
				}
			}
		}
	}
}
