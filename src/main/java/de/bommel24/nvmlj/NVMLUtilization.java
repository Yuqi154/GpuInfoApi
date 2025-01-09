package de.bommel24.nvmlj;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import org.hiedacamellia.gpuinfoapi.core.gpu.IUtilization;

public class NVMLUtilization extends Structure implements IUtilization {

    public int gpu;
    public int memory;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("gpu", "memory");
    }

    @Override
    public int gpuUsage() {
        return gpu;
    }

    @Override
    public int memoryUsage() {
        return memory;
    }

    public static class ByReference extends NVMLUtilization implements Structure.ByReference {
    }

    public static class ByValue extends NVMLUtilization implements Structure.ByValue {
    }
}
