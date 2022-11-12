package inc.hardware.storage;
import java.util.*;
public class HardDiskTrack {


    private final long id;
    private final List<HardDiskSector> sectorList ;
    private boolean full;
    private final long sectors;

    public HardDiskTrack(long id, long sectors, int sizeOfSector) {
        this.id = id;
        this.sectors = sectors;
        String l = String.valueOf(sizeOfSector);
        this.sectorList = new LinkedList<HardDiskSector>();
        for (long sector = 1 ; sector <= sectors ; sector++)
        {
            String Id = String.valueOf(id) + String.valueOf(sector);
            sectorList.add(new HardDiskSector(Long.valueOf(Id),Integer.parseInt(l)));
        }
    }
    public boolean isFull() {
        return full;
    }
    public long getId() {
        return id;
    }
    public List<HardDiskSector> getSectorList() {
        return sectorList;
    }
    public HardDiskSector createSector() {
        long count = 0;
        for (HardDiskSector hardDiskSector : sectorList) {
            count++;
            full = count != sectors ? false : true;

            if (hardDiskSector.getDado()[0] == -1) {
                return hardDiskSector;
            }
        }
        return null;
    }
}
