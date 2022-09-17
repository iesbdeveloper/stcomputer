package inc.hardware.storage;

public class HardDiskSector {
    private final long iD;
    private Byte dado[];
    public HardDiskSector(long iD, int size) {
        this.iD = iD;
        this.dado = new Byte[size];
    }
    public long getiD() {
        return iD;
    }

    public Byte[] getDado() {
        return dado;
    }

    public void setDado(Byte[] dado) {
        this.dado = dado;
    }




}
