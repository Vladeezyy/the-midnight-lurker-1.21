package net.mcreator.midnightlurker.item.inventory;

import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.server.level.ServerPlayer;

import net.mcreator.midnightlurker.world.inventory.LurkerBookGuiMenu;
import net.mcreator.midnightlurker.init.MidnightlurkerModItems;

/**
 * 1.20.1 attached an item inventory capability (0 slots) to the Lurker book; 1.21 item capabilities are registered
 * differently and the book holds nothing, so only its behaviour is kept: dropping the book closes its screen. The toss
 * event fires on the server, so the server closes the menu (the client screen follows), also in multiplayer.
 */
@EventBusSubscriber
public class LurkerBookInventoryCapability {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == MidnightlurkerModItems.LURKER_BOOK.get() && event.getPlayer() instanceof ServerPlayer player && player.containerMenu instanceof LurkerBookGuiMenu)
			player.closeContainer();
	}
}
