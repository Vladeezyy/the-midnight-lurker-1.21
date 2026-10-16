package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightLurkerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("mushroom_fields"))) {
			MidnightlurkerMod.queueServerWork(1, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
		if (MidnightlurkerModVariables.WorldVariables.get(world).midnighthealthboost == 5) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 99999, 1, false, false));
		}
	}
}
