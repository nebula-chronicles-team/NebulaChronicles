package com.zoshsgahdnkc.NebulaChronicles.datagen;

import com.google.common.collect.ImmutableSet;
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
    private static final Set<RegistryObject<Block>> IGNORES = ImmutableSet.of(
            ModBlocks.FORTRESS_DOOR,
            ModBlocks.COARSE_CACTUS_DOOR,
            ModBlocks.CARGO_BOX,
            ModBlocks.MOSS_SILVERBLANC_STONE
    );

    @Override
    protected void generate() {
        ModBlocks.BLOCKS.getEntries().stream().filter(e -> !IGNORES.contains(e)).map(RegistryObject::get).forEach(this::dropSelf);

        add(ModBlocks.FORTRESS_DOOR.get(), (this::createDoorTable));
        add(ModBlocks.COARSE_CACTUS_DOOR.get(), (this::createDoorTable));
        add(ModBlocks.COARSE_CACTUS_TRAPDOOR.get(), (this::createDoorTable));
        add(ModBlocks.MOSS_SILVERBLANC_STONE.get(),(block) ->
                createSingleItemTableWithSilkTouch(block, ModBlocks.SILVERBLANC_STONE.get()));
        add(ModBlocks.CARGO_BOX.get(), noDrop());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
    }
}
