package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Sata;

import java.util.List;
import java.util.ArrayList;

public class HardDiskController {

    List<Sata> hd = new ArrayList<>();
    private int i;

    public List<Sata> getHds() {
        return hd;
    }


    public void connectSata(Sata peripheral) {
        if(hd == null){
            Sata hdSlot1 = new Sata;
            hd.add(hdSlot1);
            i++;
        }else if(i == 1){
            Sata hdSlot2 = new Sata;
            hd.add(hdSlot2);
            i++;
        }else if(i == 2){
            Sata hdSlot3 = new Sata;
            hd.add(hdSlot3);
            i++;
        }else if(i == 3){
            Sata hdSlot4 = new Sata;
            hd.add(hdSlot4);
            i++;
        }
    }
}
