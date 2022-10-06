package inc.hardware.cpu.p1;

import java.util.Stack;

/**
 * Classe que inicializa e descreve os métodos pertencentes
 * à pilha utilizada na CPU.
 */
public class CpuStack {

    /* inicializa a pilha da cpu */
    public Stack<Short> cpuStack = new Stack<>();

    /* adiciona o valor ao topo da pilha */
    public void pushAddress(short pc){
        this.cpuStack.push(pc);
    }

    /* remove o valor no topo da pilha */
    public void popAddress(){
        if(!this.cpuStack.empty()) {
            this.cpuStack.pop();
        } else {
            throw new RuntimeException("Pilha vazia!");
        }
    }

    /* retorna o valor no topo da pilha */
    public short topAddress(){
        if(!this.cpuStack.empty()) {
            return this.cpuStack.peek();
        } else {
            throw new RuntimeException("Pilha vazia!");
        }
    }
}
