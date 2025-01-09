package org.hiedacamellia.gpuinfoapi.core.gpu.device;

import de.bommel24.nvmlj.*;
import org.hiedacamellia.gpuinfoapi.GpuInfoApi;
import org.hiedacamellia.gpuinfoapi.core.gpu.IGpuMemory;
import org.hiedacamellia.gpuinfoapi.core.gpu.IUtilization;

public class NVDevice implements IDevice {

    public NVMLDevice device;

    public NVDevice(NVMLDevice device) {
        this.device = device;
    }

    @Override
    public String deviceName() {
        try {
            return device.nvmlDeviceGetName();
        }catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get driver name");
            return null;
        }
    }

    @Override
    public IGpuMemory memory() {
        try {
            return device.nvmlDeviceGetMemoryInfo();
        }catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get memory info");
            return null;
        }
    }

    @Override
    public IUtilization utilization() {
        try {
            return device.nvmlDeviceGetUtilizationRates();
        }catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get utilization info");
            return null;
        }
    }

    @Override
    public int GpuClock() {
        try {
            return device.nvmlDeviceGetClock(NVMLClockType.NVML_CLOCK_GRAPHICS, NVMLClockId.NVML_CLOCK_ID_CURRENT);
        }catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get GPU clock");
            return 0;
        }
    }

    @Override
    public int MemoryClock() {
        try {
            return device.nvmlDeviceGetClock(NVMLClockType.NVML_CLOCK_MEM, NVMLClockId.NVML_CLOCK_ID_CURRENT);
        }catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get memory clock");
            return 0;
        }
    }

    @Override
    public int Temperature() {
        try {
            return device.nvmlDeviceGetTemperature(NVMLTemperatureSensors.NVML_TEMPERATURE_GPU);
        }catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get temperature");
            return 0;
        }
    }
}
