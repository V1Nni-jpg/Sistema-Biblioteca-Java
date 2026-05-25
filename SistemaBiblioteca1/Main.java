import java.util.Scanner;

// Classe principal — ponto de entrada do sistema
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       SISTEMA DE BIBLIOTECA - v1.0       ║");
        System.out.println("╚══════════════════════════════════════════╝");

        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Encerrando o sistema. Até logo!");
        scanner.close();
    }

    // ======================== MENU ========================

    private static void exibirMenu() {
        System.out.println("\n══════════════ MENU PRINCIPAL ══════════════");
        System.out.println("  [1] Cadastrar Livro");
        System.out.println("  [2] Cadastrar Revista");
        System.out.println("  [3] Listar todo o Acervo");
        System.out.println("  [4] Consultar Item por Título");
        System.out.println("  ────────────────────────────────────────");
        System.out.println("  [5] Cadastrar Usuário");
        System.out.println("  [6] Listar Usuários");
        System.out.println("  ────────────────────────────────────────");
        System.out.println("  [7] Realizar Empréstimo");
        System.out.println("  [8] Registrar Devolução");
        System.out.println("  [9] Listar Empréstimos");
        System.out.println("  ────────────────────────────────────────");
        System.out.println("  [0] Sair");
        System.out.println("════════════════════════════════════════════");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarLivro();
            case 2 -> cadastrarRevista();
            case 3 -> biblioteca.listarItens();
            case 4 -> consultarItemPorTitulo();
            case 5 -> cadastrarUsuario();
            case 6 -> biblioteca.listarUsuarios();
            case 7 -> realizarEmprestimo();
            case 8 -> registrarDevolucao();
            case 9 -> biblioteca.listarEmprestimos();
            case 0 -> {} // sair
            default -> System.out.println("✘ Opção inválida. Tente novamente.");
        }
    }

    // ======================== AÇÕES ========================

    private static void cadastrarLivro() {
        System.out.println("\n--- Cadastrar Livro ---");
        String titulo = lerTexto("Título      : ");
        String autor  = lerTexto("Autor       : ");
        int    ano    = lerInt  ("Ano         : ");
        String genero = lerTexto("Gênero      : ");
        int    paginas= lerInt  ("Nº páginas  : ");
        biblioteca.cadastrarLivro(titulo, autor, ano, genero, paginas);
    }

    private static void cadastrarRevista() {
        System.out.println("\n--- Cadastrar Revista ---");
        String titulo      = lerTexto("Título        : ");
        String autor       = lerTexto("Editora/Autor : ");
        int    ano         = lerInt  ("Ano           : ");
        int    edicao      = lerInt  ("Edição Nº     : ");
        String periodicidade = lerTexto("Periodicidade : ");
        biblioteca.cadastrarRevista(titulo, autor, ano, edicao, periodicidade);
    }

    private static void consultarItemPorTitulo() {
        String trecho = lerTexto("Digite parte do título: ");
        biblioteca.consultarItemPorTitulo(trecho);
    }

    private static void cadastrarUsuario() {
        System.out.println("\n--- Cadastrar Usuário ---");
        String nome     = lerTexto("Nome     : ");
        String email    = lerTexto("E-mail   : ");
        String telefone = lerTexto("Telefone : ");
        biblioteca.cadastrarUsuario(nome, email, telefone);
    }

    private static void realizarEmprestimo() {
        System.out.println("\n--- Realizar Empréstimo ---");
        int idUsuario = lerInt("ID do Usuário : ");
        int idItem    = lerInt("ID do Item    : ");
        biblioteca.realizarEmprestimo(idUsuario, idItem);
    }

    private static void registrarDevolucao() {
        int idEmprestimo = lerInt("Número do Empréstimo: ");
        biblioteca.registrarDevolucao(idEmprestimo);
    }

    // ======================== HELPERS ========================

    private static String lerTexto(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int lerInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("✘ Valor inválido. Digite um número inteiro.");
            }
        }
    }
}
