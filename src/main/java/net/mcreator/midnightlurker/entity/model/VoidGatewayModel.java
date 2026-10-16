package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.VoidGatewayEntity;

public class VoidGatewayModel extends GeoModel<VoidGatewayEntity> {
	@Override
	public ResourceLocation getAnimationResource(VoidGatewayEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VoidGatewayEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VoidGatewayEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
