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
                registerBank.v[x] = (byte)(registerBank.v[x] | registerBank.v[y]);
                break;
            case 0x2:
                 registerBank.v[x] = (byte)(registerBank.v[x] & registerBank.v[y]);
                break;
            case 0x3:
                registerBank.v[x] = (byte)(registerBank.v[x] ^ registerBank.v[y]);
                break;
            case 0x4:
                byte sumByte = (byte) (registerBank.v[x] + registerBank.v[y]);

                if(sumByte > 255){
                    registerBank.v[0xF] = 0x1;
                } else {
                    registerBank.v[0xF] = 0x0;
                }

                registerBank.v[x] = sumByte;
            case 0x5:
                byte subByte = (byte) (registerBank.v[x] + registerBank.v[y]);

                if(registerBank.v[x] > registerBank.v[y]){
                    registerBank.v[0xF] = 0x1;
                } else {
                    registerBank.v[0xF] = 0x0;
                }

                registerBank.v[x] = subByte;
            case 0x6:
                byte mostInsign = (byte) (registerBank.v[x] & 0x01);

                if(mostInsign == 0x1){
                    registerBank.v[0xF] = 0x1;
                } else {
                    registerBank.v[0xF] = 0x0;
                }

                registerBank.v[x] = (byte) (registerBank.v[x] / 2);
            case 0x7:
            case 0xE:
            default:
                throw new RuntimeException("Instrução inválida.");
        }
    }
}
