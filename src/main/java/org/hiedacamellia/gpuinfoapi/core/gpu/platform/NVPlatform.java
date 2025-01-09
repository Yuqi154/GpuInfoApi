package org.hiedacamellia.gpuinfoapi.core.gpu.platform;

import de.bommel24.nvmlj.NVMLDevice;
import de.bommel24.nvmlj.NVMLJ;
import de.bommel24.nvmlj.NVMLJException;
import org.hiedacamellia.gpuinfoapi.GpuInfoApi;
import org.hiedacamellia.gpuinfoapi.core.gpu.device.IDevice;
import org.hiedacamellia.gpuinfoapi.core.gpu.device.NVDevice;

public class NVPlatform implements IPlatform {

    public static final NVPlatform INSTANCE = new NVPlatform();

    protected static int deviceCount;
    protected static NVDevice[] devices;

    public void init(){
        try {
            NVMLJ.nvmlInit();
            deviceCount = nvmlDeviceGetCount();
            devices = new NVDevice[deviceCount];
            for(int i = 0; i < deviceCount; i++){
                devices[i] = new NVDevice(getDeviceHandle(i));
            }
        } catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to initialize NVMLJ", e);
        }
    }

    public static IPlatform getInstance() {
        return INSTANCE;
    }

    @Override
    public String driverVersion() {
        return getSystemDriverVersion();
    }

    public static void shutdown(){
        try {
            NVMLJ.nvmlShutdown();
        } catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to shutdown NVMLJ", e);
        }
    }

    @Override
    public int getDeviceCount() {
        return deviceCount;
    }

    @Override
    public IDevice getDevice(int index) {
        return devices[index];
    }


    //NVMLJ.nvmlDeviceGetCount()
    private static int nvmlDeviceGetCount(){
        try {
            return NVMLJ.nvmlDeviceGetCount();
        } catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get device count", e);
        }
        return -1;
    }

    //NVMLJ.nvmlDeviceGetHandleByIndex()
    private static NVMLDevice getDeviceHandle(int index){
        try {
            return NVMLJ.nvmlDeviceGetHandleByIndex(index);
        } catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get device handle", e);
        }
        return null;
    }

    //NVMLJ.nvmlSystemGetDriverVersion()
    public static String getSystemDriverVersion(){
        try {
            return NVMLJ.nvmlSystemGetDriverVersion();
        } catch (NVMLJException e) {
            GpuInfoApi.LOGGER.error("Failed to get system driver version", e);
        }
        return null;
    }


}
