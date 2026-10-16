package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class DevoverlaypositiveProcedure {
	public static void execute(LevelAccessor world) {
		if (MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay == false) {
			MidnightlurkerModVariables.WorldVariables.get(world).lurkerdevoverlay = true;
			MidnightlurkerModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
