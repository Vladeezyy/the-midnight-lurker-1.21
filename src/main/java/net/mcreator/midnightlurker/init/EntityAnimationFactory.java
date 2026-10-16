package net.mcreator.midnightlurker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.mcreator.midnightlurker.entity.VoidHandsEntity;
import net.mcreator.midnightlurker.entity.VoidGatewayEntity;
import net.mcreator.midnightlurker.entity.SpookyambienceentityEntity;
import net.mcreator.midnightlurker.entity.MidnightlurkerNEEntity;
import net.mcreator.midnightlurker.entity.MidnightPhantomHeadEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkertposeEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerUnprovokedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStareEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerStalkingEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShapeshifterEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEyesEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerShadowEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerSeenAngressiveEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRuntrueEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerRunawayEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerInvisibleEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerHiderEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerWatcherEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerFakerAggroEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerCreepEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerBackturnedEntity;
import net.mcreator.midnightlurker.entity.MidnightLurkerAggressiveEntity;
import net.mcreator.midnightlurker.entity.InvisibleStaticEntity;
import net.mcreator.midnightlurker.entity.InvisibleShadowEntity;
import net.mcreator.midnightlurker.entity.InvisibleLurkerFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleFootstepsEntity;
import net.mcreator.midnightlurker.entity.InvisibleCaveSoundsEntity;
import net.mcreator.midnightlurker.entity.InvisibleAnimalKillerEntity;

@Mod.EventBusSubscriber
public class EntityAnimationFactory {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		if (event != null && event.getEntity() != null) {
			if (event.getEntity() instanceof MidnightLurkerAggressiveEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkertposeEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerStalkingEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerInvisibleEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof SpookyambienceentityEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerSeenAngressiveEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerFakerAggroEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerFakerEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerFakerWatcherEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof VoidGatewayEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerBackturnedEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerShadowEyesEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerShadowEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerUnprovokedEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerRunawayEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerRuntrueEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerHiderEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerShapeshifterEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerStareEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightlurkerNEEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerWatcherEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof VoidHandsEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof InvisibleFootstepsEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof InvisibleShadowEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof InvisibleStaticEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof InvisibleLurkerFootstepsEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof InvisibleCaveSoundsEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightLurkerCreepEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof MidnightPhantomHeadEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
			if (event.getEntity() instanceof InvisibleAnimalKillerEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
		}
	}
}
