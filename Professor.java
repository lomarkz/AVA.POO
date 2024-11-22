import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Professor herda de Pessoa, então ela também tem nome e idade.
public class Professor extends Pessoa {

    // Lista estática para armazenar todos os professores cadastrados
    private static List<Professor> professores = new ArrayList<>();

    // Atributos específicos do professor
    private String especialidade;  // Especialidade do professor
    private String matriculaProfessor;  // Matrícula única do professor

    // Construtor da classe Professor, inicializando os atributos herdados e os próprios
    public Professor(String nome, int idade, String matriculaProfessor, String especialidade) {
        super(nome, idade);  // Chama o construtor da classe Pessoa
        this.matriculaProfessor = matriculaProfessor;
        this.especialidade = especialidade;
    }

    // Método para obter a lista de professores
    public static List<Professor> getProfessores() {
        return professores;
    }

    // Método para configurar a lista de professores
    public static void setProfessores(List<Professor> professores) {
        Professor.professores = professores;
    }

    // Métodos getters e setters para especialidade e matrícula
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(String matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    // Sobrescreve o método ExibirDados da classe Pessoa para mostrar também os dados do professor
    @Override
    public void ExibirDados() {
        super.ExibirDados();  // Chama o método ExibirDados da classe Pessoa
        System.out.println("Matricula: " + getMatriculaProfessor());  // Exibe matrícula
        System.out.println("Especialidade: " + getEspecialidade());  // Exibe especialidade
    }

    // Método para cadastrar um novo professor na lista de professores
    public static void CadastrarProfessor(Professor professor) {
        professores.add(professor);  // Adiciona o professor na lista
        System.out.println("Professor cadastrado com sucesso!");
    }

    // Método para editar os dados de um professor com base na matrícula
    public static boolean EditarProfessor(String matriculaProfessor, String NovoNome, String NovoEspecialidade) {
        for (Professor professor : professores) {
            if (professor.getMatriculaProfessor().equals(matriculaProfessor)) {  // Verifica se a matrícula corresponde
                professor.setNome(NovoNome);  // Atualiza o nome do professor
                professor.setEspecialidade(NovoEspecialidade);  // Atualiza a especialidade
                System.out.println("Professor editado com sucesso!");
                return true;  // Retorna true indicando que o professor foi editado
            }
        }
        System.out.println("Professor NAO ENCONTRADO!");  // Se o professor não for encontrado
        return false;
    }

    // Método para excluir um professor baseado na matrícula
    public static boolean ExcluirProfessor(String matriculaProfessor) {
        boolean removido = professores.removeIf(professor -> professor.getMatriculaProfessor().equals(matriculaProfessor));  // Remove o professor
        if (removido) {
            System.out.println("Professor excluido com sucesso!");
        } else {
            System.out.println("Professor NAO ENCONTRADO!");  // Caso não seja encontrado
        }
        return removido;  // Retorna se o professor foi removido ou não
    }

    // Método para listar todos os professores cadastrados
    public static void ListarProfessores() {
        if (professores.isEmpty()) {  // Verifica se a lista está vazia
            System.out.println("Professor NAO ENCONTRADO!");
        } else {
            System.out.println("LISTA DE PROFESSORES!");
            for (Professor professor : professores) {
                professor.ExibirDados();  // Exibe os dados de cada professor
            }
        }
    }

    // Método para consultar um professor por nome ou matrícula
    public static void ConsultarProfessor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o tipo de consulta:");
        System.out.println("1 - Consultar por nome");
        System.out.println("2 - Consultar por matrícula");
        int opcao = sc.nextInt();  // Lê a opção de consulta
        sc.nextLine();

        Professor professorEncontrado = null;  // Variável para armazenar o professor encontrado

        if (opcao == 1) {  // Caso o usuário queira consultar por nome
            System.out.println("DIGITE O NOME DO PROFESSOR");
            String nome = sc.nextLine();
            for (Professor professor : professores) {
                if (professor.getNome().equals(nome)) {  // Verifica se o nome corresponde
                    professorEncontrado = professor;
                    break;
                }
            }
        }

        if (opcao == 2) {  // Caso o usuário queira consultar por matrícula
            System.out.println("DIGITE O MATRICULA DO PROFESSOR");
            String matricula = sc.nextLine();
            for (Professor professor : professores) {
                if (professor.getMatriculaProfessor().equals(matricula)) {  // Verifica se a matrícula corresponde
                    professorEncontrado = professor;
                    break;
                }
            }
        }

        // Se o professor for encontrado, exibe seus dados e dá a opção de editar ou excluir
        if(professorEncontrado != null) {
            professorEncontrado.ExibirDados();  // Exibe os dados do professor
            System.out.println("ESCOLHA UMA OPCAO");
            System.out.println("1 - EDITAR");
            System.out.println("2 - EXCLUIR");
            System.out.println("3 - SAIR");
            int opcao1 = sc.nextInt();
            sc.nextLine();

            switch (opcao1) {
                case 1:  // Caso o usuário queira editar
                    System.out.println("DIGITE O NOVO NOME DO PROFESSOR");
                    String NovoNome = sc.nextLine();
                    System.out.println("DIGITE A NOVA ESPECIALIDADE DO PROFESSOR");
                    String NovoEspecialidade = sc.nextLine();
                    EditarProfessor(professorEncontrado.getMatriculaProfessor(), NovoNome, NovoEspecialidade);
                    break;
                case 2:  // Caso o usuário queira excluir
                    ExcluirProfessor(professorEncontrado.getMatriculaProfessor());
                    break;
                case 3:  // Caso o usuário queira sair
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        } else {
            System.out.println("PROFESSOR NAO ENCONTRADO!");  // Se o professor não for encontrado
        }
    }

    // Menu de opções para o usuário interagir com a classe Professor
    public static void MenuProfessor(List<Professor> professores) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU DO PROFESSOR");
            System.out.println("1 - Cadastrar PROFESSOR");
            System.out.println("2 - CONSULTAR PROFESSOR");
            System.out.println("3 - SAIR");
            opcao = sc.nextInt();  // Lê a opção escolhida pelo usuário
            sc.nextLine();

            switch (opcao) {
                case 1:  // Cadastrar um novo professor
                    System.out.println("DIGITE O NOME DO PROFESSOR");
                    String nome = sc.nextLine();
                    System.out.println("DIGITE A IDADE DO PROFESSOR");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("DIGITE A MATRICULA DO PROFESSOR");
                    String matriculaProfessor = sc.nextLine();
                    System.out.println("DIGITE A ESPECIALIDADE DO PROFESSOR");
                    String especialidade = sc.nextLine();

                    // Cria um novo objeto Professor e o cadastra
                    Professor novoprofessor = new Professor(nome, idade, matriculaProfessor, especialidade);
                    CadastrarProfessor(novoprofessor);
                    break;

                case 2:  // Consultar um professor
                    ConsultarProfessor();
                    break;
                case 3:  // Sair do menu
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        } while(opcao != 3);  // Continua até o usuário escolher sair
    }
}
