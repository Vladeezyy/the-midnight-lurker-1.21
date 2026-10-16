package net.mcreator.midnightlurker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerDeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				double _setval = 0;
				entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InsanityAktive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof Player && !world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).DeathJumpActive < 1) {
				{
					double _setval = 1;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DeathJumpActive = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
