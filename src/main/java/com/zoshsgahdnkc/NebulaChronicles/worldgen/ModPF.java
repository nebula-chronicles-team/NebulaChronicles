package com.zoshsgahdnkc.NebulaChronicles.worldgen;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
    public static final ResourceKey<PlacedFeature> PLACE_DISK_FROZEN_SOIL = createKey("place_disk_frozen_soil");
    public static final ResourceKey<PlacedFeature> SB_ORE_FROZEN_SOIL = createKey("sb_ore_frozen_soil");
    public static final ResourceKey<PlacedFeature> SB_ORE_DIORITE = createKey("sb_ore_diorite");
    public static final ResourceKey<PlacedFeature> SB_ORE_COSMIC_SAND = createKey("sb_ore_cosmic_sand");
    public static final ResourceKey<PlacedFeature> SB_ORE_CALCITE = createKey("sb_ore_calcite");
    public static final ResourceKey<PlacedFeature> SB_ORE_DEEPSLATE = createKey("sb_ore_deepslate");

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
                NoiseBasedCountPlacement.of(80, 0D, 0.34D), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(64)),
                InSquarePlacement.spread(), BiomeFilter.biome());
        register(context, PLACE_SB_SALTY_ICE_LAKE, features.getOrThrow(ModCF.SILVERBLANC_SALTY_ICE_LAKE),
                RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BiomeFilter.biome());
        register(context, PLACE_DISK_FROZEN_SOIL, features.getOrThrow(ModCF.DISK_FROZEN_SOIL),
                InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BiomeFilter.biome(), RarityFilter.onAverageOnceEvery(2));
        register(context, SB_ORE_FROZEN_SOIL, features.getOrThrow(ModCF.ORE_FROZEN_SOIL),
                CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(64)));
        register(context, SB_ORE_COSMIC_SAND, features.getOrThrow(ModCF.ORE_COSMIC_SAND),
                CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(64)));
        register(context, SB_ORE_DIORITE, features.getOrThrow(ModCF.ORE_DIORITE),
                CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(64)));
        register(context, SB_ORE_CALCITE, features.getOrThrow(ModCF.ORE_CALCITE),
                CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(64)));
        register(context, SB_ORE_DEEPSLATE, features.getOrThrow(ModCF.ORE_DEEPSLATE),
                CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(0)));
    }
    protected static ResourceKey<PlacedFeature> createKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(NebulaChronicles.MODID, key));
    }
    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                   Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        context.register(key, new PlacedFeature(feature, List.of(modifiers)));
    }
}
