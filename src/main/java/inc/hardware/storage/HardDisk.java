package inc.hardware.storage;
import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.ListaLigada;
import java.util.*;

public class HardDisk implements Sata {
    private final List<HardDiskHead> diskHeadList;
    private final long iD;
    public HardDisk(long id,long track, long heads, long sector, long sectorSize) {
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
    public ListaLigada<long> write()
    {
        ListaLigada<long> lista = new ListaLigada<long>();
        return lista ;
    }



}
