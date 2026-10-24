package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;

import javax.annotation.Nullable;

public class VoidGatewayModel extends GeoModel<VoidGatewayEntity> {
	@Override
	public Identifier getAnimationResource(VoidGatewayEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "voidgateway");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "voidgateway");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(VoidGatewayEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
