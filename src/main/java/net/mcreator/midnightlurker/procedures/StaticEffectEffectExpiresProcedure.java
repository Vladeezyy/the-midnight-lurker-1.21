package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class StaticEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(MidnightlurkerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.StaticRender = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
