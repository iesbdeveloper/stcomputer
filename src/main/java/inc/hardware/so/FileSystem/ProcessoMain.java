package inc.hardware.so.FileSystem;

import inc.hardware.so.FileSystem.model.Processo;
import inc.hardware.so.FileSystem.model.Sistema;

public class ProcessoMain {
    public static void main(String[] args) {
        int posicao =0;

        ListaLigada <Processo> listasprocesso = new ListaLigada<Processo>();
        listasprocesso.inserir(new Processo(345,"root") );
        listasprocesso.inserir(new Processo(3678,"usuario1") );
        listasprocesso.inserir(new Processo(7548,"usuario3") );
        listasprocesso.inserir(new Processo(754998,"usuario4") );
        System.out.println("Lista dos adicionados");
        System.out.println(listasprocesso);
        // listasprocesso.removeNoPorPosicao(2);
        //System.out.println(listasprocesso);
        //listasprocesso.removeNoPorPosicao(1);

        listasprocesso.removerNoPorElemento(new Processo(3678,"usuario1") );
        System.out.println(listasprocesso);
        //listasprocesso.apagarprocesso(new Processo(345,"root"), 345);
        // System.out.println("Primeira Retirada");
        //  System.out.println(listasprocesso);
        //listasprocesso.apagarprocesso(new Processo(7548,"usuario3"), 7548);
        //System.out.println("Segunda Retirada");
        // System.out.println(listasprocesso);
        //listasprocesso.apagarprocesso(new Processo(3678,"usuario1"), 3678);


        System.out.println(listasprocesso);

        listasprocesso.inserir(new Processo(4566,"usuario4") );

        ListaLigada<Sistema> listasistema = new ListaLigada<>();
        listasistema.inserir(new Sistema("livro1","txt", 1234,null));
        posicao++;
        listasistema.inserir(new Sistema("corretor","exec", 6543,null));
        posicao++;
        listasistema.inserir(new Sistema("livro2","doc", 3456,null));
        posicao++;
        listasistema.inserir(new Sistema("escritor","exec", 9807,null));
        posicao++;
        listasistema.inserir(new Sistema("buscador","exec", 1567,null));
        posicao++;
        System.out.println(listasistema);
      //  listasistema.apagararquivo(new Sistema("livro1","txt",1234,null), "livro1");
        //listasistema.removeNoPorPosicao(2);
        //   System.out.println(listasistema);

    }

}
