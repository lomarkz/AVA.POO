import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {   // Classe que representa um curso


    private String NomeCurso;  // Atributo que armazena o nome do curso

    // Atributo que armazena a carga horária do curso
    private int CargaHoraria;

    // Atributo que armazena o professor associado ao curso
    private Professor ProfessorCurso;

    // Lista que armazena os estudantes matriculados no curso
    private List<Estudante> EstudantesMatriculados;

    // Lista estática que armazena todos os cursos criados
    private static List<Curso> cursos = new ArrayList<>();

    // Construtor que inicializa o curso com nome e carga horária
    public Curso(String nomeCurso, int cargaHoraria) {
        this.NomeCurso = nomeCurso;
        this.CargaHoraria = cargaHoraria;
        this.EstudantesMatriculados = new ArrayList<>();
    }

    // Método para obter o nome do curso
    public String getNomeCurso() {
        return NomeCurso;
    }

    // Método para alterar o nome do curso
    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }

    // Método para obter a carga horária do curso
    public int getCargaHoraria() {
        return CargaHoraria;
    }

    // Método para alterar a carga horária do curso
    public void setCargaHoraria(int cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    // Método para obter o professor associado ao curso
    public Professor getProfessorCurso() {
        return ProfessorCurso;
    }

    // Método para associar um professor ao curso
    public void setProfessorCurso(Professor professorCurso) {
        ProfessorCurso = professorCurso;
    }

    // Método para obter a lista de estudantes matriculados
    public List<Estudante> getEstudantesMatriculados() {
        return EstudantesMatriculados;
    }

    // Método para matricular um estudante no curso
    public void MatricularEstudante(Estudante estudante) {
        EstudantesMatriculados.add(estudante);
    }

    // Método para excluir um estudante da lista de matriculados
    public void excluirEstudante(Estudante estudante) {
        EstudantesMatriculados.remove(estudante);
    }

    // Método para exibir os dados do curso
    public void ExibirDadosCurso() {
        System.out.println("Nome: " + NomeCurso);
        System.out.println("Carga Horaria: " + CargaHoraria);
        if (ProfessorCurso != null) { // Verifica se há professor associado
            System.out.println("Professor: " + ProfessorCurso.getNome());
        }
        System.out.println("Estudantes MATRICULADOS");
        for (Estudante estudante : EstudantesMatriculados) { // Itera sobre os estudantes matriculados
            System.out.println(" - " + estudante.getNome());
        }
    }

    // Método estático para cadastrar um novo curso
    public static void cadastrarCurso() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do curso: ");
        String nomeCurso = sc.nextLine();
        System.out.println("Digite A CARGA HORARIA DO CURSO: ");
        int cargahoraria = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner

        Curso novoCurso = new Curso(nomeCurso, cargahoraria); // Cria um novo curso
        cursos.add(novoCurso); // Adiciona o curso à lista estática
        System.out.println("Curso cadastrado com sucesso!");
    }

    // Método estático para consultar um curso pelo nome
    public static void ConsultarCursos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do curso que deseja consultar: ");
        String nomeCurso = sc.nextLine();

        Curso cursoEncontrado = encontrarCurso(nomeCurso); // Busca o curso pelo nome
        if (cursoEncontrado != null) { // Se o curso for encontrado
            cursoEncontrado.ExibirDadosCurso(); // Exibe os dados do curso
            System.out.println("ESCOLHA UMA OPCAO");
            System.out.println("1- EDITAR");
            System.out.println("2- EXCLUIR");
            System.out.println("3- voltar");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do scanner
            switch (opcao) {
                case 1:
                    editarCurso(cursoEncontrado); // Edita o curso
                    break;
                case 2:
                    excluirCurso(cursoEncontrado); // Exclui o curso
                    break;
                case 3:
                    break; // Volta ao menu anterior
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        } else {
            System.out.println("CURSO NAO ENCONTRADO");
        }
    }

    // Método estático para editar os dados de um curso
    public static void editarCurso(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o novo nome do curso: ");
        String NovonomeCurso = sc.nextLine();

        System.out.println("Digite a nova carga horaria do curso: ");
        int Novacargahoraria = sc.nextInt();
        sc.nextLine();

        curso.setNomeCurso(NovonomeCurso); // Atualiza o nome do curso
        curso.setCargaHoraria(Novacargahoraria); // Atualiza a carga horária

        System.out.println("Curso editado com sucesso!");
    }

    // Método estático para excluir um curso
    public static void excluirCurso(Curso curso) {
        cursos.remove(curso); // Remove o curso da lista estática
        System.out.println("Curso removido com sucesso!");
    }

    // Método estático para vincular um estudante ao curso
    public static void VincularEstudante(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do estudante a ser matriculado: ");
        String nomeEstudante = sc.nextLine();

        Estudante estudanteEncontrado = null;
        for (Estudante estudante : Estudante.getEstudantes()) { // Busca o estudante pelo nome
            if (estudante.getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudante;
                break;
            }
        }

        if (estudanteEncontrado != null) {
            curso.MatricularEstudante(estudanteEncontrado); // Matricula o estudante no curso
            System.out.println("Estudante matriculado com sucesso!");
        } else {
            System.out.println("ESTUDANTE NAO ENCONTRADO");
        }
    }

    // Método estático para vincular um professor ao curso
    public static void VincularProfessor(Curso curso) {
        Scanner sc = new Scanner(System.in);

        System.out.println("DIGITE O NOME DO PROFESSOR A SER VINCULADO AO CURSO");
        String nomeProfessor = sc.nextLine();

        Professor professorEncontrado = null;
        for (Professor professor : Professor.getProfessores()) { // Busca o professor pelo nome
            if (professor.getNome().equals(nomeProfessor)) {
                professorEncontrado = professor;
                break;
            }
        }
        if (professorEncontrado != null) {
            curso.setProfessorCurso(professorEncontrado); // Associa o professor ao curso
            System.out.println("Professor VINCULADO com sucesso!");
        } else {
            System.out.println("PROFESSOR NAO ENCONTRADO");
        }
    }

    // Método estático para exibir o menu de cursos
    public static void menuCurso(List<Curso> cursos) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU CURSO");
            System.out.println("1 - Cadastrar Curso");
            System.out.println("2 - Consultar Curso");
            System.out.println("3 - Vinculação");
            System.out.println("4 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCurso(); // Chama o método para cadastrar um curso
                    break;
                case 2:
                    ConsultarCursos(); // Chama o método para consultar cursos
                    break;
                case 3:
                    System.out.println("Escolha uma opção de vinculação:");
                    System.out.println("1 - Matricular Estudante");
                    System.out.println("2 - Associar Professor");
                    int vinculoOpcao = sc.nextInt();
                    sc.nextLine();

                    if (vinculoOpcao == 1) {
                        System.out.println("Digite o nome do curso para vincular o estudante:");
                        String nomeCurso = sc.nextLine();
                        Curso curso = encontrarCurso(nomeCurso); // Busca o curso
                        if (curso != null) {
                            VincularEstudante(curso); // Vincula o estudante
                        } else {
                            System.out.println("Curso não encontrado.");
                        }
                    } else if (vinculoOpcao == 2) {
                        System.out.println("Digite o nome do curso para associar o professor:");
                        String nomeCurso2 = sc.nextLine();
                        Curso curso = encontrarCurso(nomeCurso2);
                        if (curso != null) {
                            VincularProfessor(curso); // Vincula o professor
                        } else {
                            System.out.println("Curso não encontrado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4); // Mantém o menu ativo até a opção de sair ser escolhida
    }

    // Método estático para encontrar um curso pelo nome
    public static Curso encontrarCurso(String nomeCurso) {
        for (Curso curso : cursos) { // Itera sobre os cursos disponíveis
            if (curso.getNomeCurso().equals(nomeCurso)) {
                return curso; // Retorna o curso encontrado
            }
        }
        return null; // Retorna nulo se o curso não for encontrado
    }
}
