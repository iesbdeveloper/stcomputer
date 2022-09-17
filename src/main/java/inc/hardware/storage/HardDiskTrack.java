package inc.hardware.storage;
import java.util.*;
public class HardDiskTrack {
    private final long id;
    private final long heads;
    private final long sizeOfSector;



    private final List<HardDiskSector> sectorList ;

    public HardDiskTrack(long id, long heads, long sizeOfSector) {
        this.id = id;
        this.heads = heads;
        this.sizeOfSector = sizeOfSector;
        String l = String.valueOf(sizeOfSector);
        this.sectorList = new LinkedList<HardDiskSector>();
        for (long head = 1 ; head < heads ; head++)
        {
            sectorList.add(new HardDiskSector(head,Integer.parseInt(l)));
        }
    }

    public long getId() {
        return id;
    }
    public List<HardDiskSector> getSectorList() {
        return sectorList;
    }
    public HardDiskSector createSector()
    {
        for (HardDiskSector hardDiskSector : sectorList) {
            if (hardDiskSector.getDado() == null) {
                return hardDiskSector;
            }
        }
        return null;
    }
}
