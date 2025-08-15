package io.github.meatwo310.wateringsponge.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue WATERING_SPONGE_MAX_TICKS = BUILDER
            .comment("Maximum number of ticks the Watering Sponge runs before stopping.")
            .defineInRange("wateringSpongeMaxTicks", 240, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue WATERING_SPONGE_TICKS_PER_BLOCK = BUILDER
            .comment("Number of ticks the Watering Sponge takes to fill one block.")
            .defineInRange("wateringSpongeTicksPerBlock", 7, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue WATERING_SPONGE_RADIUS = BUILDER
            .comment("The radius in the X and Z directions that the Watering Sponge can fill.")
            .defineInRange("wateringSpongeXZRadius", 8 - 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue WATERING_SPONGE_HEIGHT = BUILDER
            .comment("The height in the Y direction that the Watering Sponge can fill.")
            .defineInRange("wateringSpongeYHeight", 16 - 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.BooleanValue WATERING_SPONGE_FILL_BREAKABLE = BUILDER
            .comment("Whether to replace blocks that can be broken by pistons.")
            .define("wateringSpongeFillBreakable", true);

    public static final ForgeConfigSpec.IntValue LARGE_WATERING_SPONGE_MAX_TICKS = BUILDER
            .comment("Maximum number of ticks the Large Watering Sponge runs before stopping.")
            .defineInRange("largeWateringSpongeMaxTicks", 480, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue LARGE_WATERING_SPONGE_TICKS_PER_BLOCK = BUILDER
            .comment("Number of ticks the Large Watering Sponge takes to fill one block.")
            .defineInRange("largeWateringSpongeTicksPerBlock", 7, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue LARGE_WATERING_SPONGE_RADIUS = BUILDER
            .comment("The radius in the X and Z directions that the Large Watering Sponge can fill.")
            .defineInRange("largeWateringSpongeXZRadius", 16 - 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue LARGE_WATERING_SPONGE_HEIGHT = BUILDER
            .comment("The height in the Y direction that the Large Watering Sponge can fill.")
            .defineInRange("largeWateringSpongeYHeight", 32 - 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.BooleanValue LARGE_WATERING_SPONGE_FILL_BREAKABLE = BUILDER
            .comment("Whether to replace blocks that can be broken by pistons.")
            .define("largeWateringSpongeFillBreakable", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
