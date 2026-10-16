
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.midnightlurker.entity.Destroytex4Entity;
import net.mcreator.midnightlurker.client.model.Modeldestroytex;

public class Destroytex4Renderer extends MobRenderer<Destroytex4Entity, Modeldestroytex<Destroytex4Entity>> {
	public Destroytex4Renderer(EntityRendererProvider.Context context) {
		super(context, new Modeldestroytex(context.bakeLayer(Modeldestroytex.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(Destroytex4Entity entity) {
		return new ResourceLocation("midnightlurker:textures/entities/destroytex4.png");
	}
}
