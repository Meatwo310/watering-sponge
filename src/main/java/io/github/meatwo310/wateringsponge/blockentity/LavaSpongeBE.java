package io.github.meatwo310.wateringsponge.blockentity;

import io.github.meatwo310.wateringsponge.config.ServerConfig;
import net.minecraft.FieldsAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LavaSpongeBE extends AbstractWateringSpongeBE {
    public LavaSpongeBE(BlockPos pos, BlockState state) {
        super(WSBlockEntities.LAVA_SPONGE_BE.get(), pos, state);
    }

    @Override
    protected int getRadius() {
        return ServerConfig.LAVA_SPONGE.xzRadius.get();
    }

    @Override
    protected int getHeight() {
        return ServerConfig.LAVA_SPONGE.yHeight.get();
    }

    @Override
    protected int getMaxTicks() {
        return ServerConfig.LAVA_SPONGE.maxTicks.get();
    }

    @Override
    protected int getTicksPerBlock() {
        return ServerConfig.LAVA_SPONGE.ticksPerBlock.get();
    }

    @Override
    protected boolean isFillBreakable() {
        return ServerConfig.LAVA_SPONGE.fillBreakable.get();
    }

    @Override
    protected Block getFinalBlock() {
        return Blocks.LAVA;
    }
}

