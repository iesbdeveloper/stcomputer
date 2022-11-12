package inc.hardware.storage;

/**
 * 10 Megabytes = 10.618.880 bytes = 10.370 KB
 * 4800 RPM = 6.25 ms
 * heads = 4
 * Tracks = 305
 * Sectors per track = 17
 * Sector size = 512 bytes
 */
public class HardDisk10M extends HardDisk {
    public HardDisk10M() {
        super(35246515,305, 4, 17,512 );
        boot();
    }







}
