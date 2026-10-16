package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import java.util.Comparator;

public class MidnightLurkerAggressiveOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setMaxUpStep(1);
		if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 200, 200, 200), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof LivingEntity _ent)
			_entity.setTarget(_ent);
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 99999, 1, false, false));
		}
	}
}
