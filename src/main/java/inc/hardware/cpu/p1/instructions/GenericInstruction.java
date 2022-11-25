package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.CpuStack;
import inc.hardware.cpu.p1.RegisterBank;

/**
 * Classe que implementa as operações de instrução, e lista
 * e executa todas as que  não fazem parte de um grupo de
 * operações especifico.
 */

public class GenericInstruction implements InstructionOperations{

    /* instancia a classe RegisterBank */
    private final RegisterBank registerBank;

    /* instancia a classe CpuStack */
    private final CpuStack stack;

    /* inicializa a classe GenericInstruction */
    public GenericInstruction(RegisterBank registerBank,
                              CpuStack stack) {
        this.registerBank = registerBank;
        this.stack = stack;
    }

    /**
     * categoriza e executa as operações que não fazem parte
     * de um grupo de operações especifico.
     */
    @Override
    public void operations(int opcode){
        short nnn = (short) (opcode & 0xFFF);
        byte x = (byte) ((opcode & 0x0F00) >> 8);
        byte y = (byte) ((opcode & 0x00F0) >> 4);
        byte kk = (byte) (opcode & 0x0FF);
        
        switch (opcode & 0xF000  >> 12){
            case 0x1:
                registerBank.pc = nnn;
                break;
            case 0x2:
                ++registerBank.sp;
                stack.pushAddress(registerBank.pc);
                registerBank.pc = nnn;
                break;
            case 0x3:
                if(registerBank.v[x] == kk){
                    registerBank.pc += (short) 0x0002;
                }
                break;
            case 0x4:
                if(registerBank.v[x] != kk){
                    registerBank.pc += (short) 0x0002;
                }
                break;
            case 0x5:
                if(registerBank.v[x]==registerBank.v[y]){
                    registerBank.pc = (short)(registerBank.pc + 0x0002);
                }
                break;
            case 0x6:
                registerBank.v[x] = kk;
                break;
            case 0x7:
                registerBank.v[x] = (byte) (registerBank.v[x] + kk);
                break;
            case 0x9:
                if(registerBank.v[x] != registerBank.v[y]){
                    registerBank.pc = (short)(registerBank.pc + 0x0002);
                }
                break;
            case 0xA:
                registerBank.i = nnn;
                break;
            case 0xB:
                registerBank.pc = (short) ( registerBank.v[0] & 0xff + nnn & 0xfff);
                break;
            case 0xC:
                byte random = (byte) secureRandom.nextInt(255);
                registerBank.v[x] = (byte)(random & kk);
                break;
            case 0xD:
                break;
            default:
                throw new RuntimeException("Instrução Inválida!");
        }
    }
}
