package io.github.meatwo310.wateringsponge.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WateringSpongeCoreBE extends BlockEntity {
    public WateringSpongeCoreBE(BlockPos pos, BlockState state) {
        super(WSBlockEntities.WATERING_SPONGE_CORE_BE.get(), pos, state);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T unknownBE) {
        if (level.isClientSide) return;
        if (!(unknownBE instanceof WateringSpongeCoreBE be)) return;
    }
}
