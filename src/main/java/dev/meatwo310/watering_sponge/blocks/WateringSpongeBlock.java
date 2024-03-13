package dev.meatwo310.watering_sponge.blocks;

import dev.meatwo310.watering_sponge.blockentitys.WateringSpongeBlockEntity;
import dev.meatwo310.watering_sponge.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WateringSpongeBlock extends Block implements EntityBlock {
    public WateringSpongeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
    public WateringSpongeBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.SPONGE).noOcclusion().instabreak().isSuffocating((a, b, c) -> false).sound(SoundType.WET_GRASS));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return BlockEntityRegister.WATERING_SPONGE_MEDIUM.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return type == BlockEntityRegister.WATERING_SPONGE_MEDIUM.get() ? WateringSpongeBlockEntity::tick : null;
    }
}
