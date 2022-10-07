package inc.hardware.memory;

import inc.hardware.interfaces.Memory;
import inc.hardware.memory.lista.ListaLigada;


/**
 * 4096 Bytes of memory
 */
public class Memory1S{

    ListaLigada<byte[]> arqs = new ListaLigada<>();

    long id;

}
