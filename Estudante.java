import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estudante extends Pessoa{

    private static List<Estudante> estudantes = new ArrayList<>();

    private String matricula;

    public Estudante(String nome, int idade, String matricula) {
        super(nome,idade);
        this.matricula = matricula;
    }

    public static List<Estudante> getEstudantes() {
        return estudantes;
    }

    public static void setEstudantes(List<Estudante> estudantes) {
        Estudante.estudantes = estudantes;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void ExibirDados() {
        super.ExibirDados();
        System.out.println("Matricula: " + getMatricula());
    }

    public static void CadastrarEstudante(Estudante estudante){
        estudantes.add(estudante);
        System.out.println("Estudante cadastrado com sucesso!");
    }


    public static boolean EditarEstudante(String matricula, String NovoNome,int Novaidade){
        for(Estudante estudante: estudantes){
            if(estudante.getMatricula().equals(matricula)){
                estudante.setNome(NovoNome);
                estudante.setIdade(Novaidade);
                System.out.println("Estudante editado com sucesso!");
                return true;
            }
        }
        System.out.println("Estudante nao encontrado!");
        return false;
    }

    public static boolean ExcluirEstudante(String matriculaExcluir){
        boolean removido = estudantes.removeIf(estudante -> estudante.getMatricula().equals(matriculaExcluir));
        if(removido){
            System.out.println("Estudante removido com sucesso!");
        }else {
            System.out.println("Estudante nao encontrado!");
        }
        return removido;
    }

    public static void ListarEStudantes(){
        if (estudantes.isEmpty()){
            System.out.println("Estudante nao encontrado!");
        }else {
            System.out.println("LISTA DE ESTUDANTES");
            for(Estudante estudante: estudantes){
                estudante.ExibirDados();
            }
        }
    }

    public static void ConsultarEstudante() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o tipo de consulta:");
        System.out.println("1 - Consultar por nome");
        System.out.println("2 - Consultar por matrícula");
        int escolha = sc.nextInt();
        sc.nextLine();  // Consumir o caractere de nova linha

        Estudante estudanteEncontrado = null;

        if (escolha == 1) {
            // Consultar por nome
            System.out.print("Digite o nome do estudante: ");
            String nomeConsulta = sc.nextLine();
            for (Estudante estudante : estudantes) {
                if (estudante.getNome().equalsIgnoreCase(nomeConsulta)) {
                    estudanteEncontrado = estudante;
                    break;
                }
            }
        } else if (escolha == 2) {
            // Consultar por matrícula
            System.out.print("Digite a matrícula do estudante: ");
            String matriculaConsulta = sc.nextLine();
            for (Estudante estudante : estudantes) {
                if (estudante.getMatricula().equals(matriculaConsulta)) {
                    estudanteEncontrado = estudante;
                    break;
                }
            }
        }

        if (estudanteEncontrado != null) {
            // Exibir os dados do estudante encontrado
            estudanteEncontrado.ExibirDados();
            // Oferecer as opções de editar ou excluir
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Editar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Voltar");
            int opcao = sc.nextInt();
            sc.nextLine();  // Consumir o caractere de nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome do estudante: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Digite a nova idade do estudante: ");
                    int novaIdade = sc.nextInt();
                    sc.nextLine();  // Consumir o caractere de nova linha
                    EditarEstudante(estudanteEncontrado.getMatricula(), novoNome, novaIdade);
                    break;
                case 2:
                    ExcluirEstudante(estudanteEncontrado.getMatricula());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }

    public static void MenuEstudante(List<Estudante> estudantes) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU DE ESTUDANTES");
            System.out.println("1 - Cadastrar Estudante");
            System.out.println("2 - CONSULTAR ESTUDANTE");
            System.out.println("3 - SAIR");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Digite o nome do estudante: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o idade do estudante: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o matricula do estudante: ");
                    String matricula = sc.nextLine();

                    Estudante novoEstudante = new Estudante(nome,idade,matricula);
                    CadastrarEstudante(novoEstudante);
                    break;

                case 2:
                    ConsultarEstudante();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("OPCAO INVALIDA. TENTE NOVAMENTE");

            }
        }while (opcao != 3);
    }

}
