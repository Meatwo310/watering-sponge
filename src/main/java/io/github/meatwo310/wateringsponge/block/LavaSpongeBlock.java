package io.github.meatwo310.wateringsponge.block;

import io.github.meatwo310.wateringsponge.blockentity.AbstractWateringSpongeBE;
import io.github.meatwo310.wateringsponge.blockentity.LavaSpongeBE;
import io.github.meatwo310.wateringsponge.blockentity.WSBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class LavaSpongeBlock extends AbstractWateringSpongeBlock {
    public LavaSpongeBlock() {
        super();
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LavaSpongeBE(pos, state);
    }

    @Override
    protected BlockEntityType<? extends AbstractWateringSpongeBE> getBlockEntityType() {
        return WSBlockEntities.LAVA_SPONGE_BE.get();
    }
}

