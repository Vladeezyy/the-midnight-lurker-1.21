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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ScreenShakeProcedure {
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
		double spawnx = 0;
		double spawny = 0;
		double spawnz = 0;
		if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake > 0) {
				{
					double _setval = (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake - 1;
					entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ScreenShake = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (!(!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
				&& (entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake > 0) {
			{
				double _setval = 0;
				entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ScreenShake = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (!world.getEntitiesOfClass(MidnightLurkerAggressiveEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if ((entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MidnightlurkerModVariables.PlayerVariables())).ScreenShake > 0) {
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
