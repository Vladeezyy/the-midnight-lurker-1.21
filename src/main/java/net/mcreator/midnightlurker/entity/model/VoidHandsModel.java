package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;

public class VoidHandsModel extends GeoModel<VoidHandsEntity> {
	@Override
	public ResourceLocation getAnimationResource(VoidHandsEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/lurands.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VoidHandsEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/lurands.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VoidHandsEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
