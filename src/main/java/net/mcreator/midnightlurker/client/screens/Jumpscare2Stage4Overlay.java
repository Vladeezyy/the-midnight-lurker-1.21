
package net.mcreator.midnightlurker.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.procedures.ShowJump2Stage4Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame9Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame8Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame7Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame6Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame5Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame3Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame2Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame17Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame16Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame15Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame14Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame13Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame12Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame11Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame10Procedure;
import net.mcreator.midnightlurker.procedures.Insanityoverlayevent4Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class Jumpscare2Stage4Overlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
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
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (ShowJump2Stage4Procedure.execute(entity)) {
			if (JumpscareFrame15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond14stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond13stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond12stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond11stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond10stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond9stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond8stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond7stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond6stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond5stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond4stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (Insanityoverlayevent4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond3stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond2stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond1stage4.png"), posX + -513, posY + -337, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond15stage4.png"), posX + -513, posY + -328, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscaresecond16stage4.png"), posX + -513, posY + -148, 0, 0, 1023, 528, 1023, 528);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
