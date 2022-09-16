package inc.hardware.storage;
import java.util.*;
public class HardDiskHead {


    private final long iD;

    public long getiD() {
        return iD;
    }

    public List<HardDiskTrack> getDiskTrackList() {
        return diskTrackList;
    }

    private final List<HardDiskTrack> diskTrackList;
    public HardDiskHead(long id, long tracks, long sectors, long sectorSize) {
        this.iD = id;
        this.diskTrackList = new LinkedList<HardDiskTrack>();
        for (long track = 1 ; track < tracks; track++)
        {
            this.diskTrackList.add(new HardDiskTrack(track,sectors,sectorSize));
        }
    }
}
