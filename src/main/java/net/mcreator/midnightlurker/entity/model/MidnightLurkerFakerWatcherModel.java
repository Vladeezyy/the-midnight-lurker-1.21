package net.mcreator.midnightlurker.entity.model;

import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.model.GeoModel;

import net.minecraft.resources.Identifier;

import net.mcreator.midnightlurker.port.GeoTextures;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;

import javax.annotation.Nullable;

public class MidnightLurkerFakerWatcherModel extends GeoModel<MidnightLurkerFakerWatcherEntity> {
	@Override
	public Identifier getAnimationResource(MidnightLurkerFakerWatcherEntity entity) {
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
	public void addAdditionalStateData(MidnightLurkerFakerWatcherEntity entity, @Nullable Object relatedObject, GeoRenderState renderState) {
		GeoTextures.set(renderState, entity.getTexture());
	}
}
