package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.RegisterBank;

public class EightInstruction {

    // Criar uma interface para ControlUnit para resolver dependencia forte

    private int instruction;
    private RegisterBank registradores;
    byte x = (byte) ((instruction & 0x0F00) >> 8);
    byte y = (byte) ((instruction & 0x00F0) >> 4);

    public void EigthOperations(int instruct){
        instruction = instruct;

        switch (instruct & 0x000F){
            case 0x0:
                registradores.V[x] = registradores.V[y];
                registradores.PC += 2;
                break;
            default:
        }
    }
}
