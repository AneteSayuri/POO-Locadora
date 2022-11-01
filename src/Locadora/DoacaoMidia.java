package Locadora;

import java.util.Random;

/* Criar classe DoacaoMidia
 * Essa classe deve conter método pegarMidiaAleatoria() que devolve uma midia já criada na biblioteca
 * aleatória
 * Essa classe deve conter método assisitirFilme(Dvd dvd) e chamar os dois métodos de legenda
 *
 * Método main
 * O main deve pegar uma midia aleatoria e dar o play
 */
public class DoacaoMidia {
    public static void main(String[] args) {

        System.out.println("Vamos testar 5 mídias aleatoriamente para ver se o sistema está funcionando?");

        for (int i = 1; i < 6; i++) {
            Midia midia = pegarMidiaAleatoria();
            System.out.println("\n" + i + ") Mídia sorteada:");
            System.out.println(midia);
            midia.darPlay();
        }

        //Teste Assistir Filme:
        System.out.println("\nO DVD abaixo foi selecionado para testarmos uma nova legenda:");
        Dvd dvd1 = new Dvd("DVD_01", 5.50, "Métodos", "Português", false, "N/A");
        assisitirFilme(dvd1);
    }

    public static Midia pegarMidiaAleatoria() {
        //Biblioteca
        Dvd dvd1 = new Dvd("DVD_01", 5.50, "Métodos", "Português", false, "N/A");
        Dvd dvd2 = new Dvd("DVD_02", 4d, "Atributos", "Inglês", true, "Português");
        Dvd dvd3 = new Dvd("DVD_03", 8d, "Classes", "Alemão", true, "Português");
        Dvd dvd4 = new Dvd("DVD_04", 13d, "POO", "Francês", false, "N/A");
        Dvd dvd5 = new Dvd("DVD_05", 9d, "Instâncias", "Francês", false, "N/A");
        Cd cd1 = new Cd("CD_01", 2d, "Herança", "Ada Lovelace", 10);
        Cd cd2 = new Cd("CD_02", 9.5d, "Polimorfismo", "Carol Shaw", 13);
        Cd cd3 = new Cd("CD_03", 7d, "Objetos", "Grace Hooper", 11);
        Cd cd4 = new Cd("CD_04", 8d, "Encapsulamento", "Frances Allen", 20);
        Cd cd5 = new Cd("CD_05", 11.5d, "Construtores", "Roberta Williams", 18);

        Midia[] midias = {dvd1, dvd2, dvd3, dvd4, dvd5, cd1, cd2, cd3, cd4, cd5};
        Random sorteio = new Random();
        int numeroSorteado = sorteio.nextInt(midias.length);
        return midias[numeroSorteado];
    }

    public static void assisitirFilme(Dvd dvd) {
        Dvd dvdSelecionado = new Dvd(dvd.getCodigo(), dvd.getPreco(), dvd.getNome(),
                dvd.getIdioma(), dvd.isPossuiLegenda(), dvd.getIdiomaLegenda());
        System.out.println(dvdSelecionado);
        dvdSelecionado.legenda(true, "Português");
        dvdSelecionado.legenda(false);
    }
}
