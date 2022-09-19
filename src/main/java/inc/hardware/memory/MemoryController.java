package inc.hardware.memory;

public class MemoryController<T> {
    private byte[] armazenamento = new byte[4096];

    // Lê uma palavra
    private T read;

    // Armazena em uma posição específica
    private T store;

    private T write;

    public void leitura(T read) {
    }

    public void gravacao(T store) {
    }
}
