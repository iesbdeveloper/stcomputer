package inc.hardware.storage;

public class HardDiskHead {
    private final long id;
    private final HardDiskTrack[] tracks;

    public HardDiskHead(long id, int tracks, int sectors, int sectorSize) {
        this.id = id;
        this.tracks = new HardDiskTrack[tracks];
    }

    public long getId() {
        return id;
    }

    public HardDiskTrack[] getTracks() {
        return tracks;
    }
}
