package dev.meatwo310.watering_sponge.blockentitys;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.register.BlockEntityRegister;
import dev.meatwo310.watering_sponge.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;

import java.util.Objects;

public class WateringSpongeBlockEntity extends BlockEntity {
    private int timer = 0;
    private final int TIMER_THRESHOLD = 7;
    private final int TIMER_LIMIT = 30 * TIMER_THRESHOLD;
    private final int RANGE_XZ;
    private final int RANGE_Y;
    private final boolean REPLACE_REPLACEABLE;
    private BlockPos originalPos;
    private boolean searchMore = true;
    public final Block NEW_BLOCK;
    public boolean alreadyNewBlock = false;

    public WateringSpongeBlockEntity(BlockPos pos, BlockState state, int rangeXZ, int rangeY) {
        super(BlockEntityRegister.WATERING_SPONGE_MEDIUM.get(), pos, state);
        this.RANGE_XZ = rangeXZ;
        this.RANGE_Y = rangeY;
        this.NEW_BLOCK = Blocks.WATER;
        this.REPLACE_REPLACEABLE = true;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
        if (level.isClientSide()) return;

        WateringSpongeBlockEntity blockEntity = (WateringSpongeBlockEntity) be;

        blockEntity.timer++;

        // 最初に設置されたブロックの場合
        if (blockEntity.timer == 1) {
            blockEntity.originalPos = pos;
        }
        // タイマーが制限値に達したら自身を破壊し、水に変える
        if (blockEntity.timer > blockEntity.TIMER_LIMIT) {
            level.destroyBlock(pos, false);
            level.setBlockAndUpdate(pos, blockEntity.NEW_BLOCK.defaultBlockState());
            return;
        }

        BlockState originalBlockState = level.getBlockState(blockEntity.originalPos);

        // 親ブロックが自身のブロックと異なる場合
        if (!originalBlockState.is(state.getBlock())) {
            // 探索を終了
            blockEntity.searchMore = false;
            // 親ブロックが破壊された場合は処理をキャンセル
            if (originalBlockState.isAir()) {
                level.destroyBlock(pos, false);
                if (blockEntity.alreadyNewBlock) {
                    level.setBlockAndUpdate(pos, blockEntity.NEW_BLOCK.defaultBlockState());
                } else {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
            }
            return;
        }

        // 他のブロックの探索を行わない場合
        if (!blockEntity.searchMore) {
            return;
        }

        // 一定時間ごとに周囲のブロックを探索
        if (blockEntity.timer % blockEntity.TIMER_THRESHOLD == 0) {
            //                BlockPos.betweenClosed(
            //                        pos.offset(1, 0, 1),
            //                        pos.offset(-1, -1, -1)
            //                ).forEach(p -> chain(level, p, state, blockEntity));
            chain(level, pos.north(), state, blockEntity);
            chain(level, pos.east(), state, blockEntity);
            chain(level, pos.south(), state, blockEntity);
            chain(level, pos.west(), state, blockEntity);
            chain(level, pos.below(), state, blockEntity);
        }

    }

    private static void chain(Level level, BlockPos pos, BlockState state, WateringSpongeBlockEntity blockEntity) {
        BlockState newPosState = level.getBlockState(pos);
        boolean alreadyNewBlock = newPosState.is(blockEntity.NEW_BLOCK);
        if (!newPosState.isAir() && !newPosState.is(blockEntity.NEW_BLOCK)) {
            if (!blockEntity.REPLACE_REPLACEABLE) {
                blockEntity.searchMore = false;
                return;
            }
            if (!newPosState.getMaterial().isReplaceable() &&
                            !newPosState.getPistonPushReaction().equals(PushReaction.DESTROY)
            ) {
                blockEntity.searchMore = false;
                return;
            }
        }
        if (Math.abs(pos.getX() - blockEntity.originalPos.getX()) >= blockEntity.RANGE_XZ ||
                Math.abs(pos.getZ() - blockEntity.originalPos.getZ()) >= blockEntity.RANGE_XZ ||
                Math.abs(pos.getY() - blockEntity.originalPos.getY()) >= blockEntity.RANGE_Y
        ) {
            blockEntity.searchMore = false;
            return;
        }

        if (!newPosState.is(blockEntity.NEW_BLOCK)) {
            level.destroyBlock(pos, true);
            // teleports dropped items to the original position
            level.getEntities(null, new AABB(
                    pos.getX(),
                    pos.getY(),
                    pos.getZ(),
                    pos.getX() + 1.0,
                    pos.getY() + 1.0,
                    pos.getZ() + 1.0
            )).forEach(item -> item.teleportTo(
                    blockEntity.originalPos.getX() + 0.5,
                    blockEntity.originalPos.getY() + 0.5,
                    blockEntity.originalPos.getZ() + 0.5
            ));
        }

        level.setBlockAndUpdate(pos, BlockRegister.WATERING_SPONGE_MEDIUM.get().defaultBlockState());
        final WateringSpongeBlockEntity e = (WateringSpongeBlockEntity) level.getBlockEntity(pos);
        if (Objects.isNull(e)) {
            WateringSponge.LOGGER.warn("BlockEntity is null");
        } else {
            //            e.timer = blockEntity.timer;
            e.timer = 1;
            e.originalPos = blockEntity.originalPos;
            e.alreadyNewBlock = alreadyNewBlock;
        }
    }
}
