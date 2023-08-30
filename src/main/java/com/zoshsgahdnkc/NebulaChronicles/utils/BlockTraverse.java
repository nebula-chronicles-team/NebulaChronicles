package com.zoshsgahdnkc.NebulaChronicles.utils;


import net.minecraft.core.BlockPos;

import java.util.HashSet;
import java.util.Set;

public class BlockTraverse {
    public static Set<BlockPos> traverseRhombus(BlockPos startPos, int distance) {
        Set<BlockPos> posSet = new HashSet<>(Set.of());
        for (int y = 0 ; y < distance; y ++) {
            for (int x = 0; x < distance - y; x++) {
                for (int z = 0; z < distance - y - x; z++) {
                    posSet.add(startPos.north(x).east(z).above(y));
                    posSet.add(startPos.north(x).west(z).above(y));
                    posSet.add(startPos.south(x).east(z).above(y));
                    posSet.add(startPos.south(x).west(z).above(y));
                    posSet.add(startPos.north(x).east(z).below(y));
                    posSet.add(startPos.north(x).west(z).below(y));
                    posSet.add(startPos.south(x).east(z).below(y));
                    posSet.add(startPos.south(x).west(z).below(y));
                }
            }
        }
//        posSet.stream().map(level::getBlockState).forEach(blockSet::add);
        return posSet;
    }
}
