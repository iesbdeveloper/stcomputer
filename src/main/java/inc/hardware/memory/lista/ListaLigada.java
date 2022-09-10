package inc.hardware.memory.lista;

import memoria.Memory1s;
import memoria.MemoryBank;

public class ListaLigada<M>  extends MemoryBank {
    private No<T> primeiroNo;
    private No<T> ultimoNO;
    private int tamanho = 0;

    public ListaLigada() {
        this.primeiroNo = primeiroNO;
        this.ultimoNO = ultimoNO;
        this.tamanho = tamanho;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public void insert(T elemento) {
        No<T> novoNo = new No<T>(elemento);

        if(isEmpty()) {
            this.primeiroNo = novoNo;
            this.ultimoNO = novoNo;
        }
        else {
            this.ultimoNO.setProximo(novoNo);
            this.ultimoNO = novoNo;
        }
        this.tamanho++;
    }

    public void delete(T elemento, int id_deletado) {
        ListaLigada<Memory1s> listMemory = new ListaLigada<Memory1s>();
        No<T> aux = (No<Memory1s>) new No<T>(elemento);
        aux =  primeiroNo;

        No<T> anterior = null;
        System.out.println("\n" + tamanho);

        while(aux.getProximo() != null) {
            if(aux.getElemento() == id_deletado) {
                if(anterior == null) {
                    primeiroNo = (No<T>) aux.getProximo();
                }
            }
        }
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public int getStartAddress() {
        return 0;
    }

    @Override
    public void read(int startAddress, byte[] readBuf, int offset, int len) {

    }

    @Override
    public void write(int startAddress, byte[] writeBuf, int offset, int len) {

    }
}
