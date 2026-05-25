import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe Emprestimo — registra o vínculo entre usuário e item
public class Emprestimo {

    private int id;
    private Usuario usuario;
    private Item item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private boolean devolvido;

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Emprestimo(int id, Usuario usuario, Item item) {
        this.id = id;
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = LocalDate.now().plusDays(14); // prazo de 14 dias
        this.devolvido = false;
        item.setDisponivel(false); // marca o item como indisponível
    }

    // Getters
    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Item getItem() { return item; }
    public boolean isDevolvido() { return devolvido; }

    // Registra a devolução
    public void registrarDevolucao() {
        this.devolvido = true;
        item.setDisponivel(true);
        System.out.println("✔ Devolução registrada com sucesso!");
    }

    public void exibirInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("Empréstimo Nº : " + id);
        System.out.println("Usuário       : " + usuario.getNome() + " (ID " + usuario.getId() + ")");
        System.out.println("Item          : " + item.getTitulo() + " (" + item.getTipo() + ")");
        System.out.println("Data emprést. : " + dataEmprestimo.format(FORMATO));
        System.out.println("Devolução em  : " + dataDevolucaoPrevista.format(FORMATO));
        System.out.println("Situação      : " + (devolvido ? "Devolvido" : "Em aberto"));
        System.out.println("--------------------------------------------------");
    }
}
