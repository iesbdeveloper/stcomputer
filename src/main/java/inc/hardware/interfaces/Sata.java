package inc.hardware.interfaces;

import inc.hardware.so.FileSystem.ListaLigada;

public interface Sata 
{
    ListaLigada<Long> write(Byte[] dado);
    
    Byte[] read(ListaLigada<Long> posicoes);

}
