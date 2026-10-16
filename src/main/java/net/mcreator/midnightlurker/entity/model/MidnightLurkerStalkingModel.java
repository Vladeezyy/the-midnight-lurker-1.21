package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;

public class MidnightLurkerStalkingModel extends GeoModel<MidnightLurkerStalkingEntity> {
	@Override
	public ResourceLocation getAnimationResource(MidnightLurkerStalkingEntity entity) {
		return new ResourceLocation("midnightlurker", "animations/midnightlurkernormal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MidnightLurkerStalkingEntity entity) {
		return new ResourceLocation("midnightlurker", "geo/midnightlurkernormal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MidnightLurkerStalkingEntity entity) {
		return new ResourceLocation("midnightlurker", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MidnightLurkerStalkingEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			int unpausedMultiplier = !Minecraft.getInstance().isPaused() ? 1 : 0;
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * ((float) Math.PI / 180F) * unpausedMultiplier);
			head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F) * unpausedMultiplier);
		}

	}
}
