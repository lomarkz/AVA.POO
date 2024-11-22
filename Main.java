import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        List<Estudante> estudantes = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU");
            System.out.println("1. ALUNO");
            System.out.println("2. PROFESSOR");
            System.out.println("3. CURSO");
            System.out.println("4. RELATORIOS");
            System.out.println("0. Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Estudante.MenuEstudante(estudantes);
                    break;
                case 2:
                    Professor.MenuProfessor(professores);
                    break;
                case 3:
                    Curso.menuCurso(cursos);
                    break;
                case 4:
                    Relatorios.MenuRelatorios(cursos, estudantes, professores);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
                    break;
            }

        }while (opcao != 0);
        sc.close();
    }

}
