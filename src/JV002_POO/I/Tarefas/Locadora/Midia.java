package JV002_POO.I.Tarefas.Locadora;
/*
Criar classe Pai chamada Midia

Atributos:
- codigo: String
- preco: Double
- nome: String

Métodos:
- darPlay()
- construtor(todos os argumentos)
- get() e set()
 */

public class Midia {
    private String codigo;
    private double preco;
    private String nome;

    public Midia(String codigo, double preco, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void darPlay() {
        System.out.println("A mídia começou a ser reproduzida!");
    }

    @Override
    public String toString() {
        return "Código: " + codigo + '\n' +
                "Preço: R$ " + preco + '\n' +
                "Nome: '" + nome + "'\n";
    }
}
