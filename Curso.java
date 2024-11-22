import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {

    private String NomeCurso;
    private int CargaHoraria;
    private Professor ProfessorCurso;
    private List<Estudante> EstudantesMatriculados;
    private static List<Curso> cursos = new ArrayList<>();

    public Curso(String nomeCurso, int cargaHoraria) {
        this.NomeCurso = nomeCurso;
        this.CargaHoraria = cargaHoraria;
        this.EstudantesMatriculados = new ArrayList<>();
    }

    public String getNomeCurso() {
        return NomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public Professor getProfessorCurso() {
        return ProfessorCurso;
    }

    public void setProfessorCurso(Professor professorCurso) {
        ProfessorCurso = professorCurso;
    }

    public List<Estudante> getEstudantesMatriculados() {
        return EstudantesMatriculados;
    }

    public void MatricularEstudante(Estudante estudante) {
        EstudantesMatriculados.add(estudante);
    }

    public void excluirEstudante(Estudante estudante) {
        EstudantesMatriculados.remove(estudante);
    }

    public void ExibirDadosCurso() {
        System.out.println("Nome: " + NomeCurso);
        System.out.println("Carga Horaria: " + CargaHoraria);
        if (ProfessorCurso != null) {
            System.out.println("Professor: " + ProfessorCurso.getNome());
        }
        System.out.println("Estudantes MATRICULADOS");
        for (Estudante estudante : EstudantesMatriculados) {
            System.out.println(" - " + estudante.getNome());
        }
    }

    public static void cadastrarCurso() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do curso: ");
        String nomeCurso = sc.nextLine();
        System.out.println("Digite A CARGA HORARIA DO CURSO: ");
        int cargahoraria = sc.nextInt();
        sc.nextLine();

        Curso novoCurso = new Curso(nomeCurso, cargahoraria);
        cursos.add(novoCurso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public static void ConsultarCursos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do curso que deseja consultar: ");
        String nomeCurso = sc.nextLine();

        Curso cursoEncontrado = encontrarCurso(nomeCurso);
        if (cursoEncontrado != null) {
            cursoEncontrado.ExibirDadosCurso();
            System.out.println("ESCOLHA UMA OPCAO");
            System.out.println("1- EDITAR");
            System.out.println("2- EXCLUIR");
            System.out.println("3- voltar");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    editarCurso(cursoEncontrado);
                    break;
                case 2:
                    excluirCurso(cursoEncontrado);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        } else {
            System.out.println("CURSO NAO ENCONTRADO");
        }
    }

    public static void editarCurso(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o novo nome do curso: ");
        String NovonomeCurso = sc.nextLine();

        System.out.println("Digite a nova carga horaria do curso: ");
        int Novacargahoraria = sc.nextInt();
        sc.nextLine();

        curso.setNomeCurso(NovonomeCurso);
        curso.setCargaHoraria(Novacargahoraria);

        System.out.println("Curso editado com sucesso!");
    }

    public static void excluirCurso(Curso curso) {
        cursos.remove(curso);
        System.out.println("Curso removido com sucesso!");
    }

    public static void VincularEstudante(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do estudante a ser matriculado: ");
        String nomeEstudante = sc.nextLine();

        Estudante estudanteEncontrado = null;
        for (Estudante estudante : Estudante.getEstudantes()) {
            if (estudante.getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudante;
                break;
            }
        }

        if (estudanteEncontrado != null) {
            curso.MatricularEstudante(estudanteEncontrado);
            System.out.println("Estudante matriculado com sucesso!");
        } else {
            System.out.println("ESTUDANTE NAO ENCONTRADO");
        }
    }

    public static void VincularProfessor(Curso curso) {
        Scanner sc = new Scanner(System.in);

        System.out.println("DIGITE O NOME DO PROFESSOR A SER VINCULADO AO CURSO");
        String nomeProfessor = sc.nextLine();

        Professor professorEncontrado = null;
        for (Professor professor : Professor.getProfessores()) {
            if (professor.getNome().equals(nomeProfessor)) {
                professorEncontrado = professor;
                break;
            }
        }
        if (professorEncontrado != null) {
            curso.setProfessorCurso(professorEncontrado);
            System.out.println("Professor VINCULADO com sucesso!");
        } else {
            System.out.println("PROFESSOR NAO ENCONTRADO");
        }
    }

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
                    cadastrarCurso();
                    break;
                case 2:
                    ConsultarCursos();
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
                        Curso curso = encontrarCurso(nomeCurso);
                        if (curso != null) {
                            VincularEstudante(curso);
                        } else {
                            System.out.println("Curso não encontrado.");
                        }
                    } else if (vinculoOpcao == 2) {
                        System.out.println("Digite o nome do curso para associar o professor:");
                        String nomeCurso2 = sc.nextLine();
                        Curso curso = encontrarCurso(nomeCurso2);
                        if (curso != null) {
                            VincularProfessor(curso);
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
        } while (opcao != 4);
    }

    public static Curso encontrarCurso(String nomeCurso) {
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equals(nomeCurso)) {
                return curso;
            }
        }
        return null;
    }
}
