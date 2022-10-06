package JV001_Logica.JogoDaVelha;

import java.util.Scanner;

/*
- Utilizar o Scanner.
- O jogo deverá ter dois jogadores e pedir para informar os nomes deles.
- Ao final do jogo deverá ser informado o nome do jogador que ganhou ou se deu empate.
- Se for empate não soma pontos para o jogador.
- Exibir um placar ao final de cada partida entre os mesmos jogadores.
    -- Exemplo: (jogador1) 2 x 0 (jogador2)
- Perguntar se os mesmos jogadores querem jogar novamente.
   -- Se for empate mensagem genérica "Jogar novamente? "
   -- Se houver um vencedor mensagem "Revanche?"
 */

public class JogoDaVelha {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(1000);//millis

        Scanner input = new Scanner(System.in);

        String jogador1, jogador2, jogadorX = "", jogadorO = "";
        String jogadorXouO = "";
        int primeiroJogador;
        boolean partida = true, novaPartida = true;
        int placarX = 0, placarO = 0;
        String simOuNao = "";
        String[][] tabuleiro = {{"A1", "B1", "C1"}, {"A2", "B2", "C2"}, {"A3", "B3", "C3"}};

        iniciarJogo(tabuleiro);

        System.out.print("Digite o nome do primeiro jogador: ");
        jogador1 = input.nextLine();
        System.out.print("Digite o nome do segundo jogador: ");
        jogador2 = input.nextLine();

        do {
            primeiroJogador = primeiroJogador(jogador1, jogador2);
            if (primeiroJogador == 1) {
                jogadorX = jogador1;
                jogadorO = jogador2;

            } else if (primeiroJogador == 2) {
                jogadorX = jogador2;
                jogadorO = jogador1;
                System.out.println("\nDurante o jogo, " + jogadorX + " será X e " + jogadorO + " será O.");

            } else if (primeiroJogador != 1 && primeiroJogador != 2) {
                System.out.println("Jogador inexistente. Escolha entre as duas opções.");
            }
        } while (primeiroJogador != 1 && primeiroJogador != 2);


        while (novaPartida == true) {
            boolean vencedor = false;

            int jogadas = 1;

            System.out.println("\nTabuleiro inicial:");
            imprimirTabuleiro(tabuleiro);
            System.out.println();

            while (partida == true) {

                tabuleiro = jogada(jogadas, jogadorX, jogadorO, tabuleiro);

                String[] resultado = checarResultado(tabuleiro);

                for (int i = 0; i < resultado.length; i++) {
                    if (resultado[i].equals("XXX")) {
                        System.out.println(jogadorX + " ganhou a partida!");
                        placarX++;
                        System.out.println("Placar: " + jogadorX + " (" + placarX + ") x "
                                + jogadorO + " (" + placarO + ")");
                        partida = false;
                        vencedor = true;
                    } else if (resultado[i].equals("OOO")) {
                        System.out.println(jogadorO + " ganhou a partida!");
                        placarO++;
                        System.out.println("Placar: " + jogadorX + " (" + placarX + ") x "
                                + jogadorO + " (" + placarO + ")");
                        partida = false;
                        vencedor = true;
                    }
                }
                if (jogadas == 9) {
                    System.out.println("Empate!");
                    System.out.println("Placar: " + jogadorX + " (" + placarX + ") x "
                            + jogadorO + " (" + placarO + ")");
                    partida = false;
                    vencedor = false;
                }
                jogadas++;

            }

            if (partida == false) {
                do {
                    if(vencedor){
                        System.out.print("Revanche (S/N)?");
                    } else {
                        System.out.print("Desejam jogar novamente (S/N)?");
                    }
                    simOuNao = input.nextLine().toUpperCase();
                    if (simOuNao.equals("S")) {
                        novaPartida = true;
                        partida = true;
                    } else {
                        novaPartida = false;
                    }
                } while (!simOuNao.equals("S") || !simOuNao.equals("N"));
            }

        }
        input.close();
    }

    public static void iniciarJogo(String tabuleiro[][]) {
        System.out.println("*********** BEM-VINDO(A) AO NOSSO JOGO DA VELHA! ***********");
        System.out.println("• Para começar, é necessário inserir o nome dos dois jogadores;");
        System.out.println("• Também é necessário identificar quem vai jogar primeiro;");
        System.out.println("• O tabuleiro é definido pelas colunas A, B, C e linhas 1, 2 e 3;");
        System.out.println("• As jogadas são realizadas de acordo com as posições abaixo:");
        imprimirTabuleiro(tabuleiro);
        System.out.println("• Ao final, o placar é exibido e é possível jogar novamente ou sair.");
        System.out.println("**************** BOA SORTE E VAMOS COMEÇAR! ****************\n");

    }

    private static int primeiroJogador(String jogador1, String jogador2) {
        Scanner input = new Scanner(System.in);
        System.out.print("Quem irá iniciar o jogo, 1 ou 2? 1 = " +
                jogador1 + " e 2 = " + jogador2 + ": ");
        try {
            return input.nextInt();
        } catch (Exception e) {
            System.out.println("As opções devem ser entre os números 1 e 2.");
            return primeiroJogador(jogador1, jogador2);
        }
    }

    private static void imprimirTabuleiro(String tabuleiro[][]) {
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
                System.out.print(tabuleiro[linha][coluna]);
                if (coluna == 0 || coluna == 1)
                    System.out.print(" | ");
            }
            System.out.println();
        }
    }

    private static String[] checarResultado(String tabuleiro[][]) {
        String[] Resultado = new String[8];

        //Resultado Colunas
        Resultado[0] = tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2];
        Resultado[1] = tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2];
        Resultado[2] = tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2];
        //Resultado Linhas
        Resultado[3] = tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0];
        Resultado[4] = tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1];
        Resultado[5] = tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2];
        //Resultado Diagonais
        Resultado[6] = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        Resultado[7] = tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];

        return Resultado;
    }

    private static String[][] jogada(int jogadas, String jogadorX,
                                     String jogadorO, String[][] tabuleiro) {
        Scanner input = new Scanner(System.in);

        String jogadorXouO;

        if (jogadas % 2 == 1) {
            jogadorXouO = "X";
            System.out.print(jogadorX + ", digite uma posição para a jogada: ");
        } else {
            jogadorXouO = "O";
            System.out.print(jogadorO + ", digite uma posição para a jogada: ");
        }

        String posicao = input.nextLine().toUpperCase();

        switch (posicao) {
            case "A1":
                tabuleiro[0][0] = jogadorXouO;
                break;
            case "A2":
                tabuleiro[1][0] = jogadorXouO;
                break;
            case "A3":
                tabuleiro[2][0] = jogadorXouO;
                break;
            case "B1":
                tabuleiro[0][1] = jogadorXouO;
                break;
            case "B2":
                tabuleiro[1][1] = jogadorXouO;
                break;
            case "B3":
                tabuleiro[2][1] = jogadorXouO;
                break;
            case "C1":
                tabuleiro[0][2] = jogadorXouO;
                break;
            case "C2":
                tabuleiro[1][2] = jogadorXouO;
                break;
            case "C3":
                tabuleiro[2][2] = jogadorXouO;
                break;
            default:
                System.out.println("Posição inexistente ou já preenchida.");
                tabuleiro = jogada(jogadas, jogadorX, jogadorO, tabuleiro);
        }
        imprimirTabuleiro(tabuleiro);
        return tabuleiro;
    }

    public static void clearConsole() {

        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls", "clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

