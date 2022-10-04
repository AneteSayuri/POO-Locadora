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

    public static void main(String[] args) {

        String jogador1, jogador2, jogadorX = "", jogadorO = "";
        String jogadorXouO = "";
        int primeiroJogador = 0;
        boolean partida = true, novaPartida = true;
        int placarX = 0, placarO = 0;
        String simOuNao = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do primeiro Jogador: ");
        jogador1 = input.nextLine();
        System.out.print("Digite o nome do segundo Jogador: ");
        jogador2 = input.nextLine();

        do {
            primeiroJogador = primeiroJogador(jogador1, jogador2);
            if (primeiroJogador == 1) {
                jogadorX = jogador1;
                jogadorO = jogador2;
                System.out.println(jogadorX + " será X e " + jogadorO + " será O, durante o jogo.");
            } else if (primeiroJogador == 2) {
                jogadorX = jogador2;
                jogadorO = jogador1;
                System.out.println(jogadorX + " será X e " + jogadorO + " será O, durante o jogo.");
            } else if (primeiroJogador != 1 && primeiroJogador != 2) {
                System.out.println("Jogador inexistente. Escolha entre as duas opções.");
            }
        } while (primeiroJogador != 1 && primeiroJogador != 2);


        while (novaPartida == true) {

            String[][] tabuleiro = {{"A1", "B1", "C1"}, {"A2", "B2", "C2"}, {"A3", "B3", "C3"}};
            int jogadas = 1;

            System.out.println("\nTabuleiro inicial:");
            imprimirTabuleiro(tabuleiro);

            while (partida == true) {

                tabuleiro = jogada(jogadas, jogadorXouO, jogadorX, jogadorO, tabuleiro);

                String[] resultado = checarResultado(tabuleiro);

                for (int i = 0; i < resultado.length; i++) {
                    if (resultado[i].equals("XXX")) {
                        System.out.println(jogadorX + " ganhou a partida!");
                        placarX++;
                        System.out.println("Placar: " + jogadorX + " (" + placarX + ") x "
                                + jogadorO + " (" + placarO + ")");
                        partida = false;
                    } else if (resultado[i].equals("OOO")) {
                        System.out.println(jogadorO + " ganhou a partida!");
                        placarO++;
                        System.out.println("Placar: " + jogadorX + " (" + placarX + ") x "
                                + jogadorO + " (" + placarO + ")");
                        partida = false;
                    }
                }
                if (jogadas == 9) {
                    System.out.println("Empate!");
                    System.out.println("Placar: " + jogadorX + " (" + placarX + ") x "
                            + jogadorO + " (" + placarO + ")");
                    partida = false;
                }
                jogadas++;

            }

            if (partida == false) {
                System.out.print("Desejam jogar novamente (S/N)? ");
                simOuNao = input.nextLine();
                if (simOuNao.equals("S")) {
                    novaPartida = true;
                    partida = true;
                } else {
                    novaPartida = false;
                }
            }

        }
        input.close();
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

    private static String[][] jogada(int jogadas, String jogadorXouO, String jogadorX,
                                     String jogadorO, String tabuleiro[][]) {
        Scanner input = new Scanner(System.in);

        if (jogadas % 2 == 1) {
            jogadorXouO = "X";
            System.out.print(jogadorX + " digite uma posição para a jogada: ");
        } else {
            jogadorXouO = "O";
            System.out.print(jogadorO + " digite uma posição para a jogada: ");
        }
        String posicao = input.nextLine();

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
                tabuleiro = jogada(jogadas, jogadorXouO, jogadorX, jogadorO, tabuleiro);
        }
        imprimirTabuleiro(tabuleiro);
        return tabuleiro;
    }

}

