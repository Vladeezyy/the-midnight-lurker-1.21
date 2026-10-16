
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.midnightlurker.world.inventory.LurkerBookGuiMenu;
import net.mcreator.midnightlurker.MidnightlurkerMod;

public class MidnightlurkerModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MidnightlurkerMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<LurkerBookGuiMenu>> LURKER_BOOK_GUI = REGISTRY.register("lurker_book_gui", () -> IForgeMenuType.create(LurkerBookGuiMenu::new));
}
