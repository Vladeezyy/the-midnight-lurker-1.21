
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.Destroytex3Entity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;

public class Destroytex3Renderer extends MobRenderer<Destroytex3Entity, Modeldestroytex<Destroytex3Entity>> {
	public Destroytex3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modeldestroytex(context.bakeLayer(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(Destroytex3Entity entity) {
		return new ResourceLocation("midnightlurker:textures/entities/destroytex3.png");
	}
}
