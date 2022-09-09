package inc.hardware.storage;
import java.util.*;
import storage.*;
public class HardDiskTrack {
    private final long id;
    private final long head;
    private final long sizeOfSector;



    private final List<HardDiskSector> sectorList ;

    public HardDiskTrack(long id, long head, long sizeOfSector, List<HardDiskSector> sectorList) {
        this.id = id;
        this.head = head;
        this.sizeOfSector = sizeOfSector;
        this.sectorList = new java.util.LinkedList<HardDiskSector>();
    }

    public long getId() {
        return id;
    }
    public List<HardDiskSector> getSectorList() {
        return sectorList;
    }
    public HardDiskSector createSector()
    {
        return null;
    }
}
