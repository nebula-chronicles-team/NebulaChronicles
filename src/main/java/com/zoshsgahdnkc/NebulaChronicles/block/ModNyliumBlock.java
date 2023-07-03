package com.zoshsgahdnkc.NebulaChronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraftforge.registries.RegistryObject;

public class ModNyliumBlock extends NyliumBlock {
    private Block baseBlock;
    public ModNyliumBlock(Properties properties, RegistryObject<Block> baseBlock) {
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
}
