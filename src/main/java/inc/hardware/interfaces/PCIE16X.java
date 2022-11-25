package inc.hardware.interfaces;

import java.awt.*;

public interface PCIE16X {
    enum PeripheralType {
        VideoCard, NetworkCard, SoundCard, WirelessNetworkCard
    }

    PeripheralType getType();
}
