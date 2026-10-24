
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.mcreator.midnightlurker.port.platform.Registrar;
import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.MidnightlurkerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MidnightlurkerModTabs {
	public static final Registrar<CreativeModeTab> REGISTRY = Registrar.create(Registries.CREATIVE_MODE_TAB, MidnightlurkerMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(MidnightlurkerModBlocks.TOUGH_DOOR.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(MidnightlurkerModItems.MIDNIGHT_LURKER_AGGRESSIVE_SPAWN_EGG.get());
			tabData.accept(MidnightlurkerModItems.MIDNIGHT_LURKER_RUNAWAY_SPAWN_EGG.get());
		}
	}
}
