package inc.hardware.storage;

public class HardDiskSector {
    private final long iD;
    private byte dado[];

    public HardDiskSector(long iD, int size) {
        this.iD = iD;
        this.dado = new byte[size];
    }

    public long getiD() {
        return iD;
    }
    public byte[] getDado() {
        return dado;
    }
    public void setDado(byte[] dado) {
        this.dado = dado;
    }




}
