package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.CpuStack;
import inc.hardware.cpu.p1.RegisterBank;
import inc.hardware.video.OnboardVideo;

/**
 * Classe que implementa as operações de instrução, e lista
 * e executa todas as que começam com o numero 0x0.
 */

public class ZeroInstruction implements InstructionOperations {

    /* instancia a classe RegisterBank */
    private RegisterBank registerBank;

    /* instancia a classe CpuStack */
    private CpuStack stack;
    private OnboardVideo onboardVideo;

    /* inicializa a classe ZeroInstruction */
    public ZeroInstruction(RegisterBank registerBank,
                           CpuStack stack) {
        this.registerBank = registerBank;
        this.stack = stack;
    }

    /* categoriza e executa as operações que comecam com 0x0 */
    @Override 
    public void operations(int opcode) {
        switch (opcode & 0x00FF){
            case 0xEE:
                registerBank.pc = stack.topAddress();
                --registerBank.sp;
                stack.popAddress();
                break;
            case 0xE0:
                // onboardVideo.clearScreen();
                break;
            default:
                throw new RuntimeException("Instrução inválida.");
        }
    }
}
