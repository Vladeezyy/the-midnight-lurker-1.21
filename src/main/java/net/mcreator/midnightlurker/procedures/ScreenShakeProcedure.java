package net.mcreator.midnightlurker.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ScreenShakeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawny = 0;
		double spawnz = 0;
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).ScreenShake > 0) {
				{
					double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).ScreenShake - 1;
					MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
					_vars.ScreenShake = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (!(!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
				&& entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).ScreenShake > 0) {
			{
				double _setval = 0;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.ScreenShake = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (!net.mcreator.midnightlurker.port.LurkerEntities.of(world, MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).ScreenShake > 0) {
				{
					Entity _ent = entity;
					_ent.setYRot((float) (entity.getYRot() + Mth.nextInt(RandomSource.create(), -1, 1)));
					_ent.setXRot((float) (entity.getXRot() + Mth.nextInt(RandomSource.create(), -1, 1)));
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
			}
		}
	}
}
