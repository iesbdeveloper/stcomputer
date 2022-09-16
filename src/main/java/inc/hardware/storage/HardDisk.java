package inc.hardware.storage;
import java.util.*;

public class HardDisk {
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
                if (sector != null)
                    return sector;
            }
        }
        return null;
    }
    private long write()
    {
        return  -1;
    }



}
