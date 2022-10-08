package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.PCIE16X;
import inc.hardware.interfaces.Sata;
import inc.hardware.interfaces.Usb;

import java.util.List;

public class UsbController implements Usb {

    List<Usb> usbSlot;
    @Override
    public PeripheralType getType() {
        return null;
    }
}
