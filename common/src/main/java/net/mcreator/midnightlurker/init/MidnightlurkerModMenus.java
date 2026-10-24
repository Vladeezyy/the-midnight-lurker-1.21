
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.mcreator.midnightlurker.port.platform.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.mcreator.midnightlurker.port.platform.Registrar;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.midnightlurker.world.inventory.LurkerBookGuiMenu;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModMenus {
	public static final Registrar<MenuType<?>> REGISTRY = Registrar.create(Registries.MENU, MidnightlurkerMod.MODID);
	public static final RegistryEntry<MenuType<?>, MenuType<LurkerBookGuiMenu>> LURKER_BOOK_GUI = REGISTRY.register("lurker_book_gui", () -> net.mcreator.midnightlurker.port.platform.Platform.INSTANCE.menuType(LurkerBookGuiMenu::new));
}
