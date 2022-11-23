package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.PCIE16X;

import java.util.ArrayList;
import java.util.List;

public class PCIE16XController {

    List<PCIE16X> pcie16x = new ArrayList<>();

    public void connectPcie16x(PCIE16X peripheral){
        pcie16x.add(peripheral);
    }

    public void removePcie16x(PCIE16X peripheral){
        pcie16x.remove(peripheral);
    }
}
