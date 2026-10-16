
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.DestroytexEntity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;

public class DestroytexRenderer extends MobRenderer<DestroytexEntity, Modeldestroytex<DestroytexEntity>> {
	public DestroytexRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldestroytex(context.bakeLayer(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(DestroytexEntity entity) {
		return new ResourceLocation("midnightlurker:textures/entities/destroytex1.png");
	}
}
