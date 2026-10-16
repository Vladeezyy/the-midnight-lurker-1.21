package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.midnightlurker.entity.InvisibleAnimalKillerEntity;

public class InvisibleAnimalKillerModel extends GeoModel<InvisibleAnimalKillerEntity> {
	@Override
	public ResourceLocation getAnimationResource(InvisibleAnimalKillerEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/voidgateway.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InvisibleAnimalKillerEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/voidgateway.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InvisibleAnimalKillerEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

}
