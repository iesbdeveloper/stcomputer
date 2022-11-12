# Storage Stcomputer

Branch responsavel pela implementação e desenvolvimento da parte lógica de um Hard Disk para o projeto proposto na matéria de Programação Orientada a Objeto cuja a finalidade é emular um computador. O Storage tem sua estrutura de: Discos,Trilhas e setores, neste programa está sendo usado 4 discos, 305 trilhas em cada disco e 17 setores em cada trilha que há no HD, ao fim deste projeto o método de escrever deverá gravar de forma que o dado não se perca ao desligar a máquina tornando uma memória não volátil

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

git clone https://github.com/iesbdeveloper/stcomputer.git

cd stcomputer/

git checkout Storage

Consulte **[Implantação](#-implanta%C3%A7%C3%A3o)** para saber como implantar o projeto.

### 🔧 Instalação

Baixe e instale uma IDE de sua escolha que rode a linguagem Java (Ex: Intellij)

Vá em Open project, procure pelo diretório do local que realizou o git clone e selecione a pasta stcomputer

## ⚙️ Executando os testes

Executando a classe "Main.java" que está dentro de src>main>java

### 🔩 Analise os testes de ponta a ponta

No teste ele verifica o instanciamento de um HD

Testa os métodos de gravação(write) e leitura(read) de dados e o seus recebimentos e retornos de parâmetros

Também testa os métodos de retorno do espaço total do HD e o espaço livre nele

## 📦 Implantação

A forma de implementação de uma Hard Disk é atrás de sua interface "Sata" nela possui os métodos abstratos necessários para o funcionamento do mesmo, faça um implements Sata na classe que irá utilizar o HD

## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [Intellij](https://www.jetbrains.com/idea/download/#section=windows) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência

## ✒️ Autores

* [Caio Falleiro](https://github.com/Falleiro)

* [Rafael Braz](https://github.com/Rarazc)

* [Iago santos](https://github.com/iago-cyber)

* [Saulo-Dorigon](https://github.com/Saulo-Dorigon)

* [EDDIE the Giant of Teas](https://github.com/EDDIE0virmond)

* [vinicius silva](https://github.com/vinicius-sj)

