package inc.hardware.storage;

public class HardDisk {
    private final HardDiskHead[] heads;

    public HardDisk(int heads, int tracks, int sectors, int sectorSize) {
        this.heads = new HardDiskHead[heads];
    }

    protected HardDiskSector getEmptySector() {
        return null;
    }

    /**
     * Write a byte array into disk.
     * @return Sector Number
     */
    public long write(byte[] data) {
        return -1;
    }
}
