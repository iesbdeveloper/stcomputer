package inc.hardware.cpu.p1;

import inc.hardware.interfaces.LGA;

/**
 * ======================================================
 * INSTRUÇÕES
 *
 *
 * 0nnn - SYS endereço
 * Ir para uma rotina de código de máquina em nnn.
 *
 * 00E0 - CLS
 * Limpe a tela.
 *
 * 00EE - RET
 * Retorno de uma sub-rotina.
 *
 * 1nnn - JP addr
 * Ir para o local nnn. Define o contador do programa para nnn.
 *
 * 2nnn - Executa endereço
 * Chamar a sub-rotina em nnn. Incrementa o ponteiro da pilha e coloca o PC
 * atual no topo da pilha. O PC é então definido como nnn.
 *
 * 3xkk - SE Vx, byte
 * Pule a próxima instrução se Vx = kk. Compara o registrador Vx com kk e, se forem iguais,
 * incrementa o contador do programa em 2.
 *
 * 4xkk - SNE Vx, byte
 * Pule a próxima instrução se Vx != kk. Compara o registrador Vx com kk e, se não forem iguais,
 * incrementa o contador do programa em 2.
 *
 * 5xy0 - SE Vx, Vy
 * Pule a próxima instrução se Vx = Vy. Compara o registrador Vx com o registrador Vy e, se forem iguais,
 * incrementa o contador do programa em 2.
 *
 * 6xkk - LD Vx, byte
 * Define Vx = kk. coloca o valor kk no registrador Vx.
 *
 * 7xkk - ADD Vx, byte
 * Define Vx = Vx + kk. Adiciona o valor kk ao valor do registrador Vx e armazena o resultado em Vx.
 *
 * 8xy0 - LD Vx, Vy
 * Define Vx = Vy. Armazena o valor do registrador Vy no registrador Vx.
 *
 * 8xy1 - OR Vx, Vy
 * Define Vx = Vx OU Vy. Executa um OR bit a bit nos valores de Vx e Vy e, em seguida,
 * armazena o resultado em Vx. Um OR bit a bit compara os bits correspondentes de dois
 * valores e, se um dos bits for 1, o mesmo bit no resultado também será 1. Caso contrário,
 * será 0.
 *
 * 8xy2 - AND Vx, Vy
 * Define Vx = Vx E Vy. Executa um AND bit a bit nos valores de Vx e Vy e, em seguida,
 * armazena o resultado em Vx. Um AND bit a bit compara os bits correspondentes de dois
 * valores e, se ambos os bits forem 1, o mesmo bit no resultado também será 1. Caso contrário,
 * será 0.
 *
 * 8xy3 - XOR Vx, Vy
 * Define Vx = Vx XOR Vy. Executa um OR exclusivo bit a bit nos valores de Vx e Vy e, em seguida,
 * armazena o resultado em Vx. Um OR exclusivo compara os bits correspondentes de dois valores e,
 * se os bits não forem os mesmos, o bit correspondente no resultado será definido como 1. Caso
 * contrário, será 0.
 *
 * 8xy4 - ADD Vx, Vy
 * Define Vx = Vx + Vy, defina VF = transporte (carry). Os valores de Vx e Vy são somados. Se o
 * resultado for maior que 8 bits (ou seja, > 255), VF é definido como 1, caso contrário, 0.
 * Apenas os 8 bits mais baixos do resultado são mantidos e armazenados em Vx.
 *
 * 8xy5 - SUB Vx, Vy
 * Defina Vx = Vx - Vy, defina VF = NÃO emprestar. Se Vx > Vy, então VF é definido como 1,
 * caso contrário, 0. Então Vy é subtraído de Vx e os resultados armazenados em Vx.
 *
 * 8xy6 - SHR Vx {, Vy}
 * Defina Vx = Vx SHR 1. Se o bit menos significativo de Vx for 1, então VF é definido como 1,
 * caso contrário, 0. Então Vx é dividido por 2.
 *
 * 8xy7 - SUBN Vx, Vy
 * Defina Vx = Vy - Vx, defina VF = NÃO emprestado. Se Vy > Vx, então VF é definido como 1,
 * caso contrário, 0. Então Vx é subtraído de Vy e os resultados armazenados em Vx.
 *
 * 8xyE - SHL Vx {, Vy}
 * Defina Vx = Vx SHL 1. Se o bit mais significativo de Vx for 1, então VF é definido como 1,
 * caso contrário, como 0. Então Vx é multiplicado por 2.
 *
 * 9xy0 - SNE Vx, Vy
 * Pule a próxima instrução se Vx != Vy. Os valores de Vx e Vy são comparados e, se não forem
 * iguais, o contador do programa é aumentado em 2.
 *
 * Ann - LD I, endereço
 * Registrador I = nnn. O valor do registrador I é definido como nnn.
 *
 * Bnnn - JP V0, endereço
 * Saltar para a localização nnn + V0. O contador de programa é definido como nnn mais o
 * valor de V0.
 *
 * Cxkk - RND Vx, byte
 * Defina Vx = byte aleatório AND kk. Gera um número aleatório de 0 a 255, que é então
 * colocado em AND com o valor kk. Os resultados são armazenados em Vx. Consulte a
 * instrução 8xy2 para obter mais informações sobre AND.
 *
 *
 * Dxyn - DRW Vx, Vy, nibble
 * Exibe o sprite (enviar para a placa de vídeo pela interrupção de vídeo) de n bytes
 * começando no local de memória I em (Vx, Vy), defina VF = colisão.
 * Ler n bytes da memória, começando no endereço armazenado em I. Esses bytes são então
 * exibidos como sprites (bloco de desenho na tela) na tela nas coordenadas (Vx, Vy).
 * Sprites são XORed na tela existente. Se isso fizer com que algum pixel seja apagado,
 * VF é definido como 1, caso contrário, é definido como 0. Se o sprite estiver posicionado
 * de forma que parte dele esteja fora das coordenadas da tela, ele se volta para o lado
 * oposto da tela. Consulte a instrução 8xy3 para obter mais informações sobre XOR.
 *
 * REFERÊNCIA: Arquivo VideoPCIE16X.java
 *
 *
 * Ex9E - SKP Vx
 * Pule a próxima instrução se a tecla com o valor de Vx for pressionada. Verifica o teclado
 * e, se a tecla correspondente ao valor de Vx estiver atualmente na posição para baixo,
 * PC é aumentado em 2.
 *
 * ExA1 - SKNP Vx
 * Pule a próxima instrução se a tecla com o valor de Vx não for pressionada.
 * Verifica o teclado e, se a tecla correspondente ao valor de Vx estiver atualmente
 * na posição para cima, PC é aumentado em 2.
 *
 * Fx07 - LD Vx, DT
 * Defina Vx = valor do temporizador de atraso. O valor de DT é colocado em Vx.
 *
 * Fx0A - LD Vx, K
 * Aguarde o pressionamento de uma tecla, armazene o valor da tecla em Vx. Toda a execução
 * pára até que uma tecla seja pressionada, então o valor dessa tecla é armazenado em Vx.
 *
 * Fx15 - LD DT, Vx
 * Defina o temporizador de atraso = Vx. DT é igual ao valor de Vx.
 *
 * Fx18 - LD ST, Vx
 * Defina o temporizador de som = Vx. ST é igual ao valor de Vx.
 *
 * Fx1E - ADD I, Vx
 * Conjunto I = I + Vx. Os valores de I e Vx são somados e os resultados são armazenados em I.
 *
 * Fx29 - LD F, Vx
 * Defina I = localização do sprite para o dígito Vx. O valor de I é definido para o local do
 * sprite hexadecimal correspondente ao valor de Vx.
 * REFERÊNCIA: Arquivo VideoPCIE16X.java
 *
 * Fx33 - LD B, Vx
 * Armazene a representação BCD de Vx nos locais de memória I, I+1 e I+2.
 * Pega o valor decimal de Vx e coloca o dígito das centenas na memória na posição I,
 * o dígito das dezenas na posição I+1 e o dígito das unidades na posição I+2.
 *
 *
 * Fx55 - LD [I], Vx
 * Armazene os registradores V0 a Vx na memória começando na localização I.
 * Copia os valores dos registradores V0 a Vx na memória, começando no endereço em I.
 *
 * Fx65 - LD Vx, [I]
 * Leia os registradores V0 a Vx da memória começando na localização I.
 * Ler os valores da memória começando no local I nos registradores V0 a Vx.
 *
 *
 * ======================================================
 * REGISTRADORES
 *
 * 16 registradores de 8 bits de uso geral, geralmente chamados de Vx, onde x é um dígito hexadecimal (0 a F).
 * Há também um registrador de 16 bits chamado I. Esse registrador geralmente é usado para armazenar endereços
 * de memória, portanto, apenas os 12 bits mais baixos (mais à direita) são normalmente usados.
 *
 * O registrador VF não deve ser usado por nenhum programa, pois é usado como flag por algumas instruções.
 * Dois registradores de 8 bits para fins especiais, para os temporizadores de atraso e som. Quando esses
 * registradores são diferentes de zero, eles são decrementados automaticamente a uma taxa de 60Hz.
 *
 * O contador de programa (PC) deve ser de 16 bits e é usado para armazenar o endereço atualmente em execução.
 * O ponteiro de pilha (SP) pode ser de 8 bits, é usado para apontar para o nível mais alto da pilha.
 *
 * A pilha é um array de 16 valores de 16 bits, usado para armazenar o endereço ao qual a execução deve retornar
 * quando terminar com uma sub-rotina. É permitido até 16 níveis de sub-rotinas aninhadas.
 *
 *
 * ======================================================
 * TEMPORIZADORES E SOM
 *
 * Existem 2 temporizadores, um temporizador de atraso e um temporizador de som.
 * O temporizador de atraso está ativo sempre que o registro do temporizador de atraso (DT)
 * for diferente de zero. Este temporizador não faz nada além de subtrair 1 do valor de DT a uma
 * taxa de 60Hz (60 vezes por segundo). Quando DT atinge 0, ele é desativado.
 *
 * O temporizador de som está ativo sempre que o registro do temporizador de som (ST) for
 * diferente de zero. Este temporizador também diminui a uma taxa de 60Hz, porém, enquanto o
 * valor de ST for maior que zero, deve-se chamar a interrupção de som da placa-mãe para tocar
 * o som de um beep. Quando ST atinge zero, o temporizador de som é desativado.
 *
 */

public class PintelP1 implements LGA {

    enum Instructions {
        I00E0, I00EE, I0nnn, I1nnn, I2nnn, I3xkk, I4xkk, I5xy0, I6xkk, I7xkk, I8xy0, I8xy1, I8xy2, I8xy3,
        I8xy4, I8xy5, I8xy6, I8xy7, I8xyE, I9xy0, IAnnn, IBnnn, ICxkk, IDxyn, IEx9E, IExA1, IFx07, IFx0A,
        IFx15, IFx18, IFx1E, IFx29, IFx33, IFx55, IFx65
    }

}
