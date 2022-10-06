package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.RegisterBank;

/**
 * Classe que implementa as operações de instrução, e lista
 * e executa todas as que começam com o numero 0xF.
 */

public class FInstruction implements InstructionOperations {

    /* instancia a classe RegisterBank */
    private final RegisterBank registerBank;

    /* inicializa a classe FInstruction */
    public FInstruction(RegisterBank registerBank) {
        this.registerBank = registerBank;
    }

    /* categoriza e executa as operações que comecam com 0xF */
    @Override
    public void operations(int opcode){

        byte x = (byte) ((opcode & 0x0F00) >> 8);

        switch (opcode & 0x00FF){
            case 0x0007:
                registerBank.v[x]= registerBank.atraso;
                break;
            case 0x000A:
                break;
            case 0x0015:
                registerBank.atraso = registerBank.v[x];
                break;
            case 0x0018:
                registerBank.som = registerBank.v[x];
                break;
            default:
        }
    }
}
