package com.zoshsgahdnkc.NebulaChronicles.datagen;

import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLoot extends BlockLootSubProvider {

    public ModBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ARCHEOVA_STONE.get());
        dropSelf(ModBlocks.BUNKER_BRICKS.get());
        dropSelf(ModBlocks.CARGO_BOX.get());
        dropSelf(ModBlocks.COARSE_CACTUS_DOOR.get());
        dropSelf(ModBlocks.COARSE_CACTUS_PLANKS.get());
        dropSelf(ModBlocks.COARSE_CACTUS_TRAPDOOR.get());
        dropSelf(ModBlocks.COSMIC_SAND.get());
        dropSelf(ModBlocks.COSMIC_STONE.get());
        dropSelf(ModBlocks.DARK_TILE.get());
        dropSelf(ModBlocks.DEEPSPACE_STONE.get());
        dropSelf(ModBlocks.ERODED_DARK_TILE.get());
        dropSelf(ModBlocks.ERODED_LIGHT_TILE.get());
        dropSelf(ModBlocks.FORTRESS_BLOCK.get());
        dropSelf(ModBlocks.FORTRESS_DOOR.get());
        dropSelf(ModBlocks.FORTRESS_WALL.get());
        dropSelf(ModBlocks.FORTRESS_WALL_LIGHT.get());
        dropSelf(ModBlocks.FORTRESS_WALL_LIGHT_UNLIT.get());
        dropSelf(ModBlocks.IRON_BRICKS.get());
        dropSelf(ModBlocks.IRON_BRICKS_SLAB.get());
        dropSelf(ModBlocks.IRON_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.IRON_COLLAGE.get());
        dropSelf(ModBlocks.LEMURIUM_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_TILE.get());
        dropSelf(ModBlocks.LOW_FENCE.get());
        dropSelf(ModBlocks.NICKEL_BLOCK.get());
        dropSelf(ModBlocks.NICKELSTEEL_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.NICKELSTEEL_PLASTIC_CONTAINER.get());
        dropSelf(ModBlocks.ORGANIC_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.SILVERBLANC_STONE.get());
        dropSelf(ModBlocks.SIMPLE_VAULT_STAIRS.get());
        dropSelf(ModBlocks.TECH_TILE.get());
        dropSelf(ModBlocks.TECH_TILE_WITH_SIGN.get());
        dropSelf(ModBlocks.THICK_VAULT_STAIRS.get());
        dropSelf(ModBlocks.ULTRALLOY_BLOCK.get());

        add(ModBlocks.MOSS_SILVERBLANC_STONE.get(),(block) ->
                createSingleItemTableWithSilkTouch(block, ModBlocks.SILVERBLANC_STONE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
    }
}
