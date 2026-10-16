package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;

public class MidnightLurkerFakerModel extends GeoModel<MidnightLurkerFakerEntity> {
	@Override
	public ResourceLocation getAnimationResource(MidnightLurkerFakerEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/midnightlurkerfaker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MidnightLurkerFakerEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/midnightlurkerfaker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MidnightLurkerFakerEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
