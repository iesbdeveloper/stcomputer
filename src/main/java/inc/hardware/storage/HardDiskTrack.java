package inc.hardware.storage;

public class HardDiskTrack {
    private final long id;
    private final long head;
    private final int sectorSize;
    private final HardDiskSector[] sectors;

    public HardDiskTrack(long head, long id, int sectors, int sectorSize) {
        this.head = head;
        this.id = id;
        this.sectors = new HardDiskSector[sectors];
        this.sectorSize = sectorSize;
    }

    public long getId() {
        return id;
    }

    public HardDiskSector[] getSectors() {
        return sectors;
    }

    public HardDiskSector createSector() {
        return null;
    }
}
