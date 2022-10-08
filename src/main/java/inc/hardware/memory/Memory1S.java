package inc.hardware.memory;

import inc.hardware.interfaces.Memory;

/**
 * 4096 Bytes of memory
 */
public class Memory1S implements Memory {

    @Override
    public byte get(short address) {
        if(address>0xFFF){
            System.err.println(String.format("Memory GET access out of range: 0x%4s",address));
            return 0x0;
        }
        else{
            return memory[address];
        }
    }

    @Override
    public void set(short address, byte content) {
        if(address>0xFFF){
            System.err.println(String.format("Memory SET access out of range: 0x%4s", address));
        }
        else{
            memory[address] = content;
        }
    }

}
