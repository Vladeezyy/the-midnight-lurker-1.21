
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.midnightlurker.client.model.Modeldestroytex;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MidnightlurkerModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldestroytex.LAYER_LOCATION, Modeldestroytex::createBodyLayer);
	}
}
