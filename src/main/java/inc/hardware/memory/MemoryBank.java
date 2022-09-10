package inc.hardware.memory;

public interface MemoryBank {

    //String getBankDescription();

    long getSize();

    int getStartAddress();

    /*
    * startAddress: endereço inicial
    * readBuf: local para a leitura de dados
    * offset: ajuda o readBuf a receber os dados
    * len: tamanho em bytes para ler
    * */
    void read(int startAddress, byte[] readBuf, int offset, int len);

    /*
    * startAddress: endereço inicial
    * writeBuf: local para escrita dos dados
    * offset: ajuda o readBuf a receber obter os dados
    * len: tamanho em bytes para escrever
     * */
    void write (int startAddress, byte[] writeBuf, int offset, int len);
}
