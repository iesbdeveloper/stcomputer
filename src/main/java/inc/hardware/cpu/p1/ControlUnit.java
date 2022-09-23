package inc.hardware.cpu.p1;

import inc.hardware.memory.MemoryController;

public class ControlUnit {

    private RegisterBank registradores;
    private Instrucoes instrucoes;
    private MemoryController memory;
    private int instruction;

    public ControlUnit(RegisterBank registradores) {
        this.registradores = registradores;
    }


    // Fetch
    public void fetch(){
        short PC = registradores.PC; // Como incrementar o contador?? registradores.pc += 2;


        // Aqui estamos combinando os 2 bytes para formamos uma instrução
        // Precisamos da memória!

        instruction = (memory.getB(PC) << 8  | (memory.getB(PC+1)) & 0X00FF);

    }


    // Decode


    public void decodeExecute(){

        byte x = (byte) ((instruction & 0x0F00) >> 8);
        byte y = (byte) ((instruction & 0x00F0) >> 4);
        byte n = (byte) (instruction & 0x00F);
        short nnn = (short) (instruction & 0xFFF);
        byte kk = (byte) (instruction & 0x0FF);

        switch((instruction & 0xF000) >> 12){
            case 0x0:
                ZeroOperations(instruction);
                break;
            case 0x1:
                instrucoes.jp(nnn);
                break;
            case 0x2:
                break;
            case 0x3:

            case 0x8:
                EigthOperations(instruction, x, y);
                break;
        }

    }



    // Funções para instruções



    private void ZeroOperations(int instruct){

    }



    private void EigthOperations(int instruct, byte x, byte y){

        switch (instruct & 0x000F){
            case 0x0:
                instrucoes.ldxy(x,y);
                registradores.PC += 2;
                break;
            default:
        }
    }


}
