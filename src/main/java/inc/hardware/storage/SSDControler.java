package inc.hardware.storage;

import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.No;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SSDControler implements Sata {
    private final long id;
    private final long NANADSize;
    private final long size;
    private final List<SSDNAND> ssdnandList;
    private final long SectorSize;

    public SSDControler(long id, long NANADSize,long size,int sectorsize) {
        this.id = id;
        this.NANADSize = NANADSize;
        this.size = size;
        this.SectorSize = sectorsize;
        this.ssdnandList = new LinkedList<>();
        for (int i = 0; i < size/NANADSize; i++) {

            ssdnandList.add(new SSDNAND(i,NANADSize/sectorsize,sectorsize));
        }


    }


    @Override
    public No<Long> write(byte[] dado) {
        return null;
    }

    @Override
    public byte[] read(No<Long> dado) {
        ByteArrayOutputStream Baos = new ByteArrayOutputStream();

        while (dado != null)
        {
            for (SSDNAND s: ssdnandList)
            {
                for (SSDSector t: s.getSectorList())
                {
                    if (t.getiD() == dado.getElemento())
                    {
                        try {
                            Baos.write(t.getDado());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            dado = dado.getProximo();
        }

        return Baos.toByteArray();
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

    public long getNANADSize() {
        return NANADSize;
    }

    public long getSize() {
        return size;
    }
}
