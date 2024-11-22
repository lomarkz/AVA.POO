import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Relatorios {

    // Método para gerar relatório de estudantes matriculados em cursos
    public static void GerarRelatorioEstudantes(List<Curso> cursos) {
        if (cursos == null || cursos.isEmpty()) {  // Verifica se a lista de cursos é nula ou vazia
            System.out.println("NENHUM CURSO REGISTRADO!");
            return;  // Encerra a execução do método
        }

        System.out.println("Relatorio de Estudantes");

        boolean algumEstudanteMatriculado = false;  // Variável para verificar se há estudantes matriculados

        // Itera sobre a lista de cursos
        for (Curso curso : cursos) {
            // Verifica se o curso possui estudantes matriculados
            if (!curso.getEstudantesMatriculados().isEmpty()) {
                System.out.println("CURSO: " + curso.getNomeCurso());  // Exibe o nome do curso
                System.out.println("ESTUDANTES MATRICULADOS: ");
                
                // Exibe os nomes dos estudantes matriculados
                for (Estudante estudante : curso.getEstudantesMatriculados()) {
                    System.out.println(" - " + estudante.getNome());
                }

                System.out.println("==============================================");
                algumEstudanteMatriculado = true;  // Marca que encontrou pelo menos um estudante matriculado
            }
        }

        // Caso nenhum estudante esteja matriculado em nenhum curso
        if (!algumEstudanteMatriculado) {
            System.out.println("NENHUM Estudante matriculado em CURSOS");
        }
    }

    // Método para gerar relatório de professores associados a cursos
    public static void GerarRelatorioProfessores(List<Professor> professores, List<Curso> cursos) {
        if (cursos == null || cursos.isEmpty()) {  // Verifica se a lista de cursos é nula ou vazia
            System.out.println("NENHUM CURSO REGISTRADO!");
            return;  // Encerra a execução do método
        }

        System.out.println("Relatorio de Professores");

        boolean professorEncontrado = false;  // Variável para verificar se há professores associados

        // Itera sobre a lista de cursos
        for (Curso curso : cursos) {
            // Obtém o professor associado ao curso
            Professor professor = curso.getProfessorCurso();
            if (professor != null) {  // Verifica se há um professor associado
                professorEncontrado = true;  // Marca que encontrou ao menos um professor
                System.out.println("Professor: " + professor.getNome());  // Exibe o nome do professor
                System.out.println("CURSO ASSOCIADO: " + curso.getNomeCurso());  // Exibe o curso associado
                System.out.println("========================================");
            }
        }

        // Caso nenhum professor esteja associado a nenhum curso
        if (!professorEncontrado) {
            System.out.println("NENHUM Professor ASSOCIADO A CURSOS");
        }
    }

    // Menu interativo para relatórios
    public static void MenuRelatorios(List<Curso> cursos, List<Estudante> estudantes, List<Professor> professores) {
        if (cursos == null || estudantes == null || professores == null) {  // Verifica se alguma lista está nula
            System.out.println("Dados incompletos para gerar relatórios. Verifique os cadastros.");
            return;  // Encerra o método
        }

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            // Exibe as opções do menu
            System.out.println("MENU DE RELATÓRIOS");
            System.out.println("1 - Relatório de Estudantes");
            System.out.println("2 - Relatório de Professores");
            System.out.println("3 - Sair");

            try {
                opcao = sc.nextInt();  // Lê a opção do usuário
                sc.nextLine();  // Limpa o buffer do scanner

                // Processa a opção escolhida
                switch (opcao) {
                    case 1:
                        GerarRelatorioEstudantes(cursos);  // Gera o relatório de estudantes
                        break;
                    case 2:
                        GerarRelatorioProfessores(professores, cursos);  // Gera o relatório de professores
                        break;
                    case 3:
                        System.out.println("Saindo do menu...");
                        break;  // Sai do menu
                    default:
                        System.out.println("OPCAO INVALIDA");  // Opção inválida
                }
            } catch (InputMismatchException e) {  // Trata entradas inválidas
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.nextLine();  // Limpa o buffer do scanner
                opcao = -1;  // Define uma opção inválida para continuar no loop
            }

        } while (opcao != 3);  // Continua no menu até o usuário escolher sair
    }
}
