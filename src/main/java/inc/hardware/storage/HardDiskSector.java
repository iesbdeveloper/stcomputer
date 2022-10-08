package inc.hardware.storage;

public class HardDiskSector {
    private final long iD;
    private byte dado[];
    private final int size;

    public HardDiskSector(long iD, int size) {
        this.iD = iD;
        this.size = size;
        this.dado = null;
    }

    public long getiD() {
        return iD;
    }
    public byte[] getDado() {
        return this.dado;
    }
    public void setDado(byte[] dado) {
        this.dado = new byte[this.size];
        this.dado = dado;
    }




}
