package inc.hardware.storage;
import java.util.*;
import storage.*;
public class HardDiskTrack {
    private final long id;
    private final List<HardDiskSector> sectorList  = new LinkedList<HardDiskSector>();
    public long getId() {
        return id;
    }
    public List<HardDiskSector> getSectorList() {
        return sectorList;
    }



}
