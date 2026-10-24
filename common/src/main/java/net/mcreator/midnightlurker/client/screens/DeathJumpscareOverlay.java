
package net.mcreator.midnightlurker.client.screens;

import net.minecraft.client.renderer.RenderPipelines;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.EventPriority;
import net.mcreator.midnightlurker.port.bus.ScreenEvent;
import net.mcreator.midnightlurker.port.bus.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.procedures.DeathJumpBackingProcProcedure;


@EventBusSubscriber({Dist.CLIENT})
public class DeathJumpscareOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof DeathScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
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
			if (DeathJumpBackingProcProcedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/ideaing1black.png"), 0, 0, 0, 0, w, h, w, h);
				if (DeathJumpBackingProcProcedure.execute(entity)) {
					event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/ideaing1.png"), posX + -90, posY + -85, 0, 0, 162, 171, 162, 171);
				}
			}
		}
	}
}
