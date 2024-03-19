package dev.meatwo310.watering_sponge.provider;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.register.BlockRegister;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {

    public BlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, WateringSponge.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlockItem(BlockRegister.WATERING_SPONGE_MEDIUM.get(), this.cubeAll(BlockRegister.WATERING_SPONGE_MEDIUM.get()));
        this.simpleBlockItem(BlockRegister.WATERING_SPONGE_LARGE.get(), this.cubeAll(BlockRegister.WATERING_SPONGE_LARGE.get()));
    }
}
