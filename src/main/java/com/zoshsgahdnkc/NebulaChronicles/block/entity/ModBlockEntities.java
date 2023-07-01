package com.zoshsgahdnkc.NebulaChronicles.block.entity;

import com.zoshsgahdnkc.NebulaChronicles.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITY_TYPES, com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles.MODID);

    public static final RegistryObject<BlockEntityType<NickelsteelPlasticContainerBlockEntity>> NICKELSTEEL_PLASTIC_CONTAINER =
            BLOCK_ENTITIES.register("nickelsteel_plastic_container",
                    ()->BlockEntityType.Builder.of(NickelsteelPlasticContainerBlockEntity::new,
                            ModBlocks.NICKELSTEEL_PLASTIC_CONTAINER.get()).build(null));
}
