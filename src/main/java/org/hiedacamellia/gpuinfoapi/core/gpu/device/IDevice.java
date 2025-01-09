package org.hiedacamellia.gpuinfoapi.core.gpu.device;

import org.hiedacamellia.gpuinfoapi.core.gpu.IGpuMemory;
import org.hiedacamellia.gpuinfoapi.core.gpu.IUtilization;

public interface IDevice {

    String deviceName();

    IGpuMemory memory();

    IUtilization utilization();

    int GpuClock();

    int MemoryClock();

    int Temperature();
}
