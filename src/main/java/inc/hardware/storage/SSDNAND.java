package inc.hardware.storage;

import java.util.LinkedList;
import java.util.List;

public class SSDNAND {
    private final long id;
    private final List<SSDSectors> sectorList ;
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
            sectorList.add(new SSDSectors(Long.valueOf(Id),Integer.parseInt(l)));
        }
    }
}
