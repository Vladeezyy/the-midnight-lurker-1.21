
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.Destroytex2Entity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;

public class Destroytex2Renderer extends MobRenderer<Destroytex2Entity, Modeldestroytex<Destroytex2Entity>> {
	public Destroytex2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modeldestroytex(context.bakeLayer(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(Destroytex2Entity entity) {
		return new ResourceLocation("midnightlurker:textures/entities/destroytex2.png");
	}
}
