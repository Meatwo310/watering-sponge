package io.github.meatwo310.wateringsponge.blockentity;

import io.github.meatwo310.wateringsponge.config.ServerConfig;
import net.minecraft.FieldsAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WateringSpongeBE extends AbstractWateringSpongeBE {
    public WateringSpongeBE(BlockPos pos, BlockState state) {
        super(WSBlockEntities.WATERING_SPONGE_BE.get(), pos, state);
    }

    @Override
    protected int getRadius() {
        return ServerConfig.WATERING_SPONGE_RADIUS.get();
    }

    @Override
    protected int getHeight() {
        return ServerConfig.WATERING_SPONGE_HEIGHT.get();
    }

    @Override
    protected int getMaxTicks() {
        return ServerConfig.WATERING_SPONGE_MAX_TICKS.get();
    }

    @Override
    protected int getTicksPerBlock() {
        return ServerConfig.WATERING_SPONGE_TICKS_PER_BLOCK.get();
    }

    @Override
    protected boolean isFillBreakable() {
        return ServerConfig.WATERING_SPONGE_FILL_BREAKABLE.get();
    }
}
