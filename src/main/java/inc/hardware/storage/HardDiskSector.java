package inc.hardware.storage;

public class HardDiskSector {
    final private long id;
    private byte[] data;

    public HardDiskSector(long id, int size) {
        this.id = id;
        this.data = new byte[size];
    }

    public long getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
