
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.mcreator.midnightlurker.port.bus.RegisterMenuScreensEvent;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.Dist;


import net.mcreator.midnightlurker.client.gui.LurkerBookGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MidnightlurkerModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(MidnightlurkerModMenus.LURKER_BOOK_GUI.get(), LurkerBookGuiScreen::new);
	}
}
