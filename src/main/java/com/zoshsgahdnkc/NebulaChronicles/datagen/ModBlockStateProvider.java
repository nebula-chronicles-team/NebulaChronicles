package com.zoshsgahdnkc.NebulaChronicles.datagen;

import com.google.common.collect.ImmutableSet;
import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.block.CoarseCactusBlock;
import com.zoshsgahdnkc.NebulaChronicles.block.ColumnBlock;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final ImmutableSet<RegistryObject<Block>> IGNORES = ImmutableSet.of(
            ModBlocks.FORTRESS_DOOR,
            ModBlocks.COARSE_CACTUS_DOOR,
            ModBlocks.COARSE_CACTUS_TRAPDOOR,

            ModBlocks.IRON_COLLAGE,
            ModBlocks.BUNKER_BRICKS,
            ModBlocks.FROZEN_SOIL,
            ModBlocks.MOSS_SILVERBLANC_STONE,
            ModBlocks.MOSS_FROZEN_SOIL,
            ModBlocks.WHITE_BUD,
            ModBlocks.COARSE_CACTUS,

            ModBlocks.FORTRESS_WALL,
            ModBlocks.FORTRESS_WALL_LIGHT,
            ModBlocks.FORTRESS_WALL_LIGHT_UNLIT,
            ModBlocks.IRON_BRICKS_SLAB,
            ModBlocks.SILVERBLANC_STONE_SLAB,
            ModBlocks.SILVERBLANC_STONE_STAIRS,
            ModBlocks.SILVERBLANC_STONE_WALL,
            ModBlocks.IRON_BRICKS_STAIRS,
            ModBlocks.SILVERBLANC_STONE_BRICKS_STAIRS,
            ModBlocks.SILVERBLANC_STONE_BRICKS_SLAB,
            ModBlocks.SILVERBLANC_STONE_BRICKS_WALL,

            ModBlocks.TECH_TILE_WITH_SIGN,
            ModBlocks.WALL_PAPER,

            ModBlocks.COSMIC_SAND
    );
    private static final ImmutableSet<RegistryObject<Block>> DIRECTIONALS = ImmutableSet.of(
            ModBlocks.THICK_VAULT_STAIRS,
            ModBlocks.SIMPLE_VAULT_STAIRS,
            ModBlocks.LOW_FENCE,
            ModBlocks.NICKELSTEEL_PLASTIC_CONTAINER
    );
    private static final ImmutableSet<RegistryObject<Block>> CROSS = ImmutableSet.of(
            ModBlocks.STRANGE_FERN,
            ModBlocks.BLUE_KODOKU_FLOWER,
            ModBlocks.PURPLE_KODOKU_FLOWER,
            ModBlocks.WHITE_KODOKU_FLOWER
    );
    private static final ImmutableSet<RegistryObject<Block>> CUSTOMS = ImmutableSet.of(
            ModBlocks.CARGO_BOX,
            ModBlocks.SOLAR_PANEL,
            ModBlocks.REDSTONE_POWER_PANEL,
            ModBlocks.TACHYON_PROJECTION_PANEL,
            ModBlocks.DARK_MATTER_RENDER_PANEL
    );

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NebulaChronicles.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        for (var entry: ModBlocks.BLOCKS.getEntries()) {
            if (DIRECTIONALS.contains(entry)) {
                blockWithItem(entry, e -> horizontalBlock(e.get(), models().getExistingFile(getRL(blockSlashName(e)))));
            } else if (CUSTOMS.contains(entry)) {
                blockWithItem(entry, e -> simpleBlock(e.get(), models().getExistingFile(getRL(blockSlashName(e)))));
            } else if (CROSS.contains(entry)) {
                simpleBlock(entry.get(), models().cross(name(entry), getRL(blockSlashName(entry))).renderType("cutout"));
                itemModels().singleTexture(name(entry), mcLoc("item/generated"), "layer0", getRL(blockSlashName(entry)));
            } else if (!IGNORES.contains(entry)) {
                simple(entry);
            }
        }
        blockWithItem(ModBlocks.TECH_TILE_WITH_SIGN, b -> horizontalBlock(b.get(), cubeAll(b.get())));
        multipleSimple(ModBlocks.IRON_COLLAGE, 3);
        multipleSimple(ModBlocks.BUNKER_BRICKS, 3);
        multipleSimple(ModBlocks.FROZEN_SOIL, 2);
        multipleExistingWithWeight(ModBlocks.MOSS_SILVERBLANC_STONE, 20, 12, 2, 20, 1);
        multipleExistingWithWeight(ModBlocks.MOSS_FROZEN_SOIL, 20, 12, 2, 20, 1, 20, 12, 2, 20, 1);
        multipleExistingWithRotation(ModBlocks.WHITE_BUD, 2);
        coarseCactus();
        blockWithItem(ModBlocks.FORTRESS_WALL, b -> simpleBlock(b.get(), models().cubeColumn(name(b), getRL("block/fortress_wall"), getRL("block/fortress_wall_top"))));
        blockWithItem(ModBlocks.FORTRESS_WALL_LIGHT, b -> logBlock((RotatedPillarBlock) b.get()));
        blockWithItem(ModBlocks.FORTRESS_WALL_LIGHT_UNLIT, b -> logBlock((RotatedPillarBlock) b.get()));
        blockWithItem(ModBlocks.IRON_BRICKS_STAIRS, b -> stairsBlock((StairBlock) b.get(), getRL(blockSlashName(ModBlocks.IRON_BRICKS))));
        blockWithItem(ModBlocks.SILVERBLANC_STONE_BRICKS_STAIRS, b -> stairsBlock((StairBlock) b.get(), getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE_BRICKS))));
        blockWithItem(ModBlocks.SILVERBLANC_STONE_STAIRS, b -> stairsBlock((StairBlock) b.get(), getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE))));
        blockWithItem(ModBlocks.COSMIC_SAND, this::simpleRotatedBlock);
        blockWithItem(ModBlocks.SILVERBLANC_STONE_BRICKS_SLAB, b -> slabBlock((SlabBlock) b.get(), getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE_BRICKS)), getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE_BRICKS))));
        blockWithItem(ModBlocks.SILVERBLANC_STONE_SLAB, b -> slabBlock((SlabBlock) b.get(), getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE)), getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE))));
        wall(ModBlocks.SILVERBLANC_STONE_BRICKS_WALL, getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE_BRICKS)));
        wall(ModBlocks.SILVERBLANC_STONE_WALL, getRL(blockSlashName(ModBlocks.SILVERBLANC_STONE)));
        slab(ModBlocks.IRON_BRICKS_SLAB, getRL(blockSlashName(ModBlocks.IRON_BRICKS_SLAB)), getRL(blockSlashName(ModBlocks.IRON_BRICKS_SLAB)));
        doorBlockWithRenderType((DoorBlock) ModBlocks.FORTRESS_DOOR.get(),
                getRL("block/fortress_door_bottom"),
                getRL("block/fortress_door_top"),
                "translucent");
        doorBlockWithRenderType((DoorBlock) ModBlocks.COARSE_CACTUS_DOOR.get(),
                getRL("block/coarse_cactus_door_bottom"),
                getRL("block/coarse_cactus_door_top"),
                "cutout");
        blockWithItem(ModBlocks.COARSE_CACTUS_TRAPDOOR, "coarse_cactus_trapdoor_bottom", b -> trapdoorBlockWithRenderType((TrapDoorBlock) b.get(), blockTexture(b.get()), true, "cutout"));
        columnBlock(ModBlocks.WALL_PAPER);
    }

    protected void simple(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    // Generate files for a cube-all block with given counts of random textures
    protected void multipleSimple(RegistryObject<Block> block, int variants) {
        ConfiguredModel[] models = new ConfiguredModel[variants];
        for (int i = 0; i < variants; i++) {
            models[i] = new ConfiguredModel(models().cubeAll(name(block) + "_" + (i + 1),
                    getRL(blockSlashName(block) + "_" + (i + 1))));
        }
        var builder = getVariantBuilder(block.get());
        builder.addModels(builder.partialState(), models);
        itemModels().withExistingParent(name(block),
                getRL(blockSlashName(block) + "_1"));
    }
    // Generate blockstates for a block with multiple EXISTING models and weight for each
    // used for silverblanc moss blocks only
    protected void multipleExistingWithWeight(RegistryObject<Block> block, int... weight) {
        ConfiguredModel[] models = new ConfiguredModel[weight.length];
        for (int i = 0; i < weight.length; i++) {
            models[i] = new ConfiguredModel(models().getExistingFile(getRL(blockSlashName(block) + "_" + (i+1))), 0, 0, false, weight[i]);
        }
        var builder = getVariantBuilder(block.get());
        builder.addModels(builder.partialState(), models);
        itemModels().withExistingParent(name(block),
                getRL(blockSlashName(block) + "_1"));
    }
    // randomly generated none-cross plant feature, white bud for instance
    protected void multipleExistingWithRotation(RegistryObject<Block> block, int count) {
        ConfiguredModel[] models = new ConfiguredModel[count * 4];
        for (int i = 0; i < count; i++) {
            var file = models().getExistingFile(getRL(blockSlashName(block) + "_" + (i+1)));
            models[i * 4] = new ConfiguredModel(file, 0, 0, false);
            models[i * 4 + 1] = new ConfiguredModel(file, 0, 90, false);
            models[i * 4 + 2] = new ConfiguredModel(file, 0, 180, false);
            models[i * 4 + 3] = new ConfiguredModel(file, 0, 270, false);
        }
        var builder = getVariantBuilder(block.get());
        builder.addModels(builder.partialState(), models);
    }
    protected void coarseCactus() {
        RegistryObject<Block> block = ModBlocks.COARSE_CACTUS;
        ConfiguredModel[] models = new ConfiguredModel[24];
        for (int i = 0; i < 6; i++) {
            var file = models().getExistingFile(getRL(blockSlashName(block) + "_" + (i+1)));
            models[i * 4] = new ConfiguredModel(file, 0, 0, false);
            models[i * 4 + 1] = new ConfiguredModel(file, 0, 90, false);
            models[i * 4 + 2] = new ConfiguredModel(file, 0, 180, false);
            models[i * 4 + 3] = new ConfiguredModel(file, 0, 270, false);
        }
        ConfiguredModel top = new ConfiguredModel(models().getExistingFile(getRL(blockSlashName(block) + "_top")));
        var builder = getVariantBuilder(block.get());
        builder.addModels(builder.partialState().with(CoarseCactusBlock.TOP, false), models)
                .addModels(builder.partialState().with(CoarseCactusBlock.TOP, true), top);
    }
    // generate surface block that has noise texture a randomly rotated blockstate
    protected void simpleRotatedBlock(RegistryObject<Block> block) {
        ModelFile model = cubeAll(block.get());
        var builder = getVariantBuilder(block.get());
        builder.addModels(builder.partialState(), generateRotationModels(model));
    }
    protected ConfiguredModel[] generateRotationModels(ModelFile file) {
        ConfiguredModel[] models = new ConfiguredModel[4];
        models[0] = new ConfiguredModel(file, 0, 0, false);
        models[1] = new ConfiguredModel(file, 0, 90, false);
        models[2] = new ConfiguredModel(file, 0, 180, false);
        models[3] = new ConfiguredModel(file, 0, 270, false);
        return models;
    }
    protected void slab(RegistryObject<Block> block, ResourceLocation side, ResourceLocation end) {
        getVariantBuilder(block.get())
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel(models().slab(name(block), side, end, end)))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel(models().slabTop(name(block) + "_top", side, end, end)))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel(models().cubeColumn(name(block) + "_double", side, end)));
        blockItem(block);
    }
    protected void wall(RegistryObject<Block> block, ResourceLocation texture) {
        wallBlock((WallBlock) block.get(), texture);
        itemModels().wallInventory(name(block), texture);
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
    protected void columnBlock(RegistryObject<Block> block) {
        ResourceLocation end = getRL(blockSlashName(block) + "_end");
        getVariantBuilder(block.get())
                .partialState().with(ColumnBlock.UP, true).with(ColumnBlock.DOWN, true)
                .addModels(new ConfiguredModel(models().cubeColumn(name(block) + "_middle", getRL(blockSlashName(block) + "_middle"), end)))
                .partialState().with(ColumnBlock.UP, true).with(ColumnBlock.DOWN, false)
                .addModels(new ConfiguredModel(models().cubeColumn(name(block) + "_bottom", getRL(blockSlashName(block) + "_bottom"), end)))
                .partialState().with(ColumnBlock.UP, false).with(ColumnBlock.DOWN, true)
                .addModels(new ConfiguredModel(models().cubeColumn(name(block) + "_top", getRL(blockSlashName(block) + "_top"), end)))
                .partialState().with(ColumnBlock.UP, false).with(ColumnBlock.DOWN, false)
                .addModels(new ConfiguredModel(models().cubeColumn(name(block) + "_double", getRL(blockSlashName(block) + "_double"), end)));
        blockItem(block, name(block) + "_double");
    }
    protected String name(RegistryObject<Block> block) {
        return block.getId().getPath();
    }
    protected String blockSlashName(RegistryObject<Block> block) {
        return ModelProvider.BLOCK_FOLDER + "/" + name(block);
    }
    //Generate default block item model
    protected void blockItem(RegistryObject<Block> block) {
        itemModels().withExistingParent(name(block), getRL(blockSlashName(block)));
    }
    //Generate block item model with parent of certain file
    protected void blockItem(RegistryObject<Block> block, String filename) {
        itemModels().withExistingParent(name(block), getRL(ModelProvider.BLOCK_FOLDER + "/" + filename));
    }
    protected ResourceLocation getRL(String string) {
        return new ResourceLocation(NebulaChronicles.MODID, string);
    }
}
