package inc.hardware.storage;
import java.util.*;
import storage.*;
public class HardDiskHead {
    private final long iD;

    public long getiD() {
        return iD;
    }

    public List<HardDiskTrack> getDiskTrackList() {
        return diskTrackList;
    }

    private final List<HardDiskTrack> diskHeadTrack;
    public HardDiskHead(long iD) {
        this.iD = iD;
    }
}
