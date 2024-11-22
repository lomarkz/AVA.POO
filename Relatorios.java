import java.util.List;
import java.util.Scanner;

public class Relatorios {

    public static void GerarRelatorioEstudantes(List<Curso> cursos) {
        System.out.println("Relatorio de Estudantes");

        boolean algumEstudanteMatriculado = false;  // Variável para verificar se há estudantes matriculados

        for (Curso curso : cursos) {
            if (!curso.getEstudantesMatriculados().isEmpty()) {
                System.out.println("CURSO: " + curso.getNomeCurso());
                System.out.println("ESTUDANTES MATRICULADOS: ");
                for (Estudante estudante : curso.getEstudantesMatriculados()) {
                    System.out.println(" - " + estudante.getNome());
                }
                System.out.println("==============================================");
                algumEstudanteMatriculado = true;  // Se encontrar ao menos um estudante, altera a variável
            }
        }

        // Se nenhum estudante foi matriculado em nenhum curso
        if (!algumEstudanteMatriculado) {
            System.out.println("NENHUM Estudante matriculado em CURSOS");
        }
    }


    public static void GerarRelatorioProfessores(List<Professor> professores,List<Curso> cursos){
        System.out.println("Relatorio de Professores");

        boolean professorEncontrado = false;
        for (Curso curso : cursos) {
            Professor professor = curso.getProfessorCurso();
            if(professor != null){
                professorEncontrado = true;
                System.out.println("Professor: " + professor.getNome());
                System.out.println("CURSO ASSOCIADO: " + curso.getNomeCurso());
                System.out.println("========================================");
            }
        }
        if (!professorEncontrado) {
        System.out.println("NENHUM Professor ASSOCIADO A CURSOS");
        }
    }

    public static void MenuRelatorios(List<Curso> cursos, List<Estudante> estudantes ,List<Professor> professores){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU DE RELATÓRIOS");
            System.out.println("1 - Relatório de Estudantes");
            System.out.println("2 - Relatório de Professores");
            System.out.println("3 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    GerarRelatorioEstudantes(cursos);
                    break;
                case 2:
                    GerarRelatorioProfessores(professores,cursos);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }while (opcao != 3);
    }
}
