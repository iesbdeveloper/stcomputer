package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.RegisterBank;

public class FInstruction {

    private int instruction;

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    private RegisterBank registerBank;

    byte x = (byte) ((instruction & 0x0F00) >> 8);

    public void FOperations(int instruct){
        setInstruction(instruct);

        switch (instruct & 0x00FF){
            case 0x0007:
                registerBank.V[x]= registerBank.atraso;
                break;
            case 0x000A:
                break;
            case 0x0015:
                registerBank.atraso = registerBank.V[x];
                break;
            case 0x0018:
                registerBank.som = registerBank.V[x];
                break;
            default:
        }
    }
}
