package com.zoshsgahdnkc.NebulaChronicles.registries;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class AddItems {
    public static void addItems(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == ModCreativeModeTabs.TAB_MISC.getKey()) {
            event.accept(ModBlocks.FORTRESS_BLOCK);
            event.accept(ModBlocks.FORTRESS_WALL);
            event.accept(ModBlocks.FORTRESS_WALL_LIGHT);
            event.accept(ModBlocks.FORTRESS_WALL_LIGHT_UNLIT);
            event.accept(ModBlocks.FORTRESS_DOOR);
            event.accept(ModBlocks.TECH_TILE);
            event.accept(ModBlocks.TECH_TILE_WITH_SIGN);
            event.accept(ModBlocks.DARK_TILE);
            event.accept(ModBlocks.ERODED_DARK_TILE);
            event.accept(ModBlocks.LIGHT_TILE);
            event.accept(ModBlocks.ERODED_LIGHT_TILE);
            event.accept(ModBlocks.IRON_BRICKS);
            event.accept(ModBlocks.IRON_BRICKS_SLAB);
            event.accept(ModBlocks.IRON_BRICKS_STAIRS);
            event.accept(ModBlocks.IRON_COLLAGE);
            event.accept(ModBlocks.BUNKER_BRICKS);
            event.accept(ModBlocks.SIMPLE_VAULT_STAIRS);
            event.accept(ModBlocks.THICK_VAULT_STAIRS);
            event.accept(ModBlocks.LOW_FENCE);
            event.accept(ModItems.MUSIC_DISC_HALFWAY);
            event.accept(ModBlocks.COARSE_CACTUS_PLANKS);
            event.accept(ModBlocks.COARSE_CACTUS_DOOR);
            event.accept(ModBlocks.COARSE_CACTUS_TRAPDOOR);
            event.accept(ModBlocks.NICKELSTEEL_PLASTIC_CONTAINER);
            event.accept(ModBlocks.CARGO_BOX);
        }
        if (event.getTabKey() == ModCreativeModeTabs.TAB_INDUSTRY.getKey()) {
            event.accept(ModItems.RAW_NICKEL);
            event.accept(ModItems.NICKEL_INGOT);
            event.accept(ModItems.ORGANIC_PLASTIC);
            event.accept(ModItems.NICKELSTEEL_PLASTIC);
            event.accept(ModItems.THULIUM_188_INGOT);
            event.accept(ModItems.ULTRALLOY_INGOT);
            event.accept(ModItems.LEMURIUM_INGOT);
            event.accept(ModItems.NETHERITE_NUGGET);
            event.accept(ModItems.NICKEL_NUGGET);
            event.accept(ModItems.ORGANIC_PLASTIC_NUGGET);
            event.accept(ModItems.NICKELSTEEL_PLASTIC_NUGGET);
            event.accept(ModItems.THULIUM_188_NUGGET);
            event.accept(ModItems.ULTRALLOY_NUGGET);
            event.accept(ModItems.LEMURIUM_NUGGET);
            event.accept(ModItems.COAL_DUST);
            event.accept(ModItems.COPPER_COIL);
            event.accept(ModItems.GOLDEN_COIL);
            event.accept(ModItems.ULTRALLOY_COIL);
            event.accept(ModItems.EMPTY_BATTERY);
            event.accept(ModItems.REDSTONE_BATTERY);
            event.accept(ModItems.BATTERY_WASTE);
            event.accept(ModItems.VACUUM_TUBE);
            event.accept(ModItems.CALCITE_CASING);
            event.accept(ModItems.CPU);
            event.accept(ModItems.ROCKET_FUEL);
            event.accept(ModBlocks.NICKEL_BLOCK);
            event.accept(ModBlocks.ORGANIC_PLASTIC_BLOCK);
            event.accept(ModBlocks.NICKELSTEEL_PLASTIC_BLOCK);
            event.accept(ModBlocks.THULIUM_188_BLOCK);
            event.accept(ModBlocks.ULTRALLOY_BLOCK);
            event.accept(ModBlocks.LEMURIUM_BLOCK);
        }
    }
}
