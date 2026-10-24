
package net.mcreator.midnightlurker.client.screens;

import net.minecraft.client.renderer.RenderPipelines;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.EventPriority;
import net.mcreator.midnightlurker.port.bus.RenderGuiEvent;
import net.mcreator.midnightlurker.port.bus.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.procedures.LurkStatic1DisplayOverlayIngameProcedure;


@EventBusSubscriber({Dist.CLIENT})
public class LurkStatic1Overlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (LurkStatic1DisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/static1.png"), 0, 0, 0, 0, w, h, w, h);
			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/lurkeyes.png"), posX + -139, posY + -58, 0, 0, 278, 98, 278, 98);

		}
	}
}
