package inc.hardware.so.listaligada.model;

public class Processo {
    private long id_processo;
    private String usuario;

    public Processo(long id_processo, String usuario) {
        this.id_processo = id_processo;
        this.usuario = usuario;
    }

    public Processo(long id_processo) {
        this.id_processo = id_processo;
    }

    public long getId_processo() {
        return this.id_processo;
    }

    public void setId_processo(long id_processo) {
        this.id_processo = id_processo;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String toString() {
        return this.id_processo + "\t" + this.usuario + "\n";
    }
}
