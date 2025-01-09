package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import org.hiedacamellia.gpuinfoapi.core.gpu.IGpuMemory;

public class NVMLMemory extends Structure implements IGpuMemory {

    public long total;
    public long free;
    public long used;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("total", "free", "used");
    }

    @Override
    public long totalMemory() {
        return total;
    }

    @Override
    public long freeMemory() {
        return free;
    }

    @Override
    public long usedMemory() {
        return used;
    }

    public static class ByReference extends NVMLMemory implements Structure.ByReference {
    }

    public static class ByValue extends NVMLMemory implements Structure.ByValue {
    }
}
