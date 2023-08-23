package com.zoshsgahdnkc.NebulaChronicles.registries;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.worldgen.features.CaveAmethystFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, NebulaChronicles.MODID);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CAVE_AMETHYST = FEATURES.register("cave_amethyst", () -> new CaveAmethystFeature(NoneFeatureConfiguration.CODEC));

}
