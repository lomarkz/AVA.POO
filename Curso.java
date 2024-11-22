import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas.
import java.util.List; // Importa a interface List para trabalhar com listas de forma genérica.
import java.util.Scanner; // Importa a classe Scanner para leitura de dados do console.

// Define a classe Curso, que representa um curso com seus atributos e comportamentos.
public class Curso {

    // Declaração de atributos privados da classe.
    private String NomeCurso; // Armazena o nome do curso.
    private int CargaHoraria; // Armazena a carga horária do curso.
    private Professor ProfessorCurso; // Armazena o professor associado ao curso.
    private List<Estudante> EstudantesMatriculados; // Lista de estudantes matriculados no curso.
    private static List<Curso> cursos = new ArrayList<>(); // Lista estática de todos os cursos criados.

    // Construtor que inicializa um curso com nome e carga horária.
    public Curso(String nomeCurso, int cargaHoraria) {
        this.NomeCurso = nomeCurso; // Inicializa o nome do curso.
        this.CargaHoraria = cargaHoraria; // Inicializa a carga horária.
        this.EstudantesMatriculados = new ArrayList<>(); // Inicializa a lista de estudantes matriculados.
    }

    // Métodos *getter* e *setter* para acessar e modificar os atributos privados.

    // Retorna o nome do curso.
    public String getNomeCurso() {
        return NomeCurso;
    }

    // Altera o nome do curso.
    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }

    // Retorna a carga horária do curso.
    public int getCargaHoraria() {
        return CargaHoraria;
    }

    // Altera a carga horária do curso.
    public void setCargaHoraria(int cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    // Retorna o professor associado ao curso.
    public Professor getProfessorCurso() {
        return ProfessorCurso;
    }

    // Associa um professor ao curso.
    public void setProfessorCurso(Professor professorCurso) {
        ProfessorCurso = professorCurso;
    }

    // Retorna a lista de estudantes matriculados.
    public List<Estudante> getEstudantesMatriculados() {
        return EstudantesMatriculados;
    }

    // Matricula um estudante no curso, adicionando-o à lista.
    public void MatricularEstudante(Estudante estudante) {
        EstudantesMatriculados.add(estudante);
    }

    // Remove um estudante da lista de matriculados.
    public void excluirEstudante(Estudante estudante) {
        EstudantesMatriculados.remove(estudante);
    }

    // Exibe os dados do curso no console.
    public void ExibirDadosCurso() {
        System.out.println("Nome: " + NomeCurso); // Exibe o nome do curso.
        System.out.println("Carga Horaria: " + CargaHoraria); // Exibe a carga horária.
        if (ProfessorCurso != null) { // Verifica se há professor associado.
            System.out.println("Professor: " + ProfessorCurso.getNome()); // Exibe o nome do professor.
        }
        System.out.println("Estudantes MATRICULADOS");
        for (Estudante estudante : EstudantesMatriculados) { // Percorre a lista de estudantes.
            System.out.println(" - " + estudante.getNome()); // Exibe o nome de cada estudante.
        }
    }

    // Método estático para cadastrar um novo curso.
    public static void cadastrarCurso() {
        Scanner sc = new Scanner(System.in); // Cria um scanner para leitura de dados do console.
        System.out.println("Digite o nome do curso: ");
        String nomeCurso = sc.nextLine(); // Lê o nome do curso do usuário.
        System.out.println("Digite A CARGA HORARIA DO CURSO: ");
        int cargahoraria = sc.nextInt(); // Lê a carga horária do curso.
        sc.nextLine(); // Limpa o buffer do scanner.

        Curso novoCurso = new Curso(nomeCurso, cargahoraria); // Cria um novo curso com os dados informados.
        cursos.add(novoCurso); // Adiciona o curso à lista de cursos.
        System.out.println("Curso cadastrado com sucesso!");
    }

    // Método estático para consultar um curso pelo nome.
    public static void ConsultarCursos() {
        Scanner sc = new Scanner(System.in); // Cria um scanner para leitura de dados.
        System.out.println("Digite o nome do curso que deseja consultar: ");
        String nomeCurso = sc.nextLine(); // Lê o nome do curso a ser consultado.

        Curso cursoEncontrado = encontrarCurso(nomeCurso); // Busca o curso pelo nome.
        if (cursoEncontrado != null) { // Verifica se o curso foi encontrado.
            cursoEncontrado.ExibirDadosCurso(); // Exibe os dados do curso encontrado.
            System.out.println("ESCOLHA UMA OPCAO");
            System.out.println("1- EDITAR");
            System.out.println("2- EXCLUIR");
            System.out.println("3- voltar");
            int opcao = sc.nextInt(); // Lê a opção do usuário.
            sc.nextLine(); // Limpa o buffer do scanner.

            switch (opcao) {
                case 1:
                    editarCurso(cursoEncontrado); // Edita os dados do curso.
                    break;
                case 2:
                    excluirCurso(cursoEncontrado); // Exclui o curso.
                    break;
                case 3:
                    break; // Volta ao menu anterior.
                default:
                    System.out.println("OPCAO INVALIDA"); // Mensagem de erro para opção inválida.
            }
        } else {
            System.out.println("CURSO NAO ENCONTRADO"); // Mensagem caso o curso não seja encontrado.
        }
    }

    // Métodos para edição, exclusão, vinculação de estudantes e professores, e navegação no menu foram comentados acima.
    // Os mesmos princípios se aplicam a esses métodos. Se precisar de explicações detalhadas, avise!
}
