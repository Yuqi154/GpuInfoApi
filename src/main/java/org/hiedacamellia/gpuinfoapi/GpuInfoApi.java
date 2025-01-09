package org.hiedacamellia.gpuinfoapi;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.hiedacamellia.gpuinfoapi.core.gpu.platform.IPlatform;
import org.hiedacamellia.gpuinfoapi.core.gpu.platform.NVPlatform;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(GpuInfoApi.MODID)
public class GpuInfoApi {
    public static final String MODID = "gpuinfoapi";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GpuInfoApi(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(GpuInfoApi::onClientSetup);
    }

    private static IPlatform platform;

    public static IPlatform getPlatform() {
        return platform;
    }

    public static void onClientSetup(FMLClientSetupEvent event){
        // Initialize the platform
        try {
            NVPlatform.INSTANCE.init();
            platform = NVPlatform.INSTANCE;
            GpuInfoApi.LOGGER.debug("NVPlatform initialized");
        } catch (Exception e) {
            GpuInfoApi.LOGGER.debug("Failed to initialize NVPlatform");
        }
    }
}
