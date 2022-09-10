package inc.hardware.cpu.p1;

public class Instruções {

    private Registradores registradores;

    //Função 7xKK - Define Vx = Vx + kk.
    public  void ADDVxByte(byte x, byte kk){
        registradores.V[x] = (byte) (registradores.V[x] + kk);
    }

    //Função  8xy0 - LD Vx, Vy
    public  void LDVxVy(byte x, byte y){
        registradores.V[x] = registradores.V[y];
    }

    //Função Ann - LD I, endereço
    public  void LDIEnd(short address){
        registradores.I = address;
    }

    //Função 8xy1 - OR Vx, Vy
    public void ORVxVy(byte x, byte y){
        registradores.V[x] = (byte)(registradores.V[x] | registradores.V[y]);
    }

    //Função 8xy2 - AND Vx, Vy
    public  void ANDVxVy(byte x, byte y){
        registradores.V[x] = (byte)(registradores.V[x] & registradores.V[y]);
    }


}