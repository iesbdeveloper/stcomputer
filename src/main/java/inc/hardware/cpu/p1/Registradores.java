package inc.hardware.cpu.p1;

public class Registradores {
        //registradores de uso geral de 8 bits
        public byte[] V;

        //registrador I, armazena endereços de memória
        public short I;

        //registrador para temporizador de atraso
        public byte atraso;

        //registrador para temporizador de som
        public byte som;

        //program count de 16 bits
        public short PC;

        //ponteiro de pilha de 8 bits
        public byte SP;

        //Inicializando os Registradores
        public Registradores(){
            V = new byte[16];
            I = 0;
            atraso = 0;
            som = 0;
            PC = 0;
            SP = 0;
        }
}
