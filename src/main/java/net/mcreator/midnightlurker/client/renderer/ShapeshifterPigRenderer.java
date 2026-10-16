
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.midnightlurker.entity.ShapeshifterPigEntity;

public class ShapeshifterPigRenderer extends MobRenderer<ShapeshifterPigEntity, PigModel<ShapeshifterPigEntity>> {
	public ShapeshifterPigRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel(context.bakeLayer(ModelLayers.PIG)), 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShapeshifterPigEntity entity) {
		return new ResourceLocation("midnightlurker:textures/entities/shapeshifterpig.png");
	}
}
