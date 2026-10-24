
package net.mcreator.midnightlurker.client.screens;


import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.procedures.VoidrandomnumberthingProcedure;
import net.mcreator.midnightlurker.procedures.InsanitytimerdisplayProcedure;
import net.mcreator.midnightlurker.procedures.InsanitystagedisplayProcedure;
import net.mcreator.midnightlurker.procedures.HealthboostnumberProcedure;
import net.mcreator.midnightlurker.procedures.ChasetimerfortestingDisplayOverlayIngameProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class ChasetimerfortestingOverlay {
	@SubscribeEvent(priority = EventPriority.LOW)
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
		if (ChasetimerfortestingDisplayOverlayIngameProcedure.execute(world)) {
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					VoidrandomnumberthingProcedure.execute(world), posX + -207, posY + -94, -3355444, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					InsanitytimerdisplayProcedure.execute(entity), posX + -207, posY + -67, -39322, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					InsanitystagedisplayProcedure.execute(entity), posX + -207, posY + -40, -39271, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font, Component.translatable("gui.midnightlurker.chasetimerfortesting.label_void_gateway_random_number"), posX + -207, posY + -103, -3355444, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font, Component.translatable("gui.midnightlurker.chasetimerfortesting.label_insanity_timer"), posX + -207, posY + -76, -39322, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font, Component.translatable("gui.midnightlurker.chasetimerfortesting.label_insanity_stage"), posX + -207, posY + -49, -39271, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font, Component.translatable("gui.midnightlurker.chasetimerfortesting.label_healthboost"), posX + -207, posY + -22, -13395712, false);
			event.getGuiGraphics().text(Minecraft.getInstance().font,

					HealthboostnumberProcedure.execute(world), posX + -207, posY + -13, -13395712, false);
		}
	}
}
