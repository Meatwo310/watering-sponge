package io.github.meatwo310.wateringsponge.block;

import io.github.meatwo310.wateringsponge.blockentity.AbstractWateringSpongeBE;
import io.github.meatwo310.wateringsponge.blockentity.LargeWateringSpongeBE;
import io.github.meatwo310.wateringsponge.blockentity.WSBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class LargeWateringSpongeBlock extends AbstractWateringSpongeBlock {
    public LargeWateringSpongeBlock() {
        super();
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LargeWateringSpongeBE(pos, state);
    }

    @Override
    protected BlockEntityType<? extends AbstractWateringSpongeBE> getBlockEntityType() {
        return WSBlockEntities.LARGE_WATERING_SPONGE_BE.get();
    }
}
