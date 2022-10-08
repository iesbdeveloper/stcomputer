package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Sata;

import java.util.List;
import java.util.ArrayList;

public class HardDiskController {

    List<Sata> Hds = new ArrayList<>();

    public List<Sata> getHds() {
        return Hds;
    }

    public void setHds(List<Sata> hds) {
        Hds = hds;
    }

    public void connectSata(Sata peripheral) {

    }
}
