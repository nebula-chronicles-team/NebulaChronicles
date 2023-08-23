package com.zoshsgahdnkc.NebulaChronicles.worldgen;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModFeatures;
import com.zoshsgahdnkc.NebulaChronicles.utils.ModBlockTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModCF {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRANGE_FERN = createKey("strange_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_BUD = createKey("white_bud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVERBLANC_FLOWER = createKey("silverblanc_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_KODOKU_FLOWER = createKey("white_kodoku_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST = createKey("amethyst");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVERBLANC_SALTY_ICE_LAKE = createKey("silverblanc_salty_ice_lake");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_FROZEN_SOIL = createKey("disk_frozen_soil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_FROZEN_SOIL = createKey("ore_frozen_soil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CALCITE = createKey("ore_calcite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COSMIC_SAND = createKey("ore_cosmic_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DEEPSLATE = createKey("ore_deepslate");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIORITE = createKey("ore_diorite");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, STRANGE_FERN, Feature.RANDOM_PATCH, grassPatch(ModBlocks.STRANGE_FERN.get(), 12));
        register(context, WHITE_BUD, Feature.RANDOM_PATCH, grassPatch(ModBlocks.WHITE_BUD.get(), 24));
        register(context, SILVERBLANC_FLOWER, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(ModBlocks.BLUE_KODOKU_FLOWER.get().defaultBlockState(), 1)
                .add(ModBlocks.PURPLE_KODOKU_FLOWER.get().defaultBlockState(), 1)), 6));
        register(context, WHITE_KODOKU_FLOWER, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.WHITE_KODOKU_FLOWER.get().defaultBlockState()), 12));
        register(context, AMETHYST, ModFeatures.CAVE_AMETHYST.get(), new NoneFeatureConfiguration());
        register(context, SILVERBLANC_SALTY_ICE_LAKE, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(ModBlocks.SALTY_ICE.get()), BlockStateProvider.simple(ModBlocks.SILVERBLANC_STONE.get())));
        register(context, DISK_FROZEN_SOIL, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.FROZEN_SOIL.get()),
                BlockPredicate.matchesBlocks(ModBlocks.FROZEN_SOIL.get(), ModBlocks.MOSS_FROZEN_SOIL.get()),
                ConstantInt.of(3), 1));
        register(context, ORE_DEEPSLATE, Feature.ORE, new OreConfiguration(new TagMatchTest(ModBlockTags.ORE_REPLACEABLE),
                Blocks.DEEPSLATE.defaultBlockState(), 32));
        register(context, ORE_FROZEN_SOIL, Feature.ORE, new OreConfiguration(new TagMatchTest(ModBlockTags.ORE_REPLACEABLE),
                ModBlocks.FROZEN_SOIL.get().defaultBlockState(), 48));
        register(context, ORE_CALCITE, Feature.ORE, new OreConfiguration(new TagMatchTest(ModBlockTags.ORE_REPLACEABLE),
                Blocks.CALCITE.defaultBlockState(), 64));
        register(context, ORE_COSMIC_SAND, Feature.ORE, new OreConfiguration(new TagMatchTest(ModBlockTags.ORE_REPLACEABLE),
                ModBlocks.COSMIC_SAND.get().defaultBlockState(), 64));
        register(context, ORE_DIORITE, Feature.ORE, new OreConfiguration(new TagMatchTest(ModBlockTags.ORE_REPLACEABLE),
                Blocks.DIORITE.defaultBlockState(), 64));
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
    protected static RandomPatchConfiguration simple(Block block) {
        return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)));
    }
    protected static RandomPatchConfiguration grassPatch(BlockStateProvider blockStateProvider, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(blockStateProvider)));
    }
    protected static RandomPatchConfiguration grassPatch(Block block, int tries) {
        return grassPatch(BlockStateProvider.simple(block), tries);
    }
}
