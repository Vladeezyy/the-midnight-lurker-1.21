package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;

public class MidnightLurkerAggressiveModel extends GeoModel<MidnightLurkerAggressiveEntity> {
	@Override
	public ResourceLocation getAnimationResource(MidnightLurkerAggressiveEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "animations/midnightlurkerrunning.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MidnightLurkerAggressiveEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "geo/midnightlurkerrunning.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MidnightLurkerAggressiveEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MidnightLurkerAggressiveEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}
