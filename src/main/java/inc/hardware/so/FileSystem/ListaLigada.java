package inc.hardware.so.FileSystem;

import inc.hardware.so.listaligada.model.Processo;
import inc.hardware.so.listaligada.model.Sistema;
import inc.hardware.so.listaligada.repository.impl.ProcessoImpl;

public class ListaLigada<T> extends ProcessoImpl {
    private No<T> primeirono;
    private No<T> ultimono;
    private int tamanho=0; //tamanho da lista

    public ListaLigada(){
        this.primeirono = primeirono;
        this.ultimono = ultimono;
        this.tamanho = tamanho;

    }
    public boolean eVazia(){
        return this.tamanho ==0;
    }

    public void inserir (T elemento){
        No<T> novono = new No<>(elemento);

        if(eVazia()){
            this.primeirono = novono;
            this.ultimono   = novono;
        }else{
            this.ultimono.setProximo(novono);
            this.ultimono = novono;

        }
        this.tamanho++;

    }


    public void apagarprocesso( T elemento, int id_deletado) {
        ListaLigada <Processo> listasprocesso = new ListaLigada<Processo>();
        No<Processo> aux = (No<Processo>) new No<T>(elemento);
        aux = (No<Processo>) primeirono;


        No<T> anterior = null;


        while (aux.getElemento()!= null){

            if(aux.getElemento().getId_processo() == id_deletado)
            {
                if (anterior == null){
                    this.primeirono  = (No<T>) aux.getProximo();
                    System.out.println("dentro.o.1...");
                    tamanho--;
                    break;
                } else if (aux.getElemento()==(Processo) ultimono.getElemento()) {
                    anterior.setProximo(null);
                    ultimono = anterior;

                    //ultimono.setProximo(anterior.getProximo());
                    tamanho--;
                    aux.setElemento(null);
                    break;
                }else{
                    System.out.println("dentro.3...");
                    anterior.setProximo((No<T>)aux.getProximo());
                    tamanho--;
                    aux.setElemento(null);
                    break;
                }
            }
            anterior = (No<T>) aux;
            aux =aux.getProximo();
        }
        System.out.println("\n"+tamanho);
    }

    public void apagararquivo( T elemento, String nome_deletado) {
        ListaLigada <Sistema> listassistema = new ListaLigada<Sistema>();
        No<Sistema> aux = (No<Sistema>) new No<T>(elemento);

        No<T> anterior = null;

        while (aux.getElemento()!= null){

            if(aux.getElemento().getName() == nome_deletado)
            {
                if (anterior == null){
                    primeirono = (No<T>) aux.getProximo();
                    tamanho--;
                    break;
                } else if (aux.getElemento()==(Sistema) ultimono.getElemento()) {
                    anterior.setProximo(null);
                    ultimono = anterior;
                    //ultimono.setProximo(anterior.getProximo());
                    tamanho--;
                    aux.setElemento(null);
                    break;
                }else{
                    System.out.println("dentro.3...");
                    anterior.setProximo((No<T>)aux.getProximo());
                    tamanho--;
                    aux.setElemento(null);
                    break;
                }
            }
            anterior = (No<T>) aux;
            aux =aux.getProximo();
        }
    }

    public T buscararquivo (T elemento, String nome_buscado){
        No<Sistema>  aux = (No<Sistema>)new No<>(elemento);
        aux = (No<Sistema>)primeirono;
        while(aux.getElemento()!= null){
            if (aux.getElemento().getName() == nome_buscado){
                return (T) aux;
            }

        }
        return null;
    }

    public No<T> recuperarNo(int posicao) {
        if(posicao>= tamanho()) {
            throw new IllegalArgumentException(String.format(" a posição %d é invalida.\n",posicao));
        }
        No<T> resultado=null;
        int i;
        for(i=0;i<=posicao;i++){
            if(i==0) {
                resultado = primeirono;
            }else {
                resultado = resultado.getProximo();
            }
        }

        return resultado;
    }

    public void removeNoPorPosicao( int posicao){
        if (posicao ==0){
            No<T> novoInicio = this.primeirono.getProximo();
            primeirono = novoInicio;
        }else if(posicao==tamanho()-1){

            No<T> anterior = recuperarNo(tamanho()-2);
            this.ultimono= anterior;
            ultimono.setProximo(null);
        }else{
            No<T> anterior = recuperarNo(posicao-1);
            No<T> atual = recuperarNo(posicao);
            No<T>posterior = recuperarNo(posicao+1);
            anterior.setProximo(posterior);
            atual = null;
        }
        this.tamanho--;

    }

    public void removerNoPorElemento(T elemento){
        int i ;
        System.out.println("entrou 1");
        for(i=0; i< tamanho() ; i++){
            No<T> noRemovido = recuperarNo(i);
            System.out.println(i  +"   "+noRemovido.getElemento());
            System.out.println(elemento);
            if (elemento == noRemovido.getElemento()){
                System.out.println("entrou 2");
                if (i ==0){
                    System.out.println("entrou 3");
                    No<T> novoInicio = this.primeirono.getProximo();
                    primeirono = novoInicio;
                }else if(i==tamanho()-1){
                    System.out.println("entrou 4");
                    No<T> anterior = recuperarNo(tamanho()-2);
                    this.ultimono= anterior;
                    ultimono.setProximo(null);
                }else{
                    System.out.println("entrou 5");
                    No<T> anterior = recuperarNo(i-1);
                    No<T> atual = recuperarNo(i);
                    No<T>posterior = recuperarNo(i+1);
                    anterior.setProximo(posterior);
                    atual = null;
                }


            }
        }
        this.tamanho--;
    }


    public T retornarElemento (No<T> no){

        for(int i =0; i<tamanho();i++){
            No<T> recuperado = recuperarNo(i);
            if (no == recuperado){
                return recuperado.getElemento();
            }
        }
        return null;
    }

    private int tamanho() {
        return this.tamanho;
    }


    @Override
    public String toString() {
        if(eVazia()) {
            return "Lista Vazia";
        }else {
            No<T> noatual = this.primeirono;
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("File System \n");
            //stringbuilder.append("pos\t arquivo\t\tsize\tmemoria\n");
            stringbuilder.append(noatual.getElemento()!= null ? noatual.getElemento().toString(): "<nulo>");
            // stringbuilder.append("  ");

            while(noatual.getProximo()!=null) {
                stringbuilder.append(noatual.getProximo().getElemento()!= null ? noatual.getProximo().getElemento().toString(): "<nulo>");
                //stringbuilder.append(" ");
                noatual =noatual.getProximo();
            }
            stringbuilder.append("End.");
            return stringbuilder.toString();
        }

    }
}
