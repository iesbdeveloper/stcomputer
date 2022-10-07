package inc.hardware.storage;
import java.util.*;
public class HardDiskTrack {
    private final long id;
    private final List<HardDiskSector> sectorList ;

    public HardDiskTrack(long id, long sectors, int sizeOfSector) {
        this.id = id;
        String l = String.valueOf(sizeOfSector);
        this.sectorList = new LinkedList<HardDiskSector>();
        for (long head = 1 ; head <= sectors ; head++)
        {
            String Id = String.valueOf(id) + String.valueOf(sectors);
            sectorList.add(new HardDiskSector(Long.valueOf(Id),Integer.parseInt(l)));
        }
    }

    public long getId() {
        return id;
    }
    public List<HardDiskSector> getSectorList() {
        return sectorList;
    }
    public HardDiskSector createSector() {
        for (HardDiskSector hardDiskSector : sectorList) {
            if (hardDiskSector.getDado() == null) {
                return hardDiskSector;
            }
        }
        return null;
    }
}
