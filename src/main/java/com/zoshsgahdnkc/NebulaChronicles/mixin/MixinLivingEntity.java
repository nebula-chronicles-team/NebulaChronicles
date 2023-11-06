package com.zoshsgahdnkc.NebulaChronicles.mixin;

import com.zoshsgahdnkc.NebulaChronicles.planet.Planet;
import com.zoshsgahdnkc.NebulaChronicles.planet.PlanetUtils;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @Unique
    private static final double BASE_GRAVITY = 0.08D;

    // Modify the gravity
    @Inject(method = "travel", at = @At("TAIL"))
    public void nchTravel(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        Planet planet = PlanetUtils.getPlanet(entity);
        if (planet == null) return;
        Vec3 speed = entity.getDeltaMovement();
        float gravity = 1 - PlanetUtils.getGravityRatio(planet);
        if (!entity.isInFluidType() && !entity.isNoGravity() && !entity.isFallFlying() && !entity.hasEffect(MobEffects.SLOW_FALLING)) {
            entity.setDeltaMovement(speed.x(), speed.y() + BASE_GRAVITY * gravity, speed.z());
        }
    }

//    @ModifyArg(method = "calculateFallDamage", at = @At("HEAD"), argsOnly = true)
//    public LivingEntity nchCalculateFallDamage(LivingEntity value) {
//        LivingEntity entity = (LivingEntity) (Object) this;
//        Planet planet = PlanetUtils.getPlanet(entity);
//        if (planet == null) return entity;
//        modifier *= PlanetUtils.getGravityRatio(planet);
//        return entity;
//    }
}
