package com.zoshsgahdnkc.NebulaChronicles.datagen;

import com.google.common.collect.ImmutableSet;
import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final ImmutableSet<RegistryObject<Block>> IGNORES = ImmutableSet.of(
            ModBlocks.FORTRESS_DOOR,
            ModBlocks.COARSE_CACTUS_DOOR,
            ModBlocks.COARSE_CACTUS_TRAPDOOR,

            ModBlocks.IRON_COLLAGE,
            ModBlocks.BUNKER_BRICKS,
            ModBlocks.MOSS_SILVERBLANC_STONE,

            ModBlocks.FORTRESS_WALL,
            ModBlocks.FORTRESS_WALL_LIGHT,
            ModBlocks.FORTRESS_WALL_LIGHT_UNLIT,
            ModBlocks.IRON_BRICKS_SLAB,
            ModBlocks.IRON_BRICKS_STAIRS,

            ModBlocks.TECH_TILE_WITH_SIGN,

            ModBlocks.CARGO_BOX

    );
    private static final ImmutableSet<RegistryObject<Block>> CUSTOMS = ImmutableSet.of(
            ModBlocks.THICK_VAULT_STAIRS,
            ModBlocks.SIMPLE_VAULT_STAIRS,
            ModBlocks.LOW_FENCE,
            ModBlocks.NICKELSTEEL_PLASTIC_CONTAINER
    );

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NebulaChronicles.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        for (var entry: ModBlocks.BLOCKS.getEntries()) {
            if (CUSTOMS.contains(entry)) {
                blockWithItem(entry, e -> horizontalBlock(e.get(), models().getExistingFile(getRL(ModelProvider.BLOCK_FOLDER + "/" + name(e)))));
            }else if (!IGNORES.contains(entry)) {
                simple(entry);
            }
        }

        blockWithItem(ModBlocks.TECH_TILE_WITH_SIGN, b -> horizontalBlock(b.get(), cubeAll(b.get())));
        multiple(ModBlocks.IRON_COLLAGE, 3);
        multiple(ModBlocks.BUNKER_BRICKS, 3);
        grass(ModBlocks.MOSS_SILVERBLANC_STONE, new int[]{20, 12, 2, 20, 1});
        blockWithItem(ModBlocks.FORTRESS_WALL, b -> simpleBlock(b.get(), models().cubeColumn(name(b), getRL("block/fortress_wall"), getRL("block/fortress_wall_top"))));
        blockWithItem(ModBlocks.FORTRESS_WALL_LIGHT, b -> logBlock((RotatedPillarBlock) b.get()));
        blockWithItem(ModBlocks.FORTRESS_WALL_LIGHT_UNLIT, b -> logBlock((RotatedPillarBlock) b.get()));
        blockWithItem(ModBlocks.IRON_BRICKS_STAIRS, b -> stairsBlock((StairBlock) b.get(), getRL("block/iron_bricks")));
        slab(ModBlocks.IRON_BRICKS_SLAB, getRL("block/iron_bricks_slab"), getRL("block/iron_bricks"));
        doorBlockWithRenderType((DoorBlock) ModBlocks.FORTRESS_DOOR.get(),
                getRL("block/fortress_door_bottom"),
                getRL("block/fortress_door_top"),
                "translucent");
        doorBlockWithRenderType((DoorBlock) ModBlocks.COARSE_CACTUS_DOOR.get(),
                getRL("block/coarse_cactus_door_bottom"),
                getRL("block/coarse_cactus_door_top"),
                "cutout");
        blockWithItem(ModBlocks.COARSE_CACTUS_TRAPDOOR, "coarse_cactus_trapdoor_bottom", b -> trapdoorBlockWithRenderType((TrapDoorBlock) b.get(), blockTexture(b.get()), true, "cutout"));
        blockWithItem(ModBlocks.CARGO_BOX, b -> simpleBlock(b.get(), models().getExistingFile(getRL(ModelProvider.BLOCK_FOLDER + "/" + name(b)))));
    }

    protected void simple(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    // Generate files for a block with given counts of random textures
    protected void multiple(RegistryObject<Block> block, int variants) {
        ConfiguredModel[] models = new ConfiguredModel[variants];
        for (int i = 0; i < variants; i++) {
            models[i] = new ConfiguredModel(models().cubeAll(name(block) + "_" + (i + 1),
                    getRL(ModelProvider.BLOCK_FOLDER + "/" + name(block) + "_" + (i + 1))));
        }
        var builder = getVariantBuilder(block.get());
        builder.addModels(builder.partialState(), models);
        itemModels().withExistingParent(name(block),
                getRL(ModelProvider.BLOCK_FOLDER + "/" + name(block) + "_1"));
    }
    // Generate blockstates for a grass block with multiple existing models and weight for each
    protected void grass(RegistryObject<Block> block, int[] weight) {
        ConfiguredModel[] models = new ConfiguredModel[weight.length];
        for (int i = 0; i < weight.length; i++) {
            models[i] = new ConfiguredModel(models().getExistingFile(getRL(ModelProvider.BLOCK_FOLDER + "/" + name(block) + "_" + (i+1))), 0, 0, false, weight[i]);
        }
        var builder = getVariantBuilder(block.get());
        builder.addModels(builder.partialState(), models);
        itemModels().withExistingParent(name(block),
                getRL(ModelProvider.BLOCK_FOLDER + "/" + name(block) + "_1"));
    }

    protected void slab(RegistryObject<Block> block, ResourceLocation side, ResourceLocation end) {
        getVariantBuilder(block.get())
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel(models().slab(name(block), side, end, end)))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel(models().slabTop(name(block) + "_top", side, end, end)))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel(models().cubeColumn(name(block) + "_double", side, end)));
        blockItem(block);
    }
    protected void blockWithItem(RegistryObject<Block> block, Consumer<RegistryObject<Block>> action) {
        action.accept(block);
        blockItem(block);
    }
    //Use a certain file as model for block item
    protected void blockWithItem(RegistryObject<Block> block, String filename, Consumer<RegistryObject<Block>> action) {
        action.accept(block);
        blockItem(block, filename);
    }
    protected String name(RegistryObject<Block> block) {
        return block.getId().getPath();
    }
    //Generate default block item model
    protected void blockItem(RegistryObject<Block> block) {
        itemModels().withExistingParent(name(block), getRL(ModelProvider.BLOCK_FOLDER + "/" + name(block)));
    }
    //Generate block item model with parent of certain file
    protected void blockItem(RegistryObject<Block> block, String filename) {
        itemModels().withExistingParent(name(block), getRL(ModelProvider.BLOCK_FOLDER + "/" + filename));
    }
    protected ResourceLocation getRL(String string) {
        return new ResourceLocation(NebulaChronicles.MODID, string);
    }
}
