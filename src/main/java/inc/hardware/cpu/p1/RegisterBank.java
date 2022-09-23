package inc.hardware.cpu.p1;

public class RegisterBank {
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
        public RegisterBank(){
            V = new byte[16];
            I = 0x0000;
            atraso = 0x0000;
            som = 0x0000;
            PC = 0x0200;
            SP = 0x0000;
        }
}
