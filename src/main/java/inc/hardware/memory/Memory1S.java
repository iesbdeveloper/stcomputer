package inc.hardware.memory;

import inc.hardware.interfaces.Memory;

/**
 * 4096 Bytes of memory
 */
public class Memory1S<T> extends MemoryController implements Memory<T> {

    private byte[] armazenamento = new byte[4096];

    // Lê uma palavra
    private T read;

    // Armazena em uma posição específica
    private T store;

    private T write;

    private T load;

    protected T address;
    protected T size;

    public Memory1S() {
    }

    public Memory1S(byte[] armazenamento, T read, T write, T load, T store) {
        this.armazenamento = armazenamento;
        this.read = read;
        this.store = store;
        this.load = load;
        this.write = write;
    }

    public byte[] getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(byte[] armazenamento) {
        this.armazenamento = armazenamento;
    }

    public T getRead() {
        return read;
    }

    public void setRead(T read) {
        this.read = read;
    }

    public T getStore() {
        return store;
    }

    public void setStore(T store) {
        this.store = store;
    }

    public T getWrite() {
        return write;
    }

    public void setWrite(T write) {
        this.write = write;
    }

    public T getLoad() {
        return load;
    }

    public void setLoad(T load) {
        this.load = load;
    }

    @Override
    public T getSize() {
        return size;
    }

    @Override
    public T getAddress() {
        return address;
    }

    @Override
    public void read(T address, byte[] readBuf, int offset, int len) {

    }

    @Override
    public void write(T address, byte[] writeBuf, int offset, int len) {

    }
}
