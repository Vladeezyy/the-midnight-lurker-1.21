package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

import java.io.File;

@Mod.EventBusSubscriber
public class Insanitystage7Procedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File lurker = new File("");
		if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityStage > 6
				&& !world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MidnightlurkerModMobEffects.INSANITY.get(), 55, 0, false, false));
		}
	}
}
