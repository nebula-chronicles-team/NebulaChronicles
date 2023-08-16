package com.zoshsgahdnkc.NebulaChronicles.worldgen;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModCF {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRANGE_FERN = createKey("strange_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_BUD = createKey("white_bud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVERBLANC_FLOWER = createKey("silverblanc_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_KODOKU_FLOWER = createKey("white_kodoku_flower");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, STRANGE_FERN, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
             12, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK
                , new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STRANGE_FERN.get())))
        ));
        register(context, WHITE_BUD, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                24, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK
                , new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WHITE_BUD.get())))
        ));
        register(context, SILVERBLANC_FLOWER, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(ModBlocks.BLUE_KODOKU_FLOWER.get().defaultBlockState(), 1)
                .add(ModBlocks.PURPLE_KODOKU_FLOWER.get().defaultBlockState(), 1)), 6));
//        FeatureUtils.register(p_256132_, FLOWER_PLAIN, Feature.FLOWER, new RandomPatchConfiguration(64, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.005F, -0.8F, 0.33333334F, Blocks.DANDELION.defaultBlockState(), List.of(Blocks.ORANGE_TULIP.defaultBlockState(), Blocks.RED_TULIP.defaultBlockState(), Blocks.PINK_TULIP.defaultBlockState(), Blocks.WHITE_TULIP.defaultBlockState()), List.of(Blocks.POPPY.defaultBlockState(), Blocks.AZURE_BLUET.defaultBlockState(), Blocks.OXEYE_DAISY.defaultBlockState(), Blocks.CORNFLOWER.defaultBlockState()))))));
        register(context, WHITE_KODOKU_FLOWER, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.WHITE_KODOKU_FLOWER.get().defaultBlockState()), 12));
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
    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }
}
