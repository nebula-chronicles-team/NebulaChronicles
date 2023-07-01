package com.zoshsgahdnkc.NebulaChronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class FortressDoorBlock extends DoorBlock {
    public FortressDoorBlock(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
        super(properties, blockSetType);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (isOpen(state)) {
            level.playSound(player, blockPos, SoundEvents.IRON_DOOR_OPEN, SoundSource.BLOCKS);
        } else {
            level.playSound(player, blockPos, SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS);
        }
        state = state.cycle(OPEN);
        level.setBlock(blockPos, state, 10);

        level.gameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
