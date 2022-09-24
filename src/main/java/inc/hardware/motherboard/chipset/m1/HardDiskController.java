package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Sata;
import inc.hardware.storage.HardDisk;

import java.util.List;

public class HardDiskController {

    List<Sata> Hd;

    public void setHd(List<Sata> hd) {
        Hd = hd;
    }
}
