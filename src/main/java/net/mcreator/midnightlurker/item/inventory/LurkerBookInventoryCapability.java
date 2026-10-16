package net.mcreator.midnightlurker.item.inventory;

import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.init.MidnightlurkerModItems;
import net.mcreator.midnightlurker.client.gui.LurkerBookGuiScreen;

/**
 * 1.20.1 attached an item inventory capability (0 slots) to the Lurker book; 1.21 item capabilities are registered
 * differently and the book holds nothing, so only its client behaviour is kept: dropping the book closes its screen.
 */
@EventBusSubscriber(value = Dist.CLIENT)
public class LurkerBookInventoryCapability {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == MidnightlurkerModItems.LURKER_BOOK.get()) {
			if (Minecraft.getInstance().screen instanceof LurkerBookGuiScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}
}
