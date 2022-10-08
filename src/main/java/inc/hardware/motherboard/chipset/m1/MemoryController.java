package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.Memory;
import inc.hardware.interfaces.Sata;

import java.util.ArrayList;
import java.util.List;

public class MemoryController {

    List<Memory> memory = new ArrayList<>();

    private int i;

    private Memory memorySlot1;
    private Memory memorySlot2;

    public List<Memory> getMemory() {
        return memory;
    }

    public void setMemory(List<Memory> memory) {
        this.memory = memory;
    }

    public void connectMemory(Memory peripheral){
        if(memory == null){
            Memory memorySlot1 = new Memory;
            memory.add(memorySlot1);
            i++;
        }else if(i == 1){
            Memory memorySlot1 = new Memory;
            memory.add(memorySlot1);
            i++;
        }else if(i == 2){
            return;
        }
    }
}
