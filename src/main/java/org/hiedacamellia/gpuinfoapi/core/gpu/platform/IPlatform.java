package org.hiedacamellia.gpuinfoapi.core.gpu.platform;

import org.hiedacamellia.gpuinfoapi.core.gpu.device.IDevice;

public interface IPlatform {

    void init();

    static IPlatform getInstance() {
        return null;
    }

    String driverVersion();

    int getDeviceCount();

    IDevice getDevice(int index);
}
