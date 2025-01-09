package org.hiedacamellia.gpuinfoapi.core.gpu;

public interface IGpuMemory {

    long totalMemory();

    long freeMemory();

    long usedMemory();
}
