
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
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.procedures.InsanityBarStage4Procedure;


@EventBusSubscriber({Dist.CLIENT})
public class InsanityBarStage5OverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof InventoryScreen) {
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
			if (InsanityBarStage4Procedure.execute(world, x, y, z, entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/insanitystage4.png"), 0, 0, 0, 0, w, h, w, h);
			}
		}
	}
}
