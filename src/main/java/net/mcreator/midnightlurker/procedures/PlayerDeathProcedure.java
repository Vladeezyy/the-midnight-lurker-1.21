package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
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
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.InsanityAktive = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity instanceof Player && !net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).DeathJumpActive < 1) {
				{
					double _setval = 1;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.DeathJumpActive = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
