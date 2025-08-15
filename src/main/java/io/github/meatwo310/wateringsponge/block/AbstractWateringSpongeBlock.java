package io.github.meatwo310.wateringsponge.block;

import io.github.meatwo310.wateringsponge.blockentity.AbstractWateringSpongeBE;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class AbstractWateringSpongeBlock extends Block implements EntityBlock {
    public static final BooleanProperty CORE = BooleanProperty.create("core");

    public AbstractWateringSpongeBlock() {
        this(BlockBehaviour.Properties.copy(Blocks.SPONGE)
                .noOcclusion()
                .instabreak()
                .isSuffocating((state, getter, pos) -> false)
                .sound(SoundType.WET_GRASS)
        );
    }

    public AbstractWateringSpongeBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
                .setValue(CORE, true)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CORE);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (type != this.getBlockEntityType()) return null;
        return AbstractWateringSpongeBE::tick;
    }

    protected abstract BlockEntityType<? extends AbstractWateringSpongeBE> getBlockEntityType();
}
