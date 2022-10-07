package inc.hardware.interfaces;

import inc.hardware.so.FileSystem.No;

public interface Sata
{
    //Retorna um seguencia de No contendo o Id de cada setor q o arquivo q foi enviado como um arrey de bytes
    No<Long> write(byte[] dado);

    //Retorna um Arrey de bytes contendo o conteudo da seguencia de No q foi enviado como parametro
    byte[] read(No<Long> dado);

    //Retorna o espaço total em um long com o valor referente diretamente em bytes caso necessário realizar conversão dividindo por 1000 Bytes>Kb>Mb
    long espacoTotal();

    //Retorna o espaço livre total em um long com o valor referente diretamente em bytes caso necessário realizar conversão dividindo por 1000 Bytes>Kb>Mb
    long espacoLivre();

}
