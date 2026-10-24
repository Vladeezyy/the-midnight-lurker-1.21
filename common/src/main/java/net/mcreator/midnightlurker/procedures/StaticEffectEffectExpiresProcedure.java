package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class StaticEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
			_vars.StaticRender = _setval;
			_vars.syncPlayerVariables(entity);
		}
	}
}
