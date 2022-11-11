package inc.hardware.cpu.p1;

/**
 * Classe que descreve os registradores utilizados na CPU
 */
public class RegisterBank {
        /* registradores de uso geral de 8 bits */
        public byte[] v;

        /* registrador I, armazena endereços de memória */
        public short i;

        /* registrador para temporizador de atraso */
        public byte atraso;

        /* registrador para temporizador de som */
        public byte som;

        /* program count de 16 bits */
        public short pc;

        /* ponteiro de pilha de 8 bits */
        public byte sp;

        /* Inicializando os Registradores */
        public RegisterBank(){
            v = new byte[16];
            i = 0x0000;
            atraso = 0x0000;
            som = 0x0000;
            pc = 0x0200;
            sp = 0x0000;
        }
}
