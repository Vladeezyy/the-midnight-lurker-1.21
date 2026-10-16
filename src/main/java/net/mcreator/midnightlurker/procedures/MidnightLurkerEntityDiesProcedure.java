package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import java.util.Comparator;

public class MidnightLurkerEntityDiesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive > 0) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkerinsanityactive = 0;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
		if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 300, 300, 300), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MidnightlurkerModVariables.PlayerVariables())).InsanityAktive > 0) {
			{
				double _setval = 0;
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
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost < 5) {
			MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost = MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost + 1;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
