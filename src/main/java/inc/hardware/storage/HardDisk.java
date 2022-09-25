package inc.hardware.storage;
import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.ListaLigada;
import inc.hardware.so.FileSystem.No;

import java.util.*;

public class HardDisk implements Sata {
    private final List<HardDiskHead> diskHeadList;
    private final long iD;

    private final int sectorSize;

    private final long tracks;
    private final long sectors;
    private final long heads;

    public HardDisk(long id,long track, long heads, long sector, int sectorSize) {
        this.sectorSize = sectorSize;
        this.iD = id;
        this.heads = heads;
        this.tracks = track;
        this.sectors = sector;
        this.diskHeadList= new LinkedList<HardDiskHead>();
        for (long head = 1; head < heads; head++ )
        {
            diskHeadList.add(new HardDiskHead(head,track,sector,sectorSize));
        }
    }
    protected HardDiskSector getEmptySector()
    {
        for (HardDiskHead disc : diskHeadList ) {
            for (HardDiskTrack diskTrack : disc.getDiskTrackList()) {
                HardDiskSector sector = diskTrack.createSector();
                if (sector.getDado() == null)
                    return sector;
            }
        }
        return null;
    }

    @Override
    public No<Long> write(byte[] dado) {

        ListaLigada<Long> lista = new ListaLigada<Long>();
        byte aux[] = new byte[sectorSize];

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

                HardDiskSector givenSector = getEmptySector();
                givenSector.setDado(aux);
                lista.inserir(givenSector.getiD());
            }
        }
        else{
            for (int i=0; i<sectorSize; i++)
            {
                if(dado[i]!=0)
                    aux[i] = dado[i];
                else
                    aux[i] = 0;
            }
            
            HardDiskSector givenSector = getEmptySector();
            givenSector.setDado(aux);
            lista.inserir(givenSector.getiD());
        }

        return lista.recuperarNo(0);
    }

    @Override
    public Byte[] read(ListaLigada<Long> lista) {
        Byte[] aux = new Byte[lista.getTamanho()*sectorSize];
        No<Long> inaux = lista.getPrimeirono();

        while (inaux != null)
        {
            long intraHead = Long.valueOf(String.valueOf(inaux.getElemento()).substring(0,1));
            for (HardDiskHead head : diskHeadList)
            {
                if(intraHead == head.getiD())
                {
                    for(HardDiskTrack track : head.getDiskTrackList())
                    {
                        
                    }
                }
            }
            inaux = inaux.getProximo();
        }



        return aux;
    }


}
