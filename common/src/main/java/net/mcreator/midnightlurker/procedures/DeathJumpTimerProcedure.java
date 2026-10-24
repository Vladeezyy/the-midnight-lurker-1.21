package net.mcreator.midnightlurker.procedures;

import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Event;
import net.mcreator.midnightlurker.port.bus.PlayerTickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.midnightlurker.network.MidnightlurkerModVariables;

import javax.annotation.Nullable;

import java.io.File;

@EventBusSubscriber
public class DeathJumpTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static boolean execute(LevelAccessor world, Entity entity) {
		return execute(null, world, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		File lurker = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		if (MidnightlurkerModVariables.of(entity).DeathJumpTimer == 69
				&& MidnightlurkerModVariables.of(entity).DeathJumpActive > 0) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, Component.literal(""), _level.getServer()).withSuppressedOutput(),
						"/playsound midnightlurker:lurkerdeathjumpscare neutral @p");
		}
		if (MidnightlurkerModVariables.of(entity).DeathJumpActive == 1) {
			if (MidnightlurkerModVariables.of(entity).DeathJumpTimer == 0) {
				{
					double _setval = 70;
					MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
					_vars.DeathJumpTimer = _setval;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (MidnightlurkerModVariables.of(entity).DeathJumpActive == 1
				&& MidnightlurkerModVariables.of(entity).DeathJumpTimer == 1) {
			{
				double _setval = 0;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.DeathJumpActive = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (MidnightlurkerModVariables.of(entity).DeathJumpTimer > 0) {
			{
				double _setval = MidnightlurkerModVariables.of(entity).DeathJumpTimer - 1;
				MidnightlurkerModVariables.PlayerVariables _vars = MidnightlurkerModVariables.of(entity);
				_vars.DeathJumpTimer = _setval;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (MidnightlurkerModVariables.of(entity).DeathJumpTimer > 0) {
			return true;
		}
		return false;
	}
}
