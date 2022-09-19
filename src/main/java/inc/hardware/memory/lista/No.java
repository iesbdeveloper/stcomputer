package inc.hardware.memory.lista;

public class No<T> {
    private T valor;
    private No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public No(T valor, No<T> proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }


}
