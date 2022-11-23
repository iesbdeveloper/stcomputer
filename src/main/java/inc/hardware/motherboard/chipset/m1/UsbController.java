package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Usb;

import java.util.ArrayList;
import java.util.List;

public class UsbController {

    List<Usb> usb = new ArrayList<>();

    public void connectUsb(Usb peripheral){
        usb.add(peripheral);
    }

    public void removeUsb(Usb peripheral){
        usb.remove(peripheral);
    }

}