package com.zoshsgahdnkc.NebulaChronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SimpleVaultStairsBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public SimpleVaultStairsBlock(Properties pProperties) {
        super(pProperties);
    }

    public static final VoxelShape SHAPE_N = Shapes.or(
            Block.box(0,3,0,16,5,8),
            Block.box(0,11,8,16,13,16),
            Block.box(6,0,4,10,3,8),
            Block.box(6,3,8,10,7,12),
            Block.box(6,6,12,10,11,16));
    public static final VoxelShape SHAPE_S = Shapes.or(
            Block.box(0,3,8,16,5,16),
            Block.box(0,11,0,16,13,8),
            Block.box(6,0,8,10,3,12),
            Block.box(6,3,4,10,7,8),
            Block.box(6,6,0,10,11,4));
    public static final VoxelShape SHAPE_E = Shapes.or(
            Block.box(8,3,0,16,5,16),
            Block.box(0,11,0,8,13,16),
            Block.box(8,0,6,12,3,10),
            Block.box(4,3,6,8,7,10),
            Block.box(0,6,6,4,11,10));
    public static final VoxelShape SHAPE_W = Shapes.or(
            Block.box(0,3,0,8,5,16),
            Block.box(8,11,0,16,13,16),
            Block.box(4,0,6,8,3,10),
            Block.box(8,3,6,12,7,10),
            Block.box(12,6,6,16,11,10));

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
