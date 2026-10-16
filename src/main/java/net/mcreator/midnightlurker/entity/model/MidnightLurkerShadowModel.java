package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;

public class MidnightLurkerShadowModel extends GeoModel<MidnightLurkerShadowEntity> {
	@Override
	public ResourceLocation getAnimationResource(MidnightLurkerShadowEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/midnightlurkershadow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MidnightLurkerShadowEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/midnightlurkershadow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MidnightLurkerShadowEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
