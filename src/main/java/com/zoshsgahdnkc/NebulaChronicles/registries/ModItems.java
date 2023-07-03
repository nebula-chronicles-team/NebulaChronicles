package com.zoshsgahdnkc.NebulaChronicles.registries;

import com.zoshsgahdnkc.NebulaChronicles.item.LemonItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles.MODID);
    public static final RegistryObject<Item> MUSIC_DISC_HALFWAY =
            ITEMS.register("music_disc_halfway", () -> new RecordItem(6,
                    ModSounds.MUSIC_DISC_HALFWAY,new Item.Properties().stacksTo(1)
                    .rarity(Rarity.RARE),4080));

    public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORGANIC_PLASTIC = ITEMS.register("organic_plastic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORGANIC_PLASTIC_NUGGET = ITEMS.register("organic_plastic_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKELSTEEL_PLASTIC = ITEMS.register("nickelsteel_plastic", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKELSTEEL_PLASTIC_NUGGET = ITEMS.register("nickelsteel_plastic_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THULIUM_188_INGOT = ITEMS.register("thulium_188_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THULIUM_188_NUGGET = ITEMS.register("thulium_188_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ULTRALLOY_INGOT = ITEMS.register("ultralloy_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ULTRALLOY_NUGGET = ITEMS.register("ultralloy_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEMURIUM_INGOT = ITEMS.register("lemurium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEMURIUM_NUGGET = ITEMS.register("lemurium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_COIL = ITEMS.register("copper_coil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_COIL = ITEMS.register("golden_coil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ULTRALLOY_COIL = ITEMS.register("ultralloy_coil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMPTY_BATTERY = ITEMS.register("empty_battery", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> REDSTONE_BATTERY = ITEMS.register("redstone_battery", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BATTERY_WASTE = ITEMS.register("battery_waste", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VACUUM_TUBE = ITEMS.register("vacuum_tube", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CALCITE_CASING = ITEMS.register("calcite_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CPU = ITEMS.register("cpu", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> ROCKET_FUEL = ITEMS.register("rocket_fuel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new LemonItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
