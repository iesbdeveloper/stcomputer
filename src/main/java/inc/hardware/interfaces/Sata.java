package inc.hardware.interfaces;

import inc.hardware.so.FileSystem.ListaLigada;

public interface Sata 
{
    public ListaLigada<long> write();
    
    public void read(int bytes);
    
    
}
