package inc.hardware.storage;
import java.util.*;
import storage.*;
public class HardDisk {
    private final List<HardDiskHead> diskHeadList
    public HardDisk(long track, long heads, long sector, long sectorSize) {
        this.diskHeadList= new LinkedList<HardDiskHead>();
        for (long head = 0; head < heads; head++ )
        {

        }
    }
    protected HardDiskSector getEmptySector()
    {
        for (HardDiskHead disc : diskHeadList ) {
            for (HardDiskTrack diskTrack : disc.getDiskTrackList()) {
                HardDiskSector sector = diskTrack.createSector();
                if (sector != null)
                    return sector
            }
        }
        return null;
    }
    private long write()
    {
        return  -1;
    }



}
