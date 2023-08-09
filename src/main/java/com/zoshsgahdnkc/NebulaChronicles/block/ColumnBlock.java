package com.zoshsgahdnkc.NebulaChronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class ColumnBlock extends Block {
    public ColumnBlock(Properties properties) {
        super(properties);
    }
    public static BooleanProperty UP = PipeBlock.UP;
    public static BooleanProperty DOWN = PipeBlock.DOWN;

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        boolean up = context.getLevel().getBlockState(pos.above()).is(this);
        boolean down = context.getLevel().getBlockState(pos.below()).is(this);
        return super.getStateForPlacement(context).setValue(UP, up).setValue(DOWN, down);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        if (state1.is(this)) {
            switch (direction) {
                case UP -> levelAccessor.setBlock(pos, state.setValue(UP, true), 3);
                case DOWN -> levelAccessor.setBlock(pos, state.setValue(DOWN, true), 3);
            }
        }
        return super.updateShape(state, direction, state1, levelAccessor, pos, pos1);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP);
        builder.add(DOWN);
    }
}
