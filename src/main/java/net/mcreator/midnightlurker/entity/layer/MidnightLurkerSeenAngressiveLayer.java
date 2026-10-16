package net.mcreator.midnightlurker.entity.layer;

import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MidnightLurkerSeenAngressiveLayer extends GeoRenderLayer<MidnightLurkerSeenAngressiveEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("midnightlurker", "textures/entities/midnightlurkervoidgateemissive.png");

	public MidnightLurkerSeenAngressiveLayer(GeoRenderer<MidnightLurkerSeenAngressiveEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, MidnightLurkerSeenAngressiveEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight,
			int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
