package inc.hardware.cpu.p1;

public class Instrucoes {

    private RegisterBank registradores;

    //Função 00E0 - CLS


    //Função 00EE - RET

    //Função 1nnn - JP addr

        public void jp(short nnn){
            registradores.PC = nnn;
        }

    //Função 2nnn - CALL addr

    //Função 3xkk - SE Vx, byte
        public void sexkk(byte x, byte kk){
            if(registradores.V[x] == kk){
                registradores.PC += (short) 0x0002;
            }
        }

    //Função 4xkk - SNE Vx byte
        public void snexkk(byte x, byte kk){
            if(registradores.V[x] != kk){
                registradores.PC += (short) 0x0002;
            }
        }

    //Função 5xy0 - Se Vx, Vy
        public  void sexy(byte x, byte y){
        if(registradores.V[x]==registradores.V[y]){
            registradores.PC = (short)(registradores.PC + (short)0x0002);
        }
    }

    //Função 6xkk - LD Vx, byte
        public  void ldxkk(byte x, byte kk){
            registradores.V[x] = kk;
        }

    //Função 7xkk - ADD Vx, byte
        public  void addxkk(byte x, byte kk){

            registradores.V[x] = (byte) (registradores.V[x] + kk);
        }
    /* Função  8xy0 - LD Vx, Vy
        public  void ldxy(byte x, byte y){
            registradores.V[x] = registradores.V[y];
        }
    //Função 9xy0 - SNE Vx, Vy*/
        public void snexy(byte x, byte y){

            if(registradores.V[x] != registradores.V[y]){
                registradores.PC = (short)(registradores.PC + (short)0x0002);
            }
        }

    /*Função Ann - LD I, addr
        public  void ldiaddr(short address){
            registradores.I = address;
        }
    */

    Função Bnn - JP V0, addr //Keyboard

    Função Dxyn - DRW Vx, Vy, nibble // Display

    Função Ex9E - SKP Vx
    Função ExA1 - SKNP Vx

    /*Função Fx07 - LD Vx, DT
        public void ldxdt(byte x){
            registradores.V[x]= registradores.atraso;
        }

    //Função Fx0A - LD Vx, K

    Função Fx15 - LD DT, Vx
        public void lddtx(byte x){
            registradores.atraso = registradores.V[x];
        }
    //Função Fx18 - LD ST, Vx
        public void ldstx(byte x){
            registradores.som = registradores.V[x];
        }
        */
}