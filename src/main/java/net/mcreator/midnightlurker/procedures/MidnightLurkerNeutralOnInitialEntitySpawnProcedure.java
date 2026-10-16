package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.MidnightlurkerMod;

import java.util.Comparator;

public class MidnightLurkerNeutralOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mushroom_fields"))) {
			MidnightlurkerMod.queueServerWork(1, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive < 1) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityAktive < 1) {
			{
				double _setval = 1;
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InsanityAktive = _setval;
					capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
				});
			}
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 99999, 1, false, false));
		}
	}
}
