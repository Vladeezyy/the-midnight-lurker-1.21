package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;

public class MidnightLurkerFakerWatcherModel extends GeoModel<MidnightLurkerFakerWatcherEntity> {
	@Override
	public ResourceLocation getAnimationResource(MidnightLurkerFakerWatcherEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "animations/midnightlurkerfaker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MidnightLurkerFakerWatcherEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "geo/midnightlurkerfaker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MidnightLurkerFakerWatcherEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MidnightLurkerFakerWatcherEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}
