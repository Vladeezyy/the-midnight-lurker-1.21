
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;


import net.mcreator.midnightlurker.client.gui.LurkerBookGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MidnightlurkerModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MidnightlurkerModMenus.LURKER_BOOK_GUI.get(), LurkerBookGuiScreen::new);
	}
}
