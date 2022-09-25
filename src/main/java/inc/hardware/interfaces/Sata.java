package inc.hardware.interfaces;

import inc.hardware.so.FileSystem.ListaLigada;
import inc.hardware.so.FileSystem.No;

public interface Sata 
{
    No<Long> write(byte[] dado);
    
    Byte[] read(ListaLigada<Long> posicoes);

}