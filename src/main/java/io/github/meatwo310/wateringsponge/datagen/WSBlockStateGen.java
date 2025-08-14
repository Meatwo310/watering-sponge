package io.github.meatwo310.wateringsponge.datagen;

import io.github.meatwo310.wateringsponge.WateringSponge;
import io.github.meatwo310.wateringsponge.block.WSBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class WSBlockStateGen extends BlockStateProvider {
    public WSBlockStateGen(PackOutput output, ExistingFileHelper efh) {
        super(output, WateringSponge.MODID, efh);
    }

    @Override
    protected void registerStatesAndModels() {
        cubeAllBlockWithItem(WSBlocks.WATERING_SPONGE_CORE);
    }

    private void cubeAllBlockWithItem(RegistryObject<Block> registryObject) {
        Block block = registryObject.get();
        simpleBlockWithItem(block, cubeAll(block));
    }
}
