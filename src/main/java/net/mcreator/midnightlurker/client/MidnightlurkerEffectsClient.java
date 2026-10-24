package net.mcreator.midnightlurker.client;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import net.mcreator.midnightlurker.init.MidnightlurkerModMobEffects;

/**
 * Which effects show in the inventory and on the HUD. NeoForge 21.2+ takes client extensions from an event instead of
 * MobEffect#initializeClient; same rules as 3.3.7: the working effects are hidden, the "show in inventory" twins only
 * stay off the HUD.
 */
@EventBusSubscriber(value = Dist.CLIENT)
public final class MidnightlurkerEffectsClient {
	private static final IClientMobEffectExtensions HIDDEN = new IClientMobEffectExtensions() {
		@Override
		public boolean isVisibleInInventory(MobEffectInstance effect) {
			return false;
		}

		@Override
		public boolean renderInventoryText(MobEffectInstance instance, AbstractContainerScreen<?> screen, GuiGraphicsExtractor guiGraphics, int x, int y, int blitOffset) {
			return false;
		}

		@Override
		public boolean isVisibleInGui(MobEffectInstance effect) {
			return false;
		}
	};
	private static final IClientMobEffectExtensions INVENTORY_ONLY = new IClientMobEffectExtensions() {
		@Override
		public boolean isVisibleInGui(MobEffectInstance effect) {
			return false;
		}
	};

	@SubscribeEvent
	public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(HIDDEN, MidnightlurkerModMobEffects.INSANITY.get(), MidnightlurkerModMobEffects.INSANITY_FACES.get(), MidnightlurkerModMobEffects.LURKER_ANGERED.get(),
				MidnightlurkerModMobEffects.AMNESIA.get(), MidnightlurkerModMobEffects.STATIC_EFFECT.get());
		event.registerMobEffect(INVENTORY_ONLY, MidnightlurkerModMobEffects.AMNESIA_SHOW_IN_INV.get(), MidnightlurkerModMobEffects.INSANITY_SHOWIN_INV.get());
	}

	private MidnightlurkerEffectsClient() {
	}
}
