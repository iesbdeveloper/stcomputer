package inc.hardware.cpu.p1;

import inc.hardware.cpu.p1.instructions.*;
import inc.hardware.memory.Memory1S;

public class ControlUnit implements LGA{

    /* instancia a classe RegisterBank */
    private RegisterBank registerBank;

    /* instancia a classe ZeroInstruction */
    private ZeroInstruction zeroInstruction;

    /* instancia a classe EightInstruction */
    private EightInstruction eightInstruction;

    /* instancia a classe EInstruction */
    private EInstruction eInstruction;

    /* instancia a classe FInstruction */
    private FInstruction fInstruction;

    /* instancia a classe GenericInstruction */
    private GenericInstruction genericInstruction;

    /* instancia a classe MemoryController */
    private Memory1S memory;

    /* variável que indica a instrução resgatada da memória */
    private short instructionFromMemory;

    /* pega os dados do endereço de memoria */
    public void fetch(){
        short pc = registerBank.pc;
        instructionFromMemory = (short) (memory.get(pc) << 8  | (memory.get((short) (pc+1))) & 0x00FF);
    }

    /* decodifica e executa as funções */
    public void decodeExecute(){

        switch((instructionFromMemory & 0xF000) >> 12){
            case 0x0:
                zeroInstruction.operations(instructionFromMemory);
                break;
            case 0x8:
                eightInstruction.operations(instructionFromMemory);
                break;
            case 0xE:
                eInstruction.operations(instructionFromMemory);
                break;
            case 0xF:
                fInstruction.operations(instructionFromMemory);
                break;
            default:
                genericInstruction.operations(instructionFromMemory);
        }
    }
}
