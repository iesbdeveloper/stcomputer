package inc.hardware.storage;
import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.ListaLigada;
import java.util.*;

public class HardDisk implements Sata {
    private final List<HardDiskHead> diskHeadList;
    private final long iD;

    private final int sectorSize;

    public HardDisk(long id,long track, long heads, long sector, int sectorSize) {
        this.sectorSize = sectorSize;
        this.iD = id;
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
    public ListaLigada<Long> write(Byte[] dado) {
        ListaLigada<Long> lista = new ListaLigada<Long>();
        if(dado.length > sectorSize)
        {
            double qttySector = dado.length / sectorSize;

            for(double j=0; j<qttySector; j++)
            {
                int k=0;
                Byte aux[] = new Byte[sectorSize];

                if(j>0)
                {
                    k = (int) (sectorSize * j);
                }

                for(int i=0; i<sectorSize; i++)
                {
                    if(dado[i+k] != null)
                        aux[i] = dado[i+k];
                    else
                        aux[i] = 0;
                }

                HardDiskSector givenSector = getEmptySector();
                givenSector.setDado(aux);
                lista.inserir(givenSector.getiD());
            }
        }
        return lista;
    }

    @Override
    public Byte[] read(ListaLigada<Long> posicoes) {
        return new Byte[0];
    }
}
