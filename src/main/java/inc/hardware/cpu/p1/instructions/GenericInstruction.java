package inc.hardware.cpu.p1.instructions;

import inc.hardware.cpu.p1.ControlUnit;
import inc.hardware.cpu.p1.RegisterBank;

public class GenericInstruction {

    private int instruction;
    private RegisterBank registerBank;

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    short nnn = (short) (instruction & 0xFFF);
    byte x = (byte) ((instruction & 0x0F00) >> 8);
    byte y = (byte) ((instruction & 0x00F0) >> 4);

    byte kk = (byte) (instruction & 0x0FF);

    public void GenericOperations(int instruct){
        setInstruction(instruct);

        switch (instruct & 0xF000  >> 12){
            case 0x1:
                registerBank.PC = nnn;
                registerBank.PC += 2;
                break;
            case 0x2:
                break;
            case 0x3:
                if(registerBank.V[x] == kk){
                    registerBank.PC += (short) 0x0002;
                }
                break;
            case 0x4:
                if(registerBank.V[x] != kk){
                    registerBank.PC += (short) 0x0002;
                }
                break;
            case 0x5:
                if(registerBank.V[x]==registerBank.V[y]){
                    registerBank.PC = (short)(registerBank.PC + (short)0x0002);
                }
                break;
            case 0x6:
                registerBank.V[x] = kk;
                break;
            case 0x7:
                registerBank.V[x] = (byte) (registerBank.V[x] + kk);
                break;
            case 0x9:
                if(registerBank.V[x] != registerBank.V[y]){
                    registerBank.PC = (short)(registerBank.PC + (short)0x0002);
                }
                break;
            case 0xA:
                registerBank.I = nnn;
                break;
            case 0xB:
                break;
            case 0xC:
                break;

            default:
        }
    }
}
