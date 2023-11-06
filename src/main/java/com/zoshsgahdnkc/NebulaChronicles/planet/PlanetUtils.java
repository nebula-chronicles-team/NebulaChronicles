package com.zoshsgahdnkc.NebulaChronicles.planet;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class PlanetUtils {
    private static final Planet silverblanc = new Planet(0.25F);
    private static final Map<ResourceLocation, Planet> planets = new HashMap<>(Map.of(
            new ResourceLocation(NebulaChronicles.MODID, "silverblanc"), silverblanc
    ));

    public static float getGravityRatio(Planet planet) {
        if (planet != null) return planet.gravityRatio();
        return 1;
    }
    public static Planet getPlanet(Level level) {
        if (planets.containsKey(level.dimension().location())) {
            return planets.get(level.dimension().location());
        }
        else return null;
    }

    public static Planet getPlanet(Entity entity) {
        return getPlanet(entity.level());
    }
}
