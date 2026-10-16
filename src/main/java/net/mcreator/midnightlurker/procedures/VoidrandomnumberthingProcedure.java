package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class VoidrandomnumberthingProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("##").format(MidnightlurkerModVariables.WorldVariables.get(world).midnightlurkeroverhauledrewardrandom) + "";
	}
}
