package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;

public class InvisibleLurkerFootstepsModel extends GeoModel<InvisibleLurkerFootstepsEntity> {
	@Override
	public ResourceLocation getAnimationResource(InvisibleLurkerFootstepsEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InvisibleLurkerFootstepsEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InvisibleLurkerFootstepsEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
