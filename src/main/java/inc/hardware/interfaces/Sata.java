package inc.hardware.interfaces;

import inc.hardware.so.FileSystem.ListaLigada;
import inc.hardware.so.FileSystem.No;

public interface Sata 
{
//    Esse método recebe por parametro um arrey de bytes contendotodo o arquivo a ser gravado e retorna o primeiro nó da lista ligada
    No<Long> write(byte[] dado);

//    Esse método recebe por parametro o primeiro nó da lista ligada retornada no método anterior e retorna um arrey de bytes completo contendo todo o arquivo
    byte[] read(No<Long> dado);

//    Esse método retorna um long contendo o espaço total do hd em unidade de medida bytes, quem for usar e desejar outra medida devida por 1000 para ir para kb e por mais 1000 pra mb
    long espacoTotal();

//    Esse método retorna um long contendo o espaço livre no hd em unidade de medida bytes, quem for usar e deseja em outra unidade de medida basta dividir por 1000 até a desejada
    long espacoLivre();
}
