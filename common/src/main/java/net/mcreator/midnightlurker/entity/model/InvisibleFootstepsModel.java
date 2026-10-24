package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.InvisibleFootstepsEntity;

public class InvisibleFootstepsModel extends GeoModel<InvisibleFootstepsEntity> {
	@Override
	public ResourceLocation getAnimationResource(InvisibleFootstepsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InvisibleFootstepsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InvisibleFootstepsEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
