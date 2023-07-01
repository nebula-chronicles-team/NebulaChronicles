package com.zoshsgahdnkc.NebulaChronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class LowFenceBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public LowFenceBlock(Properties pProperties) {
        super(pProperties);
    }

    public static final VoxelShape SHAPE_N = Shapes.or(
            Block.box(12,0,0,16,13,4),
            Block.box(0,0,0,4,13,4),
            Block.box(4,9,0,12,13,4));
    public static final VoxelShape SHAPE_S = Shapes.or(
            Block.box(0,0,12,4,13,16),
            Block.box(12,0,12,16,13,16),
            Block.box(4,9,12,12,13,16));
    public static final VoxelShape SHAPE_W = Shapes.or(
            Block.box(0,0,0,4,13,4),
            Block.box(0,0,12,4,13,16),
            Block.box(0,9,4,4,13,12));
    public static final VoxelShape SHAPE_E = Shapes.or(
            Block.box(12,0,0,16,13,4),
            Block.box(12,0,12,16,13,16),
            Block.box(12,9,4,16,13,12));

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case NORTH -> SHAPE_N;
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING,pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
