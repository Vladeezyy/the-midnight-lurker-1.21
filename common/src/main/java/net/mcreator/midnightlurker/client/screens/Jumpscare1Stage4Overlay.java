
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

import net.mcreator.midnightlurker.procedures.ShowJump1Stage4Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame9Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame8Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame7Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame17Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame16Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame15Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame14Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame13Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame12Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame11Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame10Procedure;


@EventBusSubscriber({Dist.CLIENT})
public class Jumpscare1Stage4Overlay {
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
		if (ShowJump1Stage4Procedure.execute(entity)) {
			if (JumpscareFrame15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst9stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst8stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst7stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst6stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst5stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst4stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst3stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst2stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst1stage4.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst10stage4.png"), posX + -513, posY + -175, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, Identifier.parse("midnightlurker:textures/screens/jumpscarefirst11stage4.png"), posX + -513, posY + -373, 0, 0, 1023, 528, 1023, 528);
			}
		}
	}
}
