package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;

import javax.annotation.Nullable;

public class MidnightLurkerFakerAggroModel extends GeoModel<MidnightLurkerFakerAggroEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerFakerAggroEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerfaker");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerfaker");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerFakerAggroEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
