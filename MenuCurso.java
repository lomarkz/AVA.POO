import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas.
import java.util.List; // Importa a interface List para trabalhar com listas genéricas.
import java.util.Scanner; // Importa a classe Scanner para receber entrada do usuário.

// Declaração da classe MenuCurso, responsável por gerenciar operações relacionadas a cursos.
public class MenuCurso {
    // Lista estática para armazenar os cursos cadastrados.
    private static List<Curso> cursos = new ArrayList<>();

    // Método para cadastrar um novo curso.
    public static void cadastrarCurso() {
        Scanner sc = new Scanner(System.in); // Inicializa o Scanner para entrada de dados.
        System.out.println("Digite o nome do curso: "); 
        String nomeCurso = sc.nextLine(); // Lê o nome do curso.
        System.out.println("Digite A CARGA HORARIA DO CURSO: ");
        int cargahoraria = sc.nextInt(); // Lê a carga horária do curso.
        sc.nextLine(); // Limpa o buffer do Scanner.

        // Cria um novo objeto Curso com os dados fornecidos.
        Curso novoCurso = new Curso(nomeCurso, cargahoraria);
        cursos.add(novoCurso); // Adiciona o curso à lista.
        System.out.println("Curso cadastrado com sucesso!");
    }

    // Método para consultar cursos pelo nome.
    public static void ConsultarCursos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do curso que deseja consultar: ");
        String nomeCurso = sc.nextLine(); // Lê o nome do curso a ser pesquisado.

        Curso cursoEncontrado = null; // Variável para armazenar o curso encontrado.
        // Busca pelo curso na lista.
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equals(nomeCurso)) {
                cursoEncontrado = curso;
                break;
            }
        }

        // Caso o curso seja encontrado.
        if (cursoEncontrado != null) {
            cursoEncontrado.ExibirDadosCurso(); // Exibe os dados do curso.
            System.out.println("ESCOLHA UMA OPCAO");
            System.out.println("1- EDITAR");
            System.out.println("2- EXCLUIR");
            System.out.println("3- voltar");
            int opcao = sc.nextInt(); // Lê a opção do usuário.
            sc.nextLine(); // Limpa o buffer.

            // Realiza a ação escolhida.
            switch (opcao) {
                case 1:
                    editarCurso(cursoEncontrado); // Edita o curso.
                    break;
                case 2:
                    excluirCurso(cursoEncontrado); // Exclui o curso.
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

    // Método para editar um curso.
    public static void editarCurso(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o novo nome do curso: ");
        String NovonomeCurso = sc.nextLine(); // Lê o novo nome do curso.
        System.out.println("Digite a nova carga horaria do curso: ");
        int Novacargahoraria = sc.nextInt(); // Lê a nova carga horária.
        sc.nextLine(); // Limpa o buffer.

        // Atualiza os dados do curso.
        curso.setNomeCurso(NovonomeCurso);
        curso.setCargaHoraria(Novacargahoraria);

        System.out.println("Curso editado com sucesso!");
    }

    // Método para excluir um curso da lista.
    public static void excluirCurso(Curso curso) {
        cursos.remove(curso); // Remove o curso da lista.
        System.out.println("Curso removido com sucesso!");
    }

    // Método para matricular um estudante em um curso.
    public static void VincularEstudante(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do estudante a ser matriculado: ");
        String nomeEstudante = sc.nextLine(); // Lê o nome do estudante.

        Estudante estudanteEncontrado = null; // Variável para armazenar o estudante encontrado.
        // Busca pelo estudante na lista global de estudantes.
        for (Estudante estudante : Estudante.getEstudantes()) {
            if (estudante.getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudante;
                break;
            }
        }

        if (estudanteEncontrado != null) {
            curso.MatricularEstudante(estudanteEncontrado); // Matricula o estudante no curso.
            System.out.println("Estudante matriculado com sucesso!");
        } else {
            System.out.println("ESTUDANTE NAO ENCONTRADO");
        }
    }

    // Método para associar um professor a um curso.
    public static void VincularProfessor(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("DIGITE O NOME DO PROFESSOR A SER VINCULADO AO CURSO");
        String nomeProfessor = sc.nextLine(); // Lê o nome do professor.

        Professor professorEncontrado = null; // Variável para armazenar o professor encontrado.
        // Busca pelo professor na lista global de professores.
        for (Professor professor : Professor.getProfessores()) {
            if (professor.getNome().equals(nomeProfessor)) {
                professorEncontrado = professor;
                break;
            }
        }

        if (professorEncontrado != null) {
            curso.setProfessorCurso(professorEncontrado); // Vincula o professor ao curso.
            System.out.println("Professor VINCULADO com sucesso!");
        } else {
            System.out.println("PROFESSOR NAO ENCONTRADO");
        }
    }

    // Menu principal para operações relacionadas a cursos.
    public static void menuCurso(List<Curso> cursos) {
        Scanner sc = new Scanner(System.in);
        int opcao; // Variável para armazenar a escolha do menu.

        do {
            System.out.println("MENU CURSO");
            System.out.println("1 - Cadastrar Curso");
            System.out.println("2 - Consultar Curso");
            System.out.println("3 - Vinculação");
            System.out.println("4 - Sair");
            opcao = sc.nextInt(); // Lê a opção escolhida.
            sc.nextLine(); // Limpa o buffer.

            switch (opcao) {
                case 1:
                    cadastrarCurso(); // Cadastra um novo curso.
                    break;
                case 2:
                    ConsultarCursos(); // Consulta cursos.
                    break;
                case 3:
                    // Menu de opções para vinculação.
                    System.out.println("Escolha uma opção de vinculação:");
                    System.out.println("1 - Matricular Estudante");
                    System.out.println("2 - Associar Professor");
                    int vinculoOpcao = sc.nextInt(); // Lê a opção.
                    sc.nextLine(); // Limpa o buffer.

                    if (vinculoOpcao == 1) {
                        System.out.println("Digite o nome do curso para vincular o estudante:");
                        String nomeCurso = sc.nextLine();
                        Curso curso = encontrarCurso(nomeCurso); // Busca o curso.
                        if (curso != null) {
                            VincularEstudante(curso); // Vincula o estudante ao curso.
                        } else {
                            System.out.println("Curso não encontrado.");
                        }
                    } else if (vinculoOpcao == 2) {
                        System.out.println("Digite o nome do curso para associar o professor:");
                        String nomeCurso2 = sc.nextLine();
                        Curso curso = encontrarCurso(nomeCurso2); // Busca o curso.
                        if (curso != null) {
                            VincularProfessor(curso); // Vincula o professor ao curso.
                        } else {
                            System.out.println("Curso não encontrado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo..."); // Sai do menu.
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4); // O loop continua até que a opção 4 seja escolhida.
    }

    // Método auxiliar para encontrar um curso pelo nome.
    public static Curso encontrarCurso(String nomeCurso) {
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equals(nomeCurso)) {
                return curso; // Retorna o curso encontrado.
            }
        }
        return null; // Retorna null se não encontrar o curso.
    }
}
