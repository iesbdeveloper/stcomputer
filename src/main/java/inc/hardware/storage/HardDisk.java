package inc.hardware.storage;
import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.ListaLigada;
import inc.hardware.so.FileSystem.No;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class HardDisk implements Sata {
    private final List<HardDiskHead> diskHeadList;

    private final long iD;
    private final int sectorSize;
    private final long tracks;
    private final long sectors;
    private final long heads;

    public HardDisk(long id, long track, long heads, long sector, int sectorSize) {
        this.iD = id;
        this.heads = heads;
        this.tracks = track;
        this.sectors = sector;
        this.sectorSize = sectorSize;
        this.diskHeadList= new LinkedList<>();
        for (long head = 1; head <= heads; head++ )
        {
            diskHeadList.add(new HardDiskHead(head,track,sector,sectorSize));
        }
    }

    protected HardDiskSector getEmptySector() {

        HardDiskSector sector = null;
        for (HardDiskHead disc : diskHeadList ) {
            for (HardDiskTrack diskTrack : disc.getDiskTrackList()) {
                if (diskTrack.isFull() == false)
                {
                    sector = diskTrack.createSector();
                }
                if (diskTrack.isFull() == true)
                {
                    System.out.println(diskTrack.getId());
                }
            }
        }
        return sector;
    }

    public long getiD() {
        return this.iD;
    }

    @Override
    public No<Long> write(byte[] dado) {
        if (espacoLivre() == 0) {
            return null;
        }
        HardDiskSector givenSector = getEmptySector();
        String fileName =  givenSector.getiD() + ".bin";
//        //String storageUnitPath = "d:\\data";
//
//        Path storageUnit = Paths.get("/home/rafael/Documentos/JavaDocs/myfile.txt");
        ListaLigada<Long> lista = new ListaLigada<>();
        byte[] aux = new byte[sectorSize];

        if(dado.length > sectorSize)
        {
            double qttySector = dado.length / sectorSize;

            for(double j=0; j<qttySector; j++)
            {
                //
                int k=0;

                if(j>0)
                {
                    k = (int) (sectorSize * j);
                }

                for(int i=0; i<sectorSize; i++)
                {
                    if(dado[i+k] != 0)
                        aux[i] = dado[i+k];
                    else
                        aux[i] = 0;
                }
                try
                {
                    ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName));
                    for (byte inter : aux) {
                        file.writeByte(inter);
                    }
                    file.close();
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }

                givenSector.setDado(aux);
                lista.inserir(givenSector.getiD());
            }
        }
        else{
            for (int i=0; i < dado.length; i++)
            {
                if(dado[i] != 0)
                    aux[i] = dado[i];
                else
                    aux[i] = 0;
            }

            try
            {
                ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName));
                for (byte inter : aux) {
                    file.writeByte(inter);
                }
                file.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            givenSector.setDado(aux);
            lista.inserir(givenSector.getiD());
        }

        return lista.recuperarNo(0);
    }

    @Override
    public byte[] read(No<Long> dado) {

        ByteArrayOutputStream Baos = new ByteArrayOutputStream();

        while (dado != null)
        {
            for (HardDiskHead diskHead: diskHeadList)
            {
                for (HardDiskTrack diskTrack: diskHead.getDiskTrackList())
                {
                    for (HardDiskSector diskSector: diskTrack.getSectorList())
                    {
                        if (diskSector.getiD() == dado.getElemento())
                        {
                            try {
                                Baos.write(diskSector.getDado());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
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
        return (this.heads * this.tracks * this.sectors * sectorSize);
    }
    @Override
    public long espacoLivre() {
        long qntty=0;
        for (HardDiskHead diskHead: diskHeadList)
        {
            for (HardDiskTrack diskTrack: diskHead.getDiskTrackList())
            {
                for (HardDiskSector diskSector: diskTrack.getSectorList())
                {
                    if (diskSector.getDado()[0] == -1)
                        qntty++;

                }

            }

        }
        //System.out.println(qntty);
        qntty = qntty * sectorSize;
        return qntty;
    }

    @Override
    public long espacoOcupado() {
        long qntty=0;
        for (HardDiskHead diskHead: diskHeadList)
        {
            for (HardDiskTrack diskTrack: diskHead.getDiskTrackList())
            {
                for (HardDiskSector diskSector: diskTrack.getSectorList())
                {
                    if (diskSector.getDado()[0] != -1)
                        qntty++;

                }
            }
        }
        //System.out.println(qntty);
        qntty = qntty * sectorSize;
        return qntty;
    }
    public void boot()
    {
        //ByteArrayInputStream Baos = new ByteArrayInputStream();

        for (HardDiskHead diskHead: diskHeadList)
        {
            for (HardDiskTrack diskTrack: diskHead.getDiskTrackList())
            {
                for (HardDiskSector diskSector: diskTrack.getSectorList())
                {
                    String fileName = diskSector.getiD() + ".bin";
                        try {
                             Path path = Paths.get(fileName);
                             byte[] data = Files.readAllBytes(path);
                             diskSector.setDado(data);
//                            Baos.write(diskSector.getDado());
                             }
                        catch (IOException e)
                            {
                           // System.out.println(e.getMessage());
                            }

                }

            }

        }
    }
}
