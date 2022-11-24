package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Memory;
import inc.hardware.interfaces.Sata;

import java.util.ArrayList;
import java.util.List;

public class MemoryController {

    static List<Memory> ddr = new ArrayList<>();

    public List<Memory> getDdr(){
        return ddr;
    }

    public static void connectMemory(Memory peripheral){
        ddr.add(peripheral);
    }

    public static void removeMemory(Memory peripheral){
        ddr.remove(peripheral);
    }

    public byte get(int index, short address){
        Memory x = ddr.get(index);
        return x.get(address);
    }

    public void set(int index, short address, byte content){

    }
}
