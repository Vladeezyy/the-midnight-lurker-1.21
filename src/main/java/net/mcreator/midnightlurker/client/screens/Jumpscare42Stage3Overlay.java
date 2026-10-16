
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

import net.mcreator.midnightlurker.procedures.ShowJump2DStage3Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame30Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame29Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame28Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame27Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame26Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame25Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame24Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame23Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame22Procedure;
import net.mcreator.midnightlurker.procedures.JumpscarerFrame21Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class Jumpscare42Stage3Overlay {
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
		if (ShowJump2DStage3Procedure.execute(entity)) {
			if (JumpscarerFrame30Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer1stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame29Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer2stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame28Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer3stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame27Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer4stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame26Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer5stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame25Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer6stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame24Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer7stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame23Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer8stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame22Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer9stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
			if (JumpscarerFrame21Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("midnightlurker:textures/screens/jumpscarer10stage3.png"), posX + -513, posY + -130, 0, 0, 1023, 528, 1023, 528);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
