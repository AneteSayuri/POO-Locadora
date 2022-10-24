package JV002_POO.I.Aulas.Corrida;

public class Piloto {

    // Atributos
    private String nome;
    private Integer idade;
    private Sexo sexo;
    private String equipe;

    // Constructor
    public Piloto(String nome, Integer idade, Sexo sexo, String equipe) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.equipe = equipe;
    }

    // Getter and Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
}
