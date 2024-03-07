package dev.meatwo310.watering_sponge.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class WateringSpongeBlock extends Block {
    public WateringSpongeBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.SPONGE));
    }

    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);
        if (held.getItem() == Items.WATER_BUCKET) {
            world.setBlockAndUpdate(pos, Blocks.WET_SPONGE.defaultBlockState());
            held.shrink(1);
            player.setItemInHand(hand, Items.BUCKET.getDefaultInstance());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (held.getItem() == Items.AIR) {
            //
        }
        return super.use(state, world, pos, player, hand, hit);
    }
}
