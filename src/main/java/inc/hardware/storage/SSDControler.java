package inc.hardware.storage;

import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.No;

import java.util.LinkedList;
import java.util.List;

public class SSDControler implements Sata {
    private final long id;
    private final long NANDSize;
    private final long size;
    private final List<SSDNAND> ssdnandList;
    private final long SectorSize;

    public SSDControler(long id, long NANDSize,long size,int sectorsize) {
        this.id = id;
        this.NANDSize = NANDSize;
        this.size = size;
        this.SectorSize = sectorsize;
        this.ssdnandList = new LinkedList<>();
        for (int i = 0; i < size/NANDSize; i++) {

            ssdnandList.add(new SSDNAND(i,NANDSize/sectorsize,sectorsize));
        }


    }

    @Override
    public No<Long> write(byte[] dado) {
        return null;
    }

    @Override
    public byte[] read(No<Long> dado) {
        return new byte[0];
    }

    @Override
    public long espacoTotal() {
        return 0;
    }

    @Override
    public long espacoLivre() {
        return 0;
    }

    @Override
    public long espacoOcupado() {
        return 0;
    }

    public long getSectorSize() {
        return SectorSize;
    }

    public long getId() {
        return id;
    }

    public long getNANDSize() {
        return NANDSize;
    }

    public long getSize() {
        return size;
    }
}
