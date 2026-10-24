package net.mcreator.midnightlurker.entity.model;

import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;

import javax.annotation.Nullable;

public class MidnightLurkerRuntrueModel extends GeoModel<MidnightLurkerRuntrueEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerRuntrueEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerrunaway");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerrunaway");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerRuntrueEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
