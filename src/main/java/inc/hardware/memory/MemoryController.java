package inc.hardware.memory;

import inc.hardware.interfaces.Memory;
import inc.hardware.memory.lista.ListaLigada;
import inc.hardware.memory.lista.No;

import java.nio.ByteBuffer;

public class MemoryController implements Memory {

    ListaLigada<Memory1S> Xpg1 = new ListaLigada<>();

    public boolean getSize(long size){

        if(Xpg1.getTamanho() > size ){

            return true;

        }
        else{

            return false;

        }
    }

    @Override
    public long write(byte[] dados) {

        if(getSize(dados.length)){

            Memory1S mems = new Memory1S();
            long addr;

            for(int i = 0; i < dados.length; i++){

                ByteBuffer split = ByteBuffer.wrap(dados);              //precisa refazer a logica de quebra a array pois está adiconando somente o primeiro indice.
                byte[] div = new byte[1];
                split.get(div,0,1);

                Xpg1.setTamanho(1);
                mems.arqs.inserir(div);

            }

            Xpg1.setRef(1);
            Xpg1.inserir(mems);
            addr = Xpg1.getInicio().getValor().id;                      // id pra identificar o arquivo

            return addr;                                                // retornando o id

        }
        else{

            return -1;

        }

    }

    @Override
    public byte[] read(Long addr) {

        Memory1S mems = new Memory1S();
        No<Memory1S> aux = Xpg1.getInicio();
        byte[] baux = new byte[0];
        byte[] baux2 = new byte[0];


        while(aux != null){

            if(aux.getValor().id == addr){              //comparando ids das listas com o recebido

                // se achar um arquivo com essa id tem que pegar os valores da lista, montar um array e retornar o array.

            }

        }

        return baux;
    }

    @Override
    public long size() {

        return Xpg1.getTamanho();

    }
}
