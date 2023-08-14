package com.zoshsgahdnkc.NebulaChronicles.worldgen;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModCF {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRANGE_FERN = createKey("strange_fern");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, STRANGE_FERN, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
             12, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK
                , new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STRANGE_FERN.get())))
        ));
    }
    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> resourceKey,
            F feature, FC featureConfiguration
    ) {
        context.register(resourceKey, new ConfiguredFeature<>(feature, featureConfiguration));
    }
    protected static ResourceKey<ConfiguredFeature<?, ?>> createKey(String key) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(NebulaChronicles.MODID, key));
    }
}
