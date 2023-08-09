package com.zoshsgahdnkc.NebulaChronicles.datagen;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NebulaChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var entry : ModItems.ITEMS.getEntries().stream().filter(e -> !(e.get() instanceof BlockItem)).toList()) {
            basicItem(entry.get());
        }

        blockWithTexture(ModBlocks.FORTRESS_DOOR);
        blockWithTexture(ModBlocks.COARSE_CACTUS_DOOR);
        blockWithTexture(ModBlocks.SOLAR_PANEL);
        blockWithTexture(ModBlocks.REDSTONE_POWER_PANEL);
        blockWithTexture(ModBlocks.TACHYON_PROJECTION_PANEL);
        blockWithTexture(ModBlocks.DARK_MATTER_RENDER_PANEL);
        blockWithTexture(ModBlocks.WHITE_BUD);
    }

    private ItemModelBuilder blockWithTexture(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NebulaChronicles.MODID,ITEM_FOLDER + "/" + block.getId().getPath()));
    }
}
