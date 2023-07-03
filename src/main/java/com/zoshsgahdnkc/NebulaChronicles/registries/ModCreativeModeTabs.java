package com.zoshsgahdnkc.NebulaChronicles.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> TAB_MISC = TABS.register("tab_misc", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_Group."+ MODID +".tab_misc"))
            .icon(() -> new ItemStack(ModBlocks.FORTRESS_BLOCK.get()))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((param, tab) -> {
                tab.accept(ModBlocks.FORTRESS_BLOCK.get());
                tab.accept(ModBlocks.FORTRESS_WALL.get());
                tab.accept(ModBlocks.FORTRESS_WALL_LIGHT.get());
                tab.accept(ModBlocks.FORTRESS_WALL_LIGHT_UNLIT.get());
                tab.accept(ModBlocks.FORTRESS_DOOR.get());
                tab.accept(ModBlocks.TECH_TILE.get());
                tab.accept(ModBlocks.TECH_TILE_WITH_SIGN.get());
                tab.accept(ModBlocks.DARK_TILE.get());
                tab.accept(ModBlocks.ERODED_DARK_TILE.get());
                tab.accept(ModBlocks.LIGHT_TILE.get());
                tab.accept(ModBlocks.ERODED_LIGHT_TILE.get());
                tab.accept(ModBlocks.IRON_BRICKS.get());
                tab.accept(ModBlocks.IRON_BRICKS_SLAB.get());
                tab.accept(ModBlocks.IRON_BRICKS_STAIRS.get());
                tab.accept(ModBlocks.IRON_COLLAGE.get());
                tab.accept(ModBlocks.BUNKER_BRICKS.get());
                tab.accept(ModBlocks.SIMPLE_VAULT_STAIRS.get());
                tab.accept(ModBlocks.THICK_VAULT_STAIRS.get());
                tab.accept(ModBlocks.LOW_FENCE.get());
                tab.accept(ModItems.MUSIC_DISC_HALFWAY.get());
                tab.accept(ModBlocks.COARSE_CACTUS_PLANKS.get());
                tab.accept(ModBlocks.COARSE_CACTUS_DOOR.get());
                tab.accept(ModBlocks.COARSE_CACTUS_TRAPDOOR.get());
                tab.accept(ModBlocks.NICKELSTEEL_PLASTIC_CONTAINER.get());
                tab.accept(ModBlocks.CARGO_BOX.get());
            })
            .build());

    public static final RegistryObject<CreativeModeTab> TAB_INDUSTRY = TABS.register("tab_industry", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_Group."+ MODID +".tab_industry"))
            .icon(() -> new ItemStack(ModItems.CPU.get()))
            .withTabsBefore(TAB_MISC.getId())
            .displayItems((param, tab) -> {
                tab.accept(ModBlocks.SOLAR_PANEL.get());
                tab.accept(ModBlocks.REDSTONE_POWER_PANEL.get());
                tab.accept(ModBlocks.TACHYON_PROJECTION_PANEL.get());
                tab.accept(ModBlocks.DARK_MATTER_RENDER_PANEL.get());
                tab.accept(ModItems.RAW_NICKEL.get());
                tab.accept(ModItems.NICKEL_INGOT.get());
                tab.accept(ModItems.ORGANIC_PLASTIC.get());
                tab.accept(ModItems.NICKELSTEEL_PLASTIC.get());
                tab.accept(ModItems.THULIUM_188_INGOT.get());
                tab.accept(ModItems.ULTRALLOY_INGOT.get());
                tab.accept(ModItems.LEMURIUM_INGOT.get());
                tab.accept(ModItems.NETHERITE_NUGGET.get());
                tab.accept(ModItems.NICKEL_NUGGET.get());
                tab.accept(ModItems.ORGANIC_PLASTIC_NUGGET.get());
                tab.accept(ModItems.NICKELSTEEL_PLASTIC_NUGGET.get());
                tab.accept(ModItems.THULIUM_188_NUGGET.get());
                tab.accept(ModItems.ULTRALLOY_NUGGET.get());
                tab.accept(ModItems.LEMURIUM_NUGGET.get());
                tab.accept(ModItems.COAL_DUST.get());
                tab.accept(ModItems.COPPER_COIL.get());
                tab.accept(ModItems.GOLDEN_COIL.get());
                tab.accept(ModItems.ULTRALLOY_COIL.get());
                tab.accept(ModItems.EMPTY_BATTERY.get());
                tab.accept(ModItems.REDSTONE_BATTERY.get());
                tab.accept(ModItems.BATTERY_WASTE.get());
                tab.accept(ModItems.VACUUM_TUBE.get());
                tab.accept(ModItems.CALCITE_CASING.get());
                tab.accept(ModItems.CPU.get());
                tab.accept(ModItems.ROCKET_FUEL.get());
                tab.accept(ModBlocks.NICKEL_BLOCK.get());
                tab.accept(ModBlocks.ORGANIC_PLASTIC_BLOCK.get());
                tab.accept(ModBlocks.NICKELSTEEL_PLASTIC_BLOCK.get());
                tab.accept(ModBlocks.THULIUM_188_BLOCK.get());
                tab.accept(ModBlocks.ULTRALLOY_BLOCK.get());
                tab.accept(ModBlocks.LEMURIUM_BLOCK.get());
            })
            .build());
    public static final RegistryObject<CreativeModeTab> TAB_LEMON = TABS.register("tab_lemon", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_Group."+ MODID +".tab_lemon"))
            .icon(() -> new ItemStack(ModItems.LEMON.get()))
            .withTabsBefore(TAB_INDUSTRY.getId())
            .displayItems((param, tab) -> {if (param.hasPermissions()) {
                tab.accept(ModItems.LEMON.get());
                tab.accept(ModBlocks.ARCHEOVA_STONE.get());
                tab.accept(ModBlocks.COSMIC_SAND.get());
                tab.accept(ModBlocks.COSMIC_STONE.get());
                tab.accept(ModBlocks.DEEPSPACE_STONE.get());
                tab.accept(ModBlocks.SILVERBLANC_STONE.get());
                tab.accept(ModBlocks.MOSS_SILVERBLANC_STONE.get());
            }})
            .build());
}
