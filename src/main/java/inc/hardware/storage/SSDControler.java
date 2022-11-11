package inc.hardware.storage;

import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.No;

import java.util.LinkedList;
import java.util.List;

public class SSDControler implements Sata {
    private final long id;
    private final long NANADSize;
    private final long size;
    private final List<SSDNAND> ssdnandList;
    private final long SectorSize;

    public SSDControler(long id, long NANADSize,long size,long sectorsize) {
        this.id = id;
        this.NANADSize = NANADSize;
        this.size = size;
        this.SectorSize = sectorsize;
        this.ssdnandList = new LinkedList<>();
        for (int i = 0; i < size/NANADSize; i++) {

            ssdnandList.add(new SSDNAND(i,));
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
}
