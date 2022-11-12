package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.RegisterBank;

/**
 * Classe que implementa as operações de instrução, e lista
 * e executa todas as que começam com o numero 0x8.
 */

public class EightInstruction implements InstructionOperations {

    /* instancia a classe RegisterBank */
    private final RegisterBank registerBank;

    /* inicializa a classe EightInstruction */
    public EightInstruction(RegisterBank registerBank) {
        this.registerBank = registerBank;
    }

    /* categoriza e executa as operações que comecam com 0x8 */
    @Override
    public void operations(int opcode){
        byte x = (byte) ((opcode & 0x0F00) >> 8);
        byte y = (byte) ((opcode & 0x00F0) >> 4);

        switch (opcode & 0x000F){
            case 0x0:
                registerBank.v[x] = registerBank.v[y];
                registerBank.pc += 2;
                break;
            case 0x1:
            case 0x2:
            case 0x3:
            case 0x4:
            case 0x5:
            case 0x6:
            case 0x7:
            case 0xE:
            default:
                throw new RuntimeException("Instrução inválida.");
        }
    }
}
