package inc.hardware.interfaces;

import inc.hardware.memory.lista.ListaLigada;

public interface Memory{

    long write(byte[] dados);

    byte[] read (Long addr);

    long size();

}