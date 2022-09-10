package inc.hardware.memory;

/**
 * 4096 Bytes of memory
 */
public class Memory1S implements MemoryBank{

    protected int startAddress;
    protected long size;

    protected byte[][] armazenamento = new byte[4096][];

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public int getStartAddress() {
        return startAddress;
    }

    @Override
    public void read(int startAddress, byte[] readBuf, int offset, int len) {

    }

    @Override
    public void write(int startAddress, byte[] writeBuf, int offset, int len) {

    }
}
