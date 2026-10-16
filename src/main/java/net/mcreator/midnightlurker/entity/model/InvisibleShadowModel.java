package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.InvisibleShadowEntity;

public class InvisibleShadowModel extends GeoModel<InvisibleShadowEntity> {
	@Override
	public ResourceLocation getAnimationResource(InvisibleShadowEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InvisibleShadowEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InvisibleShadowEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
