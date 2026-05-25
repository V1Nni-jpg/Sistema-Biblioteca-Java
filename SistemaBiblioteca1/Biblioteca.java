import java.util.ArrayList;
import java.util.List;

// Classe Biblioteca — gerencia todos os dados e operações do sistema
public class Biblioteca {

    private List<Item> itens;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;
    private int proximoIdItem;
    private int proximoIdUsuario;
    private int proximoIdEmprestimo;

    public Biblioteca() {
        this.itens = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.proximoIdItem = 1;
        this.proximoIdUsuario = 1;
        this.proximoIdEmprestimo = 1;
        carregarDadosIniciais();
    }

    // ======================== ITENS ========================

    public void cadastrarLivro(String titulo, String autor, int ano, String genero, int paginas) {
        Livro livro = new Livro(proximoIdItem++, titulo, autor, ano, genero, paginas);
        itens.add(livro);
        System.out.println("✔ Livro \"" + titulo + "\" cadastrado com sucesso! (ID " + livro.getId() + ")");
    }

    public void cadastrarRevista(String titulo, String autor, int ano, int edicao, String periodicidade) {
        Revista revista = new Revista(proximoIdItem++, titulo, autor, ano, edicao, periodicidade);
        itens.add(revista);
        System.out.println("✔ Revista \"" + titulo + "\" cadastrada com sucesso! (ID " + revista.getId() + ")");
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }
        System.out.println("\n========== ACERVO DA BIBLIOTECA ==========");
        for (Item item : itens) {
            item.exibirInfo();
        }
    }

    public Item buscarItemPorId(int id) {
        for (Item item : itens) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public void consultarItemPorTitulo(String trecho) {
        System.out.println("\n========== RESULTADO DA BUSCA ==========");
        boolean achou = false;
        for (Item item : itens) {
            if (item.getTitulo().toLowerCase().contains(trecho.toLowerCase())) {
                item.exibirInfo();
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum item encontrado com \"" + trecho + "\".");
    }

    // ======================== USUÁRIOS ========================

    public void cadastrarUsuario(String nome, String email, String telefone) {
        Usuario u = new Usuario(proximoIdUsuario++, nome, email, telefone);
        usuarios.add(u);
        System.out.println("✔ Usuário \"" + nome + "\" cadastrado com sucesso! (ID " + u.getId() + ")");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("\n========== USUÁRIOS CADASTRADOS ==========");
        for (Usuario u : usuarios) {
            u.exibirInfo();
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // ======================== EMPRÉSTIMOS ========================

    public void realizarEmprestimo(int idUsuario, int idItem) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Item item = buscarItemPorId(idItem);

        if (usuario == null) { System.out.println("✘ Usuário não encontrado."); return; }
        if (item == null)    { System.out.println("✘ Item não encontrado."); return; }
        if (!item.isDisponivel()) { System.out.println("✘ Item indisponível para empréstimo."); return; }

        Emprestimo emp = new Emprestimo(proximoIdEmprestimo++, usuario, item);
        emprestimos.add(emp);
        System.out.println("✔ Empréstimo Nº " + emp.getId() + " registrado com sucesso!");
    }

    public void registrarDevolucao(int idEmprestimo) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getId() == idEmprestimo && !emp.isDevolvido()) {
                emp.registrarDevolucao();
                return;
            }
        }
        System.out.println("✘ Empréstimo não encontrado ou já devolvido.");
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        System.out.println("\n========== EMPRÉSTIMOS ==========");
        for (Emprestimo emp : emprestimos) {
            emp.exibirInfo();
        }
    }

    // ======================== DADOS INICIAIS ========================

    private void carregarDadosIniciais() {
        // Livros de exemplo
        cadastrarLivro("Dom Casmurro", "Machado de Assis", 1899, "Romance", 256);
        cadastrarLivro("O Cortiço", "Aluísio Azevedo", 1890, "Naturalismo", 304);
        cadastrarLivro("A Moreninha", "Joaquim Manuel de Macedo", 1844, "Romance", 178);

        // Revistas de exemplo
        cadastrarRevista("Scientific American Brasil", "Editora Springer", 2024, 265, "Mensal");
        cadastrarRevista("Superinteressante", "Editora Abril", 2024, 432, "Mensal");

        // Usuários de exemplo
        cadastrarUsuario("Ana Souza", "ana@email.com", "(84) 99999-1111");
        cadastrarUsuario("Carlos Lima", "carlos@email.com", "(84) 98888-2222");
        cadastrarUsuario("Beatriz Ramos", "beatriz@email.com", "(84) 97777-3333");

        System.out.println("\n✔ Dados iniciais carregados com sucesso!\n");
    }
}
