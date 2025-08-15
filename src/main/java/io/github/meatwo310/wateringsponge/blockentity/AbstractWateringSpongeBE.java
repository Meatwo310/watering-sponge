package io.github.meatwo310.wateringsponge.blockentity;

import io.github.meatwo310.wateringsponge.block.WateringSpongeBlock;
import net.minecraft.FieldsAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class AbstractWateringSpongeBE extends BlockEntity {
    public static final Block FINAL_BLOCK = Blocks.WATER;

    private int tickCounter = 0;
    private BlockPos corePos = BlockPos.ZERO;
    private boolean continueChaining = true;
    private boolean replacedWithFinalBlock = false;

    protected AbstractWateringSpongeBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    protected abstract int getRadius();
    protected abstract int getHeight();
    protected abstract int getMaxTicks();
    protected abstract int getTicksPerBlock();
    protected abstract boolean isFillBreakable();

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T blockEntity) {
        if (level.isClientSide) return;
        if (!(blockEntity instanceof AbstractWateringSpongeBE be)) return;
        be.tick(level, pos, state);
    }

    private void tick(Level level, BlockPos pos, BlockState state) {
        this.tickCounter++;
        if (this.tickCounter == 1) {
            this.initializeCore(pos);
        }

        if (this.tickCounter > this.getMaxTicks()) {
            this.breakSelf(level, pos);
            return;
        }

        BlockState coreState = level.getBlockState(this.corePos);

        // コアが人為的に破壊されたらすべての処理をキャンセル
        if (coreState.isAir()) {
            var replaceTo = this.replacedWithFinalBlock ? FINAL_BLOCK : Blocks.AIR;
            level.setBlockAndUpdate(pos, replaceTo.defaultBlockState());
            return;
        }

        // コアが自然消滅したらチェーン停止
        if (!coreState.is(state.getBlock()) || !coreState.getValue(WateringSpongeBlock.CORE)) {
            this.continueChaining = false;
        }

        if (this.continueChaining && this.tickCounter % this.getTicksPerBlock() == 0) {
            for (Direction dir : Direction.values()) {
                if (dir == Direction.UP) continue;
                this.chain(level, pos.relative(dir), state);
            }
            this.continueChaining = false;
        }
    }

    private void initializeCore(BlockPos pos) {
        if (this.corePos.equals(BlockPos.ZERO)) {
            this.corePos = pos;
        }
    }

    private void breakSelf(Level level, BlockPos pos) {
        level.destroyBlock(pos, false); // アイテムドロップ: false
        level.setBlockAndUpdate(pos, FINAL_BLOCK.defaultBlockState());
    }

    private void chain(Level level, BlockPos chainedPos, BlockState selfState) {
        var chainedState = level.getBlockState(chainedPos);

        // チェーン先が空気でも置換先ブロックでもないならチェック
        if (!chainedState.isAir() && !chainedState.is(FINAL_BLOCK)) {
            if (!this.isFillBreakable()) return;
            if (chainedState.getPistonPushReaction() != PushReaction.DESTROY) return;
            // ピストンで破壊可能なブロックなので続行
        }

        // チェーン先が範囲外なら中止
        if (
                Math.abs(this.corePos.getX() - chainedPos.getX()) > this.getRadius() ||
                Math.abs(this.corePos.getZ() - chainedPos.getZ()) > this.getRadius() ||
                Math.abs(this.corePos.getY() - chainedPos.getY()) > this.getHeight()
        ) {
            return;
        }

        // チェーン先が置き換えブロックでないなら破壊
        boolean replaceWithFinalBlock = chainedState.is(FINAL_BLOCK);
        if (!replaceWithFinalBlock) {
            level.destroyBlock(chainedPos, true); // アイテムドロップ: true
            // チェーン先のエンティティをコアの位置にテレポート
            level.getEntities(null, new AABB(chainedPos))
                    .forEach(entity -> entity.teleportTo(
                            this.corePos.getX() + 0.5,
                            this.corePos.getY() + 0.5,
                            this.corePos.getZ() + 0.5
                    ));
        }

        level.setBlockAndUpdate(chainedPos, selfState
                .getBlock()
                .defaultBlockState()
                .setValue(WateringSpongeBlock.CORE, false)
        );
        if (!(level.getBlockEntity(chainedPos) instanceof AbstractWateringSpongeBE chainedBE)) return;
        chainedBE.tickCounter = 1;
        chainedBE.corePos = this.corePos;
        chainedBE.replacedWithFinalBlock = replaceWithFinalBlock;
    }
}
