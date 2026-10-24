
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.midnightlurker.init;

import net.mcreator.midnightlurker.port.bus.EventBusSubscriber;
import net.mcreator.midnightlurker.port.bus.SubscribeEvent;
import net.mcreator.midnightlurker.port.bus.EntityRenderersEvent;
import net.mcreator.midnightlurker.port.bus.Dist;

import net.mcreator.midnightlurker.client.model.Modeldestroytex;

@EventBusSubscriber(value = {Dist.CLIENT})
public class MidnightlurkerModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldestroytex.LAYER_LOCATION, Modeldestroytex::createBodyLayer);
	}
}
