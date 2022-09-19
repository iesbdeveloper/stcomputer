package inc.hardware.interfaces;

public interface Memory<T> {

    // Pega o tamanho
    T getSize();

    // Pega o endereço
    T getAddress();

    /*
     * startAddress: endereço inicial
     * readBuf: local para a leitura de dados
     * offset: ajuda o readBuf a receber os dados
     * len: tamanho em bytes para ler
     * */
    void read(T address, byte[] readBuf, int offset, int len);

    /*
     * startAddress: endereço inicial
     * writeBuf: local para escrita dos dados
     * offset: ajuda o readBuf a receber obter os dados
     * len: tamanho em bytes para escrever
     * */
    void write (T address, byte[] writeBuf, int offset, int len);
}
