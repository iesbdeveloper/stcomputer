package inc.hardware.so.listaligada.model;

public class Sistema {
    private String name;
    private String ext;
    private long size;
    private int posicao;
    Location loc = new Location(124L, (Location)null);

    public Sistema(int posicao, String name, String ext, long size, Location loc) {
        this.posicao = posicao;
        this.name = name;
        this.ext = ext;
        this.size = size;
        this.loc = loc;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = this.posicao;
    }

    public String toString() {
        return this.posicao + "\t" + this.name + "." + this.ext + "\t" + this.size + "\t" + this.loc + "\n";
    }
}
