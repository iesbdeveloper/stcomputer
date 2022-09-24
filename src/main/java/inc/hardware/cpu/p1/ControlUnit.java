package inc.hardware.cpu.p1;

import inc.hardware.cpu.p1.instructions.EightInstruction;
import inc.hardware.cpu.p1.instructions.GenericInstruction;
import inc.hardware.memory.MemoryController;

public class ControlUnit {

    private RegisterBank registradores;
    private EightInstruction eightInstruction;
    private GenericInstruction genericInstruction;
    private MemoryController memory;
    private short instructionFromMemory;

    public ControlUnit(RegisterBank registradores) {
        this.registradores = registradores;
    }

    // Fetch
    public void fetch(){
        short PC = registradores.PC;
        instructionFromMemory = (memory.getB(PC) << 8  | (memory.getB(PC+1)) & 0X00FF);
    }

    // Decode

    public void decodeExecute(){

        switch((instructionFromMemory & 0xF000) >> 12){
            case 0x0:

                break;
            case 0x1:
            case 0x2:
            case 0x3:
            case 0x4:
            case 0x5:
            case 0x6:
            case 0x7:
            case 0x9:
            case 0xA:
            case 0xB:
            case 0xC:
                genericInstruction.GenericOperations(instructionFromMemory);
                break;
            case 0x8:
                eightInstruction.EigthOperations(instructionFromMemory);
                break;
        }

    }

    // Funções para instruções

}
