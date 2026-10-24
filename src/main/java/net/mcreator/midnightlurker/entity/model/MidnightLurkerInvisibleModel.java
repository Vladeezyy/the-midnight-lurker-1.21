package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;

import javax.annotation.Nullable;

public class MidnightLurkerInvisibleModel extends GeoModel<MidnightLurkerInvisibleEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerInvisibleEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkernormal");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkernormal");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerInvisibleEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
