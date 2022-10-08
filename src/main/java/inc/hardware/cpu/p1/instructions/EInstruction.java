package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.RegisterBank;
import inc.hardware.input.Keyboard;

/**
 * Classe que implementa as operações de instrução, e lista
 * e executa todas as que começam com o numero 0xE.
 */

public class EInstruction implements InstructionOperations {

    private final RegisterBank registerBank;
    private final Keyboard keyboard;

    public EInstruction(RegisterBank registerBank, Keyboard keyboard) {
        this.registerBank = registerBank;
        this.keyboard = keyboard;
    }

    /* categoriza e executa as operações que comecam com 0xE */
    @Override
    public void operations(int opcode) {

        byte x = (byte) ((opcode & 0x0F00) >> 8);
        byte key = (byte)(registerBank.v[x] & 0x0F);
        switch (opcode & 0x000F){
            case 0x0001:
               // if(!keyboard.keyPressed(key)){
                //    registerBank.pc = (short) (registerBank.pc + 0x0002);
                //}
                break;
            case 0x000E:
               // if(keyboard.){
                    //registerBank.pc = (short) (registerBank.pc + 0x0002);
               // }
                break;
            default:
        }
    }
}
