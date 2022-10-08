package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Sata;

import java.util.List;
import java.util.ArrayList;

public class HardDiskController {

    List<Sata> hd = new ArrayList<>();
    private int i;
    private Sata hdSlot1;
    private Sata hdSlot2;
    private Sata hdSlot3;
    private Sata hdSlot4;

    public List<Sata> getHd() {
        return hd;
    }

    public void connectSata(Sata peripheral) {
        if(hd == null){
            hd.add(hdSlot1);
            i++;
        }else if(i == 1){
            hd.add(hdSlot2);
            i++;
        }else if(i == 2){
            hd.add(hdSlot3);
            i++;
        }else if(i == 3){
            hd.add(hdSlot4);
            i++;
        }else if(i == 4){
            return;
        }
    }
    public void removeSata(Sata peripheral){
        if(i == 0) {
            return;
        } else if(i == 1){
            hd.remove(hdSlot1);
        } else if(i == 2){
            hd.remove(hdSlot2);
        } else if(i == 3){
            hd.remove(hdSlot3);
        } else if(i == 4){
            hd.remove(hdSlot4);
        }
    }
}
