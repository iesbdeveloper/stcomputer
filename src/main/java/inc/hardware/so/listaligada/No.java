package inc.hardware.so.listaligada;

public class No<T> {
    private T elemento;
    private No<T> proximo;

    public No() {
        this.proximo = null;
    }

    public No(T elemento) {
        this.elemento = elemento;
    }

    public No(T elemento, No<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return this.elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}
