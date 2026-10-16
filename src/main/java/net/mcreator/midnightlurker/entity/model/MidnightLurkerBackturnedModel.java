package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

public class MidnightLurkerBackturnedModel extends GeoModel<MidnightLurkerBackturnedEntity> {
	@Override
	public ResourceLocation getAnimationResource(MidnightLurkerBackturnedEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/midnightlurkerbackturned.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MidnightLurkerBackturnedEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/midnightlurkerbackturned.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MidnightLurkerBackturnedEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
