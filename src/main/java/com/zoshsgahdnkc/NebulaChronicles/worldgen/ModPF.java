package com.zoshsgahdnkc.NebulaChronicles.worldgen;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPF {
    public static final ResourceKey<PlacedFeature> PLACE_STRANGE_FERN = createKey("place_strange_fern");
    public static final ResourceKey<PlacedFeature> PLACE_WHITE_BUD = createKey("place_white_bud");
    public static final ResourceKey<PlacedFeature> PLACE_SILVERBLANC_FLOWER = createKey("place_silverblanc_flower");
    public static final ResourceKey<PlacedFeature> PLACE_WHITE_KODOKU_FLOWER = createKey("place_white_kodoku_flower");
    public static final ResourceKey<PlacedFeature> PLACE_CAVE_AMETHYST = createKey("place_cave_amethyst");
    public static final ResourceKey<PlacedFeature> PLACE_SB_SALTY_ICE_LAKE = createKey("place_silverblanc_salty_ice_lake");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PLACE_STRANGE_FERN, features.getOrThrow(ModCF.STRANGE_FERN),
                NoiseThresholdCountPlacement.of(1, 2, 10), RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread()
                , HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BiomeFilter.biome());
        register(context, PLACE_WHITE_BUD, features.getOrThrow(ModCF.WHITE_BUD),
                NoiseThresholdCountPlacement.of(0.4, 5, 10), InSquarePlacement.spread()
                , HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BiomeFilter.biome());
        register(context, PLACE_SILVERBLANC_FLOWER, features.getOrThrow(ModCF.SILVERBLANC_FLOWER),
                NoiseThresholdCountPlacement.of(-0.8, 15, 4), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING), BiomeFilter.biome());
        register(context, PLACE_WHITE_KODOKU_FLOWER, features.getOrThrow(ModCF.WHITE_KODOKU_FLOWER),
                NoiseThresholdCountPlacement.of(-0.8, 15, 4), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING), BiomeFilter.biome());
        register(context, PLACE_CAVE_AMETHYST, features.getOrThrow(ModCF.AMETHYST),
                CountPlacement.of(UniformInt.of(100, 165)), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(85)),
                InSquarePlacement.spread(), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, 0, -13), BiomeFilter.biome());
        register(context,  PLACE_SB_SALTY_ICE_LAKE, features.getOrThrow(ModCF.SILVERBLANC_SALTY_ICE_LAKE),
                RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BiomeFilter.biome());
    }
    protected static ResourceKey<PlacedFeature> createKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(NebulaChronicles.MODID, key));
    }
    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                   Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        context.register(key, new PlacedFeature(feature, List.of(modifiers)));
    }
}
