package dev.meatwo310.watering_sponge.provider;

import dev.meatwo310.watering_sponge.WateringSponge;
import dev.meatwo310.watering_sponge.register.BlockRegister;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, WateringSponge.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture(
                BlockRegister.WATERING_SPONGE_MEDIUM.getId().getPath(),
                mcLoc(folder + "/generated"),
                "layer0",
                new ResourceLocation(WateringSponge.MODID, folder + "/water")
        );
    }
}
