
package net.mcreator.midnightlurker.command;


import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.RegisterCommandsEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import net.mcreator.midnightlurker.procedures.DevoverlaynegativeProcedure;

@EventBusSubscriber
public class DevOverlay2Command {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("midnightlurker:dev_overlay_false").requires(Commands.hasPermission(Commands.LEVEL_OWNERS)).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = net.mcreator.midnightlurker.port.platform.Platform.INSTANCE.fakePlayer(world);
			Direction direction = entity.getDirection();

			DevoverlaynegativeProcedure.execute(world);
			return 0;
		}));
	}
}
