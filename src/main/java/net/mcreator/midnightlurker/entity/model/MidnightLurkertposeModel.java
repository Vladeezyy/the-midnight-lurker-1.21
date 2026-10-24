package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;

import javax.annotation.Nullable;

public class MidnightLurkertposeModel extends GeoModel<MidnightLurkertposeEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkertposeEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "tposemidnightlurker");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "tposemidnightlurker");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkertposeEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
