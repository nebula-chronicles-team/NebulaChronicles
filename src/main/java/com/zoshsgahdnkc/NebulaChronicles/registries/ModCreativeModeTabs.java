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
            .build());

    public static final RegistryObject<CreativeModeTab> TAB_INDUSTRY = TABS.register("tab_industry", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_Group."+ MODID +".tab_industry"))
            .icon(() -> new ItemStack(ModItems.CPU.get()))
            .withTabsBefore(TAB_MISC.getId())
            .build());
}
