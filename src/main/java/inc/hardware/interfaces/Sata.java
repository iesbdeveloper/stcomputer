package inc.hardware.interfaces;

import inc.hardware.so.FileSystem.ListaLigada;
import inc.hardware.so.FileSystem.No;

public interface Sata 
{
    No<Long> write(byte[] dado);
    
    byte[] read(No<Long> dado);

    byte[] tamanho();

    long espacoLivre();
}
