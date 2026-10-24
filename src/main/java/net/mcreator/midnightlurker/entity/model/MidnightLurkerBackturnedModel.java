package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;

import javax.annotation.Nullable;

public class MidnightLurkerBackturnedModel extends GeoModel<MidnightLurkerBackturnedEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerBackturnedEntity entity) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerbackturned");
	}

	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		return Identifier.fromNamespaceAndPath("midnightlurker", "midnightlurkerbackturned");
	}

	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return GeoTextures.get(renderState);
	}

	@Override
	public void addAdditionalStateData(MidnightLurkerBackturnedEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
