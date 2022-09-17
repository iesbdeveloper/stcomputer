package inc.hardware.interfaces;

import inc.hardware.exception.VideoNotFoundException;
import java.awt.*;

public interface Motherboard {
    Dimension getVideoResolution() throws VideoNotFoundException;

    void connectUsb(Usb peripheral);
    void removeUsb(Usb slot);

    void connectPcie(PCIE16X peripheral);
    void removePcie(PCIE16X slot);

    void connectSata(Sata peripheral);
    void removeSata(Sata slot);

    void connectCpu(LGA cpu);
    void removeCpu();

    void connectMemory(Memory peripheral);
    void removeMemory(Memory peripheral);
}
