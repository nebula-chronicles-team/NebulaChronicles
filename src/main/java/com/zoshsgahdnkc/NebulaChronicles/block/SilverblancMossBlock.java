package com.zoshsgahdnkc.NebulaChronicles.block;

import com.zoshsgahdnkc.NebulaChronicles.registries.ModBlocks;
import com.zoshsgahdnkc.NebulaChronicles.utils.BlockTraverse;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraftforge.registries.RegistryObject;

public class SilverblancMossBlock extends NyliumBlock implements BonemealableBlock {
    private static final int SPREAD_DISTANCE = 5;
    private final Block baseBlock;
    public SilverblancMossBlock(Properties properties, RegistryObject<Block> baseBlock) {
        super(properties);
        this.baseBlock = baseBlock.get();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        if (!canBeNylium(state, serverLevel, pos)) {
            serverLevel.setBlockAndUpdate(pos, baseBlock.defaultBlockState());
        }

    }


    private static boolean canBeNylium(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        int i = LightEngine.getLightBlockInto(levelReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(levelReader, blockpos));
        return i < levelReader.getMaxLightLevel();
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState state) {
        for (BlockPos pos : BlockTraverse.traverseRhombus(blockPos, SPREAD_DISTANCE)) {
            boolean above = level.getBlockState(pos.above()).isAir();
            BlockState posState = level.getBlockState(pos);
            if (above && posState.is(ModBlocks.SILVERBLANC_STONE.get())) {
                level.setBlock(pos, ModBlocks.MOSS_SILVERBLANC_STONE.get().defaultBlockState(), 3);
            } else if (above && posState.is(ModBlocks.FROZEN_SOIL.get())) {
                level.setBlock(pos, ModBlocks.MOSS_FROZEN_SOIL.get().defaultBlockState(), 3);
            }
        };
    }
}
