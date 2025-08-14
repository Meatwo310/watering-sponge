package io.github.meatwo310.wateringsponge.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WateringSpongeFillerBlock extends Block implements EntityBlock {
    public WateringSpongeFillerBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.SPONGE)
                .noOcclusion()
                .instabreak()
                .isSuffocating((state, getter, pos) -> false)
                .sound(SoundType.WET_GRASS)
        );
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WateringSpongeFillerBE(pos, state);
    }

    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (type != WSBlockEntities.WATERING_SPONGE_FILLER_BE.get()) return null;
        return WateringSpongeFillerBE::tick;
    }
}
