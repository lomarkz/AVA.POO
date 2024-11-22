// Define a classe abstrata Pessoa.
abstract class Pessoa {

    // Atributos privados para armazenar os dados de uma pessoa.
    private String nome; // Nome da pessoa.
    private int idade;   // Idade da pessoa.

    // Construtor da classe para inicializar os atributos.
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método getter para o atributo 'nome'.
    public String getNome() {
        return nome;
    }

    // Método setter para o atributo 'nome'.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para o atributo 'idade'.
    public int getIdade() {
        return idade;
    }

    // Método setter para o atributo 'idade'.
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método para exibir os dados da pessoa.
    public void ExibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
