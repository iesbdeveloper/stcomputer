package inc.hardware.so.FileSystem;


import inc.hardware.so.listaligada.model.Processo;
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

    public No<T> getPrimeirono()
    {
        return this.primeirono;
    }

    public int getTamanho()
    {
        return this.tamanho;
    }




    public void inserir (T elemento){
        No<T> novono = new No<T>(elemento);

        if(eVazia()){
            this.primeirono = novono;
            this.ultimono   = novono;
        }else{
            this.ultimono.setProximo(novono);
            this.ultimono = novono;

        }
        this.tamanho++;

    }


    public void apagararquivo( T elemento, int id_deletado) {
        ListaLigada <Processo> listasprocesso = new ListaLigada<Processo>();
        No<Processo> aux = (No<Processo>) new No<T>(elemento);
        aux = (No<Processo>) primeirono;


        No<T> anterior = null;
        System.out.println("\n"+tamanho);

        while (aux.getElemento()!= null){

            if(aux.getElemento().getId_processo() == id_deletado)
            {
                if (anterior == null){
                    primeirono = (No<T>) aux.getProximo();
                    tamanho--;
                    break;
                } else if (aux.getElemento()==(Processo) ultimono.getElemento()) {
                    anterior.setProximo(null);
                    ultimono = anterior;

                    tamanho--;
                    aux.setElemento(null);
                    break;
                }else{
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
