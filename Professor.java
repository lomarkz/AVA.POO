import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor extends Pessoa{

    private static List<Professor> professores = new ArrayList<>();

    private String especialidade;
    private String matriculaProfessor;

    public Professor(String nome, int idade, String matriculaProfessor, String especialidade) {
        super(nome, idade);
        this.matriculaProfessor = matriculaProfessor;
        this.especialidade = especialidade;
    }

    public static List<Professor> getProfessores() {
        return professores;
    }

    public static void setProfessores(List<Professor> professores) {
        Professor.professores = professores;
    }

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

    @Override
    public void ExibirDados() {
        super.ExibirDados();
        System.out.println("Matricula: " + getMatriculaProfessor());
        System.out.println("Especialidade: " + getEspecialidade());
    }

    public static void CadastrarProfessor(Professor professor) {
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public static boolean EditarProfessor(String matriculaProfessor,String NovoNome,String NovoEspecialidade) {
        for (Professor professor : professores) {
            if (professor.getMatriculaProfessor().equals(matriculaProfessor)) {
                professor.setNome(NovoNome);
                professor.setEspecialidade(NovoEspecialidade);
                System.out.println("Professor editado com sucesso!");
                return true;
            }
        }
        System.out.println("Professor NAO ENCONTRADO!");
        return false;
    }

    public static boolean ExcluirProfessor(String matriculaProfessor) {
        boolean removido = professores.removeIf(professor -> professor.getMatriculaProfessor().equals(matriculaProfessor));
        if (removido) {
            System.out.println("Professor excluido com sucesso!");

        }else {
            System.out.println("Professor NAO ENCONTRADO!");
        }
        return removido;
    }

    public static void ListarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Professor NAO ENCONTRADO!");
        }else {
        System.out.println("LISTA DE PROFESSORES!");
            for (Professor professor : professores) {
                professor.ExibirDados();
            }
        }
    }

    public static void ConsultarProfessor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o tipo de consulta:");
        System.out.println("1 - Consultar por nome");
        System.out.println("2 - Consultar por matrícula");
        int opcao = sc.nextInt();
        sc.nextLine();

        Professor professorEncontrado = null;

        if (opcao == 1) {
            System.out.println("DIGITE O NOME DO PROFESSOR");
            String nome = sc.nextLine();
            for (Professor professor : professores) {
                if (professor.getNome().equals(nome)) {
                    professorEncontrado = professor;
                    break;
                }
            }
        }

        if (opcao == 2) {
            System.out.println("DIGITE O MATRICULA DO PROFESSOR");
            String matricula = sc.nextLine();
            for (Professor professor : professores) {
                if (professor.getMatriculaProfessor().equals(matricula)) {
                    professorEncontrado = professor;
                    break;
                }
            }
        }

        if(professorEncontrado != null) {
            professorEncontrado.ExibirDados();
            System.out.println("ESCOLHA UMA OPCAO");
            System.out.println("1 - EDITAR");
            System.out.println("2 - EXCLUIR");
            System.out.println("3 - SAIR");
            int opcao1 = sc.nextInt();
            sc.nextLine();

            switch (opcao1) {
                case 1:
                    System.out.println("DIGITE O NOVO NOME DO PROFESSOR");
                    String NovoNome = sc.nextLine();
                    System.out.println("DIGITE A NOVA ESPECIALIDADE DO PROFESSOR");
                    String NovoEspecialidade = sc.nextLine();
                    EditarProfessor(professorEncontrado.getMatriculaProfessor(), NovoNome, NovoEspecialidade);
                    break;
                case 2:
                    ExcluirProfessor(professorEncontrado.getMatriculaProfessor());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }else {
            System.out.println("PROFESSOR NAO ENCONTRADO!");
        }
    }

    public static void MenuProfessor(List<Professor> professores) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU DO PROFESSOR");
            System.out.println("1 - Cadastrar PROFESSOR");
            System.out.println("2 - CONSULTAR PROFESSOR");
            System.out.println("3 - SAIR");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("DIGITE O NOME DO PROFESSOR");
                    String nome = sc.nextLine();
                    System.out.println("DIGITE A IDADE DO PROFESSOR");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("DIGITE A MATRICULA DO PROFESSOR");
                    String matriculaProfessor = sc.nextLine();
                    System.out.println("DIGITE A ESPECIALIDADE DO PROFESSOR");
                    String especialidade = sc.nextLine();

                    Professor novoprofessor = new Professor(nome, idade, matriculaProfessor, especialidade);
                    CadastrarProfessor(novoprofessor);
                    break;

                case 2:
                    ConsultarProfessor();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }while(opcao != 3);
    }

}








































