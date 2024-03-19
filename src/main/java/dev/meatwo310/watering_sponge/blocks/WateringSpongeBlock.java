package dev.meatwo310.watering_sponge.blocks;

import dev.meatwo310.watering_sponge.blockentitys.WateringSpongeBlockEntity;
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
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WateringSpongeBlock extends Block implements EntityBlock {
    @Nullable
    public RegistryObject<BlockEntityType<WateringSpongeBlockEntity>> blockEntity;
    public WateringSpongeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
    public WateringSpongeBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.SPONGE).noOcclusion().instabreak().isSuffocating((a, b, c) -> false).sound(SoundType.WET_GRASS));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return blockEntity == null ? null : blockEntity.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return blockEntity == null ? null : (type == this.blockEntity.get() ? WateringSpongeBlockEntity::tick : null);
    }
}
