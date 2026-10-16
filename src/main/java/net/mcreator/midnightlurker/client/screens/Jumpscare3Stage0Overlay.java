
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

import net.mcreator.midnightlurker.procedures.ShowJump3Stage0Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame17Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame16Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame15Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame14Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame13Procedure;
import net.mcreator.midnightlurker.procedures.JumpscareFrame12Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class Jumpscare3Stage0Overlay {
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
		if (ShowJump3Stage0Procedure.execute(entity)) {
			if (JumpscareFrame15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarethird4.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarethird3.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarethird2.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarethird1.png"), posX + -513, posY + -121, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarethird5.png"), posX + -513, posY + -211, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscareFrame17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarethird6.png"), posX + -513, posY + -391, 0, 0, 1023, 528, 1023, 528);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
