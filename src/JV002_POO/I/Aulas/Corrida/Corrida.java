package JV002_POO.I.Aulas.Corrida;

public class Corrida {

    public static void main(String[] args) {

        Piloto ana = new Piloto("Ana", 20, Sexo.Mulher, "Time Ana");
        Piloto caio = new Piloto("Caio", 30, Sexo.Homem, "Time Caio");
        Carro carroAna = new Carro(1, ana, 60f, 0f, false);
        Carro carroCaio = new Carro(2, caio, 60f, 0f, false);

        System.out.println("----------------------------- Pista 1 -----------------------------");
        apresentarCarroPiloto(carroAna);
        System.out.println("** Ligar.");
        ligar(carroAna);
        System.out.println("** Acelerar.");
        acelerar(50f, carroAna);
        System.out.println("** Frear.");
        frear(20f, carroAna);
        System.out.println("** Parar.");
        parar(carroAna);
        System.out.println("** Desligar.");
        desligar(carroAna);
        System.out.println("-------------------------------------------------------------------");

        System.out.println();
        System.out.println("----------------------------- Pista 2 -----------------------------");
        apresentarCarroPiloto(carroCaio);
        System.out.println("** Acelerar o carro desligado.");
        acelerar(10f, carroCaio);
        System.out.println("** Ligar.");
        ligar(carroCaio);
        System.out.println("** Acelerar acima da velocidade máxima.");
        acelerar(70f, carroCaio);
        System.out.println("** Tentar desligar o carro em movimento.");
        desligar(carroCaio);
        System.out.println("** Frear menos que a velocidade mínima.");
        frear(70f, carroCaio);
        System.out.println("** Parar o carro já parado.");
        parar(carroCaio);
        System.out.println("** Desligar.");
        desligar(carroCaio);
        System.out.println("-------------------------------------------------------------------");

    }

    // Métodos:
    // Inicializar a pista
    private static void apresentarCarroPiloto(Carro carro) {
        System.out.println(" Número do carro: " + carro.getNumeroCarro());
        System.out.println(" Piloto(a): " + carro.getPiloto().getNome());
        System.out.println(" Idade: " + carro.getPiloto().getIdade());
        System.out.println(" Equipe: " + carro.getPiloto().getEquipe());
        System.out.println(" Velocidade máxima do carro: " + carro.getVelocidadeMaxima() + " km/h.");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("** Ações executadas pelo carro:");
    }


    //+ ligar()
    public static void ligar(Carro carro) {
        carro.setLigado(true);
        System.out.println(" * Carro da(o) " + carro.getPiloto().getNome() + " foi ligado!");
    }

    // + acelerar(float) - aumenta a velocidade em Km/h (Soma em Km/h a velocidade atual)
    //* Não ultrapassar a velocidade máxima
    //* Frear e Acelerar só funcionam se o carro estiver ligado
    public static void acelerar(float velocidadeAdicionada, Carro carro) {
        if (carro.isLigado()) {
            System.out.println(" * Acelerando o carro em " + velocidadeAdicionada + " km/h...");
            System.out.print("   Velocidade atual: " + carro.getVelocidadeAtual() + " km/h.");
            float novaVelocidade = carro.getVelocidadeAtual() + velocidadeAdicionada;
            if (novaVelocidade >= carro.getVelocidadeMaxima()) {
                carro.setVelocidadeAtual(carro.getVelocidadeMaxima());
                System.out.println(" --> O carro atingiu a velocidade máxima de "
                        + carro.getVelocidadeAtual() + " km/h.");
            } else {
                carro.setVelocidadeAtual(novaVelocidade);
                System.out.println(" --> Nova Velocidade: " + carro.getVelocidadeAtual() + " km/h.");
            }
        } else {
            System.out.println("   O carro está desligado. Ligue ele primeiro.");
        }
    }

    //+ frear(float) - reduz a velocidade em Km/h (subtrai em Km/h a velocidade atual)
    public static void frear(float velocidadeReduzida, Carro carro) {
        if (carro.isLigado()) {
            System.out.println(" * Freando o carro em " + velocidadeReduzida + " km/h...");
            System.out.print("   Velocidade atual: " + carro.getVelocidadeAtual() + " km/h.");

            if (carro.getVelocidadeAtual() == 0f) {
                System.out.println(" --> O carro já está parado.");
            } else {
                float novaVelocidade = carro.getVelocidadeAtual() - velocidadeReduzida;
                if (novaVelocidade <= 0) {
                    carro.setVelocidadeAtual(0f);
                    System.out.println(" --> O carro atingiu a velocidade mínima (parado).");
                } else {
                    carro.setVelocidadeAtual(novaVelocidade);
                    System.out.println(" --> Nova Velocidade: " + carro.getVelocidadeAtual() + " km/h.");
                }
            }
        } else {
            System.out.println("   O carro está desligado. Ligue ele primeiro.");
        }
    }

    //+ parar() - velocidade igual a 0 Km/h
    public static void parar(Carro carro) {
        if (carro.isLigado()) {
            System.out.println(" * Parando o carro...");
            System.out.print("   Velocidade atual: " + carro.getVelocidadeAtual() + " km/h.");

            if (carro.getVelocidadeAtual() == 0f) {
                System.out.println(" --> O carro já está parado.");
            } else {
                carro.setVelocidadeAtual(0f);
                System.out.println(" --> O carro foi parado.");
            }
        } else {
            System.out.println("   O carro está desligado. Ligue ele primeiro.");
        }
    }

    //+ desligar()
    //* Desligar só funciona se o carro estiver parado
    public static void desligar(Carro carro) {

        System.out.println(" * Desligando o carro...");
        System.out.println("   Velocidade atual: " + carro.getVelocidadeAtual() + " km/h.");

        if (carro.getVelocidadeAtual() > 0f) {
            System.out.println("   Não é possível desligar o carro em movimento. Pare ele antes.");
        } else {
            carro.setLigado(false);
            System.out.println("   Carro desligado!");
        }

    }

}
