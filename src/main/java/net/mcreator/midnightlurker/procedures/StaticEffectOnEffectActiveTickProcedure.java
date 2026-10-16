package net.mcreator.midnightlurker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

public class StaticEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender == 0) {
			{
				double _setval = Mth.nextInt(RandomSource.create(), 20, 45);
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.StaticRender = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender > 0) {
			{
				double _setval = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender - 1;
				MidnightlurkerModVariables.PlayerVariables _vars = entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES);
				_vars.StaticRender = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(MidnightlurkerModVariables.PLAYER_VARIABLES).StaticRender == 10) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/playsound midnightlurker:static record @p ~ ~ ~ 1 1");
		}
	}
}
