package com.zoshsgahdnkc.NebulaChronicles.datagen;

import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import com.zoshsgahdnkc.NebulaChronicles.registries.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> c) {
        nineBlockStorageRecipes(c, RecipeCategory.MISC, ModItems.ORGANIC_PLASTIC.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORGANIC_PLASTIC_BLOCK.get());
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> c, RecipeCategory unpack, ItemLike item, RecipeCategory pack, ItemLike compact) {
        ShapelessRecipeBuilder.shapeless(unpack, item, 9).requires(compact).group(null).unlockedBy(getHasName(compact), has(compact)).save(c, new ResourceLocation(NebulaChronicles.MODID, getConversionRecipeName(item, compact)));
        ShapedRecipeBuilder.shaped(pack, compact).define('#', item).pattern("###").pattern("###").pattern("###").group(null).unlockedBy(getHasName(item), has(item)).save(c, new ResourceLocation(NebulaChronicles.MODID, getSimpleRecipeName(compact)));
    }
}
