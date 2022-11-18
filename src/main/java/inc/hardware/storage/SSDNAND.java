package inc.hardware.storage;

import java.util.LinkedList;
import java.util.List;

public class SSDNAND {
    private final long id;
    private final List<SSDSector> sectorList ;
    private boolean full;
    private final long sectors;

    public SSDNAND(long id, long sectors, int sizeOfSector) {
        this.id = id;
        this.sectors = sectors;
        String l = String.valueOf(sizeOfSector);
        this.sectorList = new LinkedList<>();
        for (long sector = 1 ; sector <= sectors ; sector++)
        {
            String Id = String.valueOf(id) + String.valueOf(sector);
            sectorList.add(new SSDSector(Long.valueOf(Id),Integer.parseInt(l)));
        }
    }
    public long getId() {
        return id;
    }

    public List<SSDSector> getSectorList() {
        return sectorList;
    }

    public boolean isFull() {
        return full;
    }

    public long getSectors() {
        return sectors;
    }
    public SSDSector freeSector()
    {
        long count = 0;
        for (SSDSector s : sectorList) {
            count++;
            full = count != sectors ? false : true;

            if (s.getDado()[0] == -1) {
                return s;
            }
        }
        return null;
    }
}
