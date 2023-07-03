package com.zoshsgahdnkc.NebulaChronicles.registries;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.block.*;
import com.zoshsgahdnkc.NebulaChronicles.block.ModNyliumBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NebulaChronicles.MODID);
    private static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> Block){
        RegistryObject<Block> toReturn = BLOCKS.register(name,Block);
        ModItems.ITEMS.register(name,()->new BlockItem(toReturn.get(),new Item.Properties()));
        return toReturn;
    }
    public static final RegistryObject<Block> FORTRESS_BLOCK = registerBlock("fortress_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.TECH_BLOCK)
                    .strength(3.5f,6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FORTRESS_WALL = registerBlock("fortress_wall",
            () -> new Block(BlockBehaviour.Properties.copy(FORTRESS_BLOCK.get())));
    public static final RegistryObject<Block> CARGO_BOX = registerBlock("cargo_box",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2f,2f)));
    public static final RegistryObject<Block> FORTRESS_WALL_LIGHT = registerBlock("fortress_wall_light",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(FORTRESS_BLOCK.get()).lightLevel((p_50874_)-> 15)));
    public static final RegistryObject<Block> FORTRESS_WALL_LIGHT_UNLIT = registerBlock("fortress_wall_light_unlit",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(FORTRESS_BLOCK.get())));
    public static final RegistryObject<Block> FORTRESS_DOOR = registerBlock("fortress_door",
            () -> new FortressDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR).noOcclusion().requiresCorrectToolForDrops()
                    .strength(3.5f,6f), BlockSetType.OAK));
    public static final RegistryObject<Block> TECH_TILE = registerBlock("tech_tile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_TERRACOTTA)));
    public static final RegistryObject<Block> TECH_TILE_WITH_SIGN = registerBlock("tech_tile_with_sign",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(TECH_TILE.get())));
    public static final RegistryObject<Block> COARSE_CACTUS_PLANKS = registerBlock("coarse_cactus_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.BAMBOO_WOOD)));
    public static final RegistryObject<Block> COARSE_CACTUS_DOOR = registerBlock("coarse_cactus_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(COARSE_CACTUS_PLANKS.get()), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> COARSE_CACTUS_TRAPDOOR = registerBlock("coarse_cactus_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(COARSE_CACTUS_PLANKS.get()).noOcclusion(), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> DARK_TILE = registerBlock("dark_tile",
            () -> new Block(BlockBehaviour.Properties.copy(FORTRESS_BLOCK.get()).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> ERODED_DARK_TILE = registerBlock("eroded_dark_tile",
            () -> new Block(BlockBehaviour.Properties.copy(DARK_TILE.get())));
    public static final RegistryObject<Block> LIGHT_TILE = registerBlock("light_tile",
            () -> new Block(BlockBehaviour.Properties.copy(DARK_TILE.get())));
    public static final RegistryObject<Block> ERODED_LIGHT_TILE = registerBlock("eroded_light_tile",
            () -> new Block(BlockBehaviour.Properties.copy(DARK_TILE.get())));
    public static final RegistryObject<Block> IRON_BRICKS = registerBlock("iron_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> IRON_COLLAGE = registerBlock("iron_collage",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BUNKER_BRICKS = registerBlock("bunker_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> IRON_BRICKS_SLAB = registerBlock("iron_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(IRON_BRICKS.get())));
    public static final RegistryObject<Block> IRON_BRICKS_STAIRS = registerBlock("iron_bricks_stairs",
            () -> new StairBlock(()->IRON_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(IRON_BRICKS.get())));
    public static final RegistryObject<Block> SIMPLE_VAULT_STAIRS = registerBlock("simple_vault_stairs",
            () -> new SimpleVaultStairsBlock(BlockBehaviour.Properties.copy(FORTRESS_BLOCK.get()).noOcclusion()));
    public static final RegistryObject<Block> THICK_VAULT_STAIRS = registerBlock("thick_vault_stairs",
            () -> new ThickVaultStairsBlock(BlockBehaviour.Properties.copy(FORTRESS_BLOCK.get()).noOcclusion()));
    public static final RegistryObject<Block> LOW_FENCE = registerBlock("low_fence",
            () -> new LowFenceBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).strength(4f,8f).noOcclusion()));
    public static final RegistryObject<Block> NICKELSTEEL_PLASTIC_CONTAINER = registerBlock("nickelsteel_plastic_container",
            () -> new NickelsteelPlasticContainerBlock(BlockBehaviour.Properties.copy(FORTRESS_BLOCK.get()).noOcclusion()));
    public static final RegistryObject<Block> NICKEL_BLOCK = registerBlock("nickel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> NICKELSTEEL_PLASTIC_BLOCK = registerBlock("nickelsteel_plastic_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ULTRALLOY_BLOCK = registerBlock("ultralloy_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> LEMURIUM_BLOCK = registerBlock("lemurium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> THULIUM_188_BLOCK = registerBlock("thulium_188_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ORGANIC_PLASTIC_BLOCK = registerBlock("organic_plastic_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2f,4f)));
    public static final RegistryObject<Block> ARCHEOVA_STONE = registerBlock("archeova_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(6f,7f)));
    public static final RegistryObject<Block> COSMIC_STONE = registerBlock("cosmic_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5f,6f)));
    public static final RegistryObject<Block> DEEPSPACE_STONE = registerBlock("deepspace_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(7.5f,12f)));
    public static final RegistryObject<Block> COSMIC_SAND = registerBlock("cosmic_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND).strength(1f)));
    public static final RegistryObject<Block> SILVERBLANC_STONE = registerBlock("silverblanc_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSS_SILVERBLANC_STONE = registerBlock("moss_silverblanc_stone",
            () -> new ModNyliumBlock(BlockBehaviour.Properties.copy(SILVERBLANC_STONE.get()).sound(SoundType.NYLIUM).randomTicks(), SILVERBLANC_STONE));
   public static final RegistryObject<Block> SOLAR_PANEL = registerBlock("solar_panel",
           () -> new EnergyPlate(1, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> REDSTONE_POWER_PANEL = registerBlock("redstone_power_panel",
            () -> new EnergyPlate(2, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TACHYON_PROJECTION_PANEL = registerBlock("tachyon_projection_panel",
            () -> new EnergyPlate(3, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> DARK_MATTER_RENDER_PANEL = registerBlock("dark_matter_render_panel",
            () -> new EnergyPlate(4, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
