package inc.hardware.storage;
import java.util.*;
public class HardDiskHead{
    private final long iD;
    private final List<HardDiskTrack> diskTrackList;

    public HardDiskHead(long id, long tracks, long sectors, int sectorSize) {
        this.iD = id;
        this.diskTrackList = new LinkedList<HardDiskTrack>();
        for (long track = 1 ; track <= tracks; track++)
        {
            String Id = String.valueOf(id) + String.valueOf(track);
            this.diskTrackList.add(new HardDiskTrack(Long.valueOf(Id) ,sectors,sectorSize));
        }
    }
    public long getiD() {
        return iD;
    }
    public List<HardDiskTrack> getDiskTrackList() {
        return diskTrackList;
    }
}
