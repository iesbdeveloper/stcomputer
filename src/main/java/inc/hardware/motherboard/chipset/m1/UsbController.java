package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Usb;

import java.util.ArrayList;
import java.util.List;

public class UsbController {

    static List<Usb> usb = new ArrayList<>();

    public static void connectUsb(Usb peripheral){
        usb.add(peripheral);
    }

    public static void removeUsb(Usb peripheral){
        usb.remove(peripheral);
    }

}