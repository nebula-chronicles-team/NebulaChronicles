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

public class ThickVaultStairsBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ThickVaultStairsBlock(Properties pProperties) {
        super(pProperties);
    }

    public static final VoxelShape SHAPE_N = Shapes.or(
            Block.box(0,0,0,16,3,9),
            Block.box(0,3,5,16,8,14),
            Block.box(0,8,10,16,13,16));
    public static final VoxelShape SHAPE_S = Shapes.or(
            Block.box(0,0,7,16,3,16),
            Block.box(0,3,2,16,8,11),
            Block.box(0,8,0,16,13,6));
    public static final VoxelShape SHAPE_E = Shapes.or(
            Block.box(7,0,0,16,3,16),
            Block.box(2,3,0,11,8,16),
            Block.box(0,8,0,6,13,16));
    public static final VoxelShape SHAPE_W = Shapes.or(
            Block.box(0,0,0,9,3,16),
            Block.box(5,3,0,14,8,16),
            Block.box(10,8,0,16,13,16));

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
