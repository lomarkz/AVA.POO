import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas.
import java.util.List; // Importa a interface List para trabalhar com listas genéricas.
import java.util.Scanner; // Importa a classe Scanner para receber entrada do usuário.

// Declaração da classe principal Main.
public class Main {
    // Método principal que inicia a execução do programa.
    public static void main(String[] args) {
        // Cria listas dinâmicas para armazenar os cursos, estudantes e professores.
        List<Curso> cursos = new ArrayList<>(); // Lista de cursos.
        List<Estudante> estudantes = new ArrayList<>(); // Lista de estudantes.
        List<Professor> professores = new ArrayList<>(); // Lista de professores.

        // Inicializa o Scanner para leitura de entrada do usuário.
        Scanner sc = new Scanner(System.in);
        int opcao; // Variável para armazenar a opção escolhida no menu.

        // Estrutura de repetição para exibir o menu até que o usuário escolha sair.
        do {
            // Exibe o menu principal.
            System.out.println("MENU");
            System.out.println("1. ALUNO");
            System.out.println("2. PROFESSOR");
            System.out.println("3. CURSO");
            System.out.println("4. RELATORIOS");
            System.out.println("0. Sair");

            // Lê a opção escolhida pelo usuário.
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do Scanner.

            // Switch para executar a ação correspondente à opção escolhida.
            switch (opcao) {
                case 1:
                    // Chama o menu de gestão de estudantes (classe Estudante).
                    Estudante.MenuEstudante(estudantes);
                    break;
                case 2:
                    // Chama o menu de gestão de professores (classe Professor).
                    Professor.MenuProfessor(professores);
                    break;
                case 3:
                    // Chama o menu de gestão de cursos (classe Curso).
                    Curso.menuCurso(cursos);
                    break;
                case 4:
                    // Chama o menu de relatórios (classe Relatorios).
                    Relatorios.MenuRelatorios(cursos, estudantes, professores);
                    break;
                case 0:
                    // Sai do programa.
                    break;
                default:
                    // Exibe uma mensagem de erro caso a opção seja inválida.
                    System.out.println("OPCAO INVALIDA");
                    break;
            }

        } while (opcao != 0); // O loop continua enquanto o usuário não escolher a opção 0.

        // Fecha o Scanner para liberar recursos.
        sc.close();
    }
}
