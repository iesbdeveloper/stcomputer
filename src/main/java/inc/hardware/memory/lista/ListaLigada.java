package inc.hardware.memory.lista;


public class ListaLigada<T> {

    private No<T> inicio;
    private No<T> fim;
    private Integer tamanho = 0;


    public int tamanho() {
        return tamanho;
    }
    public void inserir(T valor) {
        No<T> novoNo = new No<T>(valor);
        novoNo.setValor(valor);

        if(this.inicio == null && this.fim == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        }
        else {
            this.fim.setProximo(novoNo);
            this.fim = novoNo;
        }
        this.tamanho++;
    }

    public void deletar(T valor) {
        No<T> aux = null;
        No<T> anterior = null;
        aux = inicio;
        System.out.println("/n " + tamanho);
        while(aux != null) {
            if(aux.getValor() == valor) {
                if(anterior == null) {
                    inicio = aux.getProximo();
                }
                else {
                    anterior.setProximo(aux.getProximo());
                }
            }
            this.tamanho--;
        }
        anterior = aux;
        aux = aux.getProximo();
        System.out.println(tamanho);

    }

    // Mostrando a lista
    @Override
    public String toString() {
        if(this.inicio == null && this.fim == null) {
            return "Lista vazia";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            No<T> aux = inicio;
            while (aux != null) {
                sb.append(aux.getValor() + " ");
                aux = aux.getProximo();
            }

            sb.append("]");
            return sb.toString();
        }
    }
}
