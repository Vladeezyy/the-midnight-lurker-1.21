package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.InvisibleStaticEntity;

public class InvisibleStaticModel extends GeoModel<InvisibleStaticEntity> {
	@Override
	public ResourceLocation getAnimationResource(InvisibleStaticEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InvisibleStaticEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InvisibleStaticEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
