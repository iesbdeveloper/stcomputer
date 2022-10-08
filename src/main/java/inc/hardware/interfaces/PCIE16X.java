package inc.hardware.interfaces;

public interface PCIE16X {
    enum PeripheralType {
        VideoCard, NetworkCard, SoundCard, WirelessNetworkCard
    }

    PeripheralType getType();
}
