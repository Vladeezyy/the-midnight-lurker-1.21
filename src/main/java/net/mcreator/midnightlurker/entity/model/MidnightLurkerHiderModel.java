package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;

public class MidnightLurkerHiderModel extends GeoModel<MidnightLurkerHiderEntity> {
	@Override
	public ResourceLocation getAnimationResource(MidnightLurkerHiderEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/midnightlurkerhide.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MidnightLurkerHiderEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/midnightlurkerhide.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MidnightLurkerHiderEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
