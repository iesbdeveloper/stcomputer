package inc.hardware.storage;

import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.No;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    private SSDSector getEmptySector()
    {
        SSDSector sector = null;
        for (SSDNAND s : ssdnandList ) {
            if (s.isFull() == false)
            {
                sector = s.freeSector();
            }
            if (s.isFull() == true)
            {
                System.out.println(s.getId());
            }
        }
        return sector;
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
        long qntty=0;
        long qnttyS = 0;
        for (SSDNAND s: ssdnandList) {
            if (s.isFull() == false)
            {
                qnttyS++;
            }
            else {
                for (SSDSector t : s.getSectorList()) {
                    if (t.getDado()[0] == -1) {
                        qntty++;
                    }
                }
            }
        }
        //System.out.println(qntty);
        qntty = qntty * getSectorSize() +(qnttyS * getNANDSize());
        return qntty;
    }

    @Override
    public long espacoOcupado() {
        long qntty=0;
        long qnttyS = 0;
        for (SSDNAND s: ssdnandList) {
            if (s.isFull() == true)
            {
                qnttyS++;
            }
            else {
                for (SSDSector t : s.getSectorList()) {
                    if (t.getDado()[0] != -1) {
                        qntty++;
                    }
                }
            }
        }
        //System.out.println(qntty);
        qntty = qntty * getSectorSize() +(qnttyS * getNANDSize());
        return qntty;
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
