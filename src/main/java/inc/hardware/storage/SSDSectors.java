package inc.hardware.storage;

public class SSDSectors {
    private final long iD;
    private byte dado[];
    private final int size;

    public SSDSectors(long iD, int size) {
        this.iD = iD;
        this.size = size;
        this.dado = new byte[size];
        for (int i = 0; i < size; i++) {
            this.dado[i] = -1;
        }

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
