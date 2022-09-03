package inc.hardware.storage;

public class HardDiskSector {
    private final long iD;
    private byte[] dado;
    public HardDiskSector(long iD, byte[] dado) {
        this.iD = iD;
        this.dado = dado;
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
