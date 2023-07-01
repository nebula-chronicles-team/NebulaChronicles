package com.zoshsgahdnkc.NebulaChronicles;

import com.mojang.logging.LogUtils;
import com.zoshsgahdnkc.NebulaChronicles.block.ModBlocks;
import com.zoshsgahdnkc.NebulaChronicles.block.entity.ModBlockEntities;
import com.zoshsgahdnkc.NebulaChronicles.item.ModCreativeModeTabs;
import com.zoshsgahdnkc.NebulaChronicles.item.ModItems;
import com.zoshsgahdnkc.NebulaChronicles.sound.ModSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles.MODID)
public class NebulaChronicles {
    public static final String MODID = "nch";
    private static final Logger LOGGER = LogUtils.getLogger();
    public NebulaChronicles() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.SOUND_EVENT.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModCreativeModeTabs.TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
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
            event.accept(ModBlocks.ULTRALLOY_BLOCK);
            event.accept(ModBlocks.LEMURIUM_BLOCK);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
