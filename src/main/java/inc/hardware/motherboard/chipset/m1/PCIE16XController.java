package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.PCIE16X;
import inc.hardware.interfaces.Sata;
import inc.hardware.interfaces.VideoPCIE16X;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PCIE16XController {

    static List<PCIE16X> pcie16x = new ArrayList<>();
    public static void connectPcie16x(PCIE16X peripheral){
        pcie16x.add(peripheral);
    }

    public static void removePcie16x(PCIE16X peripheral){
        pcie16x.remove(peripheral);
    }

    public static VideoPCIE16X getVideoPCI(){
        int index = pcie16x.size();
        for (int i = 0; i < index; i++)
        {
            if (pcie16x.get(i).getType() == PCIE16X.PeripheralType.VideoCard)
            {
                return (VideoPCIE16X) pcie16x.get(i);
            }
        }
        return null;
    }

}
