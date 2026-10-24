package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;

import javax.annotation.Nullable;

public class InvisibleCaveSoundsModel extends GeoModel<InvisibleCaveSoundsEntity> {
	@Override
	public Identifier getAnimationResource(InvisibleCaveSoundsEntity entity) {
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
	public void addAdditionalStateData(InvisibleCaveSoundsEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
