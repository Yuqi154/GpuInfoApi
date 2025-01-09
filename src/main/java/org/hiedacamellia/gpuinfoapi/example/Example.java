package org.hiedacamellia.gpuinfoapi.example;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.gpuinfoapi.GpuInfoApi;
import org.hiedacamellia.gpuinfoapi.core.gpu.IGpuMemory;
import org.hiedacamellia.gpuinfoapi.core.gpu.IUtilization;
import org.hiedacamellia.gpuinfoapi.core.gpu.device.IDevice;
import org.hiedacamellia.gpuinfoapi.core.gpu.platform.IPlatform;

@OnlyIn(Dist.CLIENT)
public class Example {

    public static void example() {
        IPlatform instance = GpuInfoApi.getPlatform();

        GpuInfoApi.LOGGER.debug("Device count: {}", instance.getDeviceCount());
        GpuInfoApi.LOGGER.debug("Driver version: {}", instance.driverVersion());
        IDevice device = instance.getDevice(0);
        GpuInfoApi.LOGGER.debug("Device name: {}", device.deviceName());
        IGpuMemory memory = device.memory();
        GpuInfoApi.LOGGER.debug("Total memory: {}", memory.totalMemory());
        GpuInfoApi.LOGGER.debug("Free memory:{}", memory.freeMemory());
        GpuInfoApi.LOGGER.debug("Used memory: {}", memory.usedMemory());
        GpuInfoApi.LOGGER.debug("Graphics clock: {}", device.GpuClock());
        GpuInfoApi.LOGGER.debug("Memory clock: {}", device.MemoryClock());
        GpuInfoApi.LOGGER.debug("Temperature: {}", device.Temperature());
        IUtilization utilization = device.utilization();
        GpuInfoApi.LOGGER.debug("GPU utilization: {} %", utilization.gpuUsage());
        GpuInfoApi.LOGGER.debug("Memory utilization: {} %", utilization.memoryUsage());


    }

}
