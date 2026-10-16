
package net.mcreator.midnightlurker.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

import net.mcreator.midnightlurker.entity.ShapeShifterCowEntity;

public class ShapeShifterCowRenderer extends MobRenderer<ShapeShifterCowEntity, CowModel<ShapeShifterCowEntity>> {
	public ShapeShifterCowRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShapeShifterCowEntity entity) {
		return new ResourceLocation("midnightlurker:textures/entities/shapeshiftercow.png");
	}
}
