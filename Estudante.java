import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas.
import java.util.List; // Importa a interface List para trabalhar com listas de forma genérica.
import java.util.Scanner; // Importa a classe Scanner para leitura de entrada do usuário.

// Define a classe Estudante que herda da classe Pessoa.
public class Estudante extends Pessoa {

    // Declaração de atributos estáticos e não estáticos.
    
    private static List<Estudante> estudantes = new ArrayList<>(); // Lista estática que armazena todos os estudantes.
    private String matricula; // Armazena o número de matrícula do estudante.

    // Construtor da classe Estudante que inicializa os atributos herdados e o atributo específico.
    public Estudante(String nome, int idade, String matricula) {
        super(nome, idade); // Chama o construtor da classe pai (Pessoa) para inicializar nome e idade.
        this.matricula = matricula; // Inicializa o atributo matrícula.
    }

    // Método estático que retorna a lista de estudantes.
    public static List<Estudante> getEstudantes() {
        return estudantes;
    }

    // Método estático para substituir a lista de estudantes.
    public static void setEstudantes(List<Estudante> estudantes) {
        Estudante.estudantes = estudantes;
    }

    // Retorna o valor da matrícula do estudante.
    public String getMatricula() {
        return matricula;
    }

    // Altera o valor da matrícula do estudante.
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Sobrescreve o método ExibirDados da classe Pessoa para exibir também a matrícula.
    @Override
    public void ExibirDados() {
        super.ExibirDados(); // Chama o método ExibirDados da classe pai.
        System.out.println("Matricula: " + getMatricula()); // Exibe a matrícula.
    }

    // Método estático para cadastrar um estudante na lista.
    public static void CadastrarEstudante(Estudante estudante) {
        estudantes.add(estudante); // Adiciona o estudante à lista.
        System.out.println("Estudante cadastrado com sucesso!");
    }

    // Edita um estudante com base na matrícula.
    public static boolean EditarEstudante(String matricula, String NovoNome, int Novaidade) {
        for (Estudante estudante : estudantes) { // Percorre a lista de estudantes.
            if (estudante.getMatricula().equals(matricula)) { // Verifica se a matrícula corresponde.
                estudante.setNome(NovoNome); // Altera o nome.
                estudante.setIdade(Novaidade); // Altera a idade.
                System.out.println("Estudante editado com sucesso!");
                return true; // Retorna verdadeiro se o estudante for encontrado e editado.
            }
        }
        System.out.println("Estudante nao encontrado!"); // Exibe mensagem se a matrícula não for encontrada.
        return false; // Retorna falso se não encontrar o estudante.
    }

    // Exclui um estudante com base na matrícula.
    public static boolean ExcluirEstudante(String matriculaExcluir) {
        boolean removido = estudantes.removeIf(estudante -> estudante.getMatricula().equals(matriculaExcluir)); 
        // Remove o estudante que tem a matrícula especificada.
        if (removido) {
            System.out.println("Estudante removido com sucesso!");
        } else {
            System.out.println("Estudante nao encontrado!");
        }
        return removido; // Retorna verdadeiro se o estudante foi removido.
    }

    // Lista todos os estudantes cadastrados.
    public static void ListarEStudantes() {
        if (estudantes.isEmpty()) { // Verifica se a lista está vazia.
            System.out.println("Estudante nao encontrado!");
        } else {
            System.out.println("LISTA DE ESTUDANTES");
            for (Estudante estudante : estudantes) { // Percorre e exibe os dados de cada estudante.
                estudante.ExibirDados();
            }
        }
    }

    // Consulta um estudante por nome ou matrícula.
    public static void ConsultarEstudante() {
        Scanner sc = new Scanner(System.in); // Scanner para entrada do usuário.
        System.out.println("Escolha o tipo de consulta:");
        System.out.println("1 - Consultar por nome");
        System.out.println("2 - Consultar por matrícula");
        int escolha = sc.nextInt(); // Lê a escolha do usuário.
        sc.nextLine(); // Limpa o buffer do scanner.

        Estudante estudanteEncontrado = null;

        if (escolha == 1) {
            System.out.print("Digite o nome do estudante: ");
            String nomeConsulta = sc.nextLine(); // Lê o nome.
            for (Estudante estudante : estudantes) { // Procura por nome.
                if (estudante.getNome().equalsIgnoreCase(nomeConsulta)) {
                    estudanteEncontrado = estudante; // Encontra o estudante.
                    break;
                }
            }
        } else if (escolha == 2) {
            System.out.print("Digite a matrícula do estudante: ");
            String matriculaConsulta = sc.nextLine(); // Lê a matrícula.
            for (Estudante estudante : estudantes) { // Procura por matrícula.
                if (estudante.getMatricula().equals(matriculaConsulta)) {
                    estudanteEncontrado = estudante; // Encontra o estudante.
                    break;
                }
            }
        }

        if (estudanteEncontrado != null) {
            estudanteEncontrado.ExibirDados(); // Exibe os dados do estudante encontrado.
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Editar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Voltar");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do scanner.

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome do estudante: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Digite a nova idade do estudante: ");
                    int novaIdade = sc.nextInt();
                    sc.nextLine(); 
                    EditarEstudante(estudanteEncontrado.getMatricula(), novoNome, novaIdade);
                    break;
                case 2:
                    ExcluirEstudante(estudanteEncontrado.getMatricula());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }

    // Menu interativo para gerenciar estudantes.
    public static void MenuEstudante(List<Estudante> estudantes) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU DE ESTUDANTES");
            System.out.println("1 - Cadastrar Estudante");
            System.out.println("2 - CONSULTAR ESTUDANTE");
            System.out.println("3 - SAIR");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do estudante: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite a idade do estudante: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a matrícula do estudante: ");
                    String matricula = sc.nextLine();

                    Estudante novoEstudante = new Estudante(nome, idade, matricula);
                    CadastrarEstudante(novoEstudante);
                    break;

                case 2:
                    ConsultarEstudante();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("OPCAO INVALIDA. TENTE NOVAMENTE");
            }
        } while (opcao != 3);
    }
}
