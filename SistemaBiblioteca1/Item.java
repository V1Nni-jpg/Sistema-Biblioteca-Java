// Classe base (superclasse) - demonstra Encapsulamento e serve de base para Herança
public abstract class Item {

    // Atributos privados (Encapsulamento)
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;

    // Construtor
    public Item(int id, String titulo, String autor, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true; // todo item começa disponível
    }

    // Getters e Setters (Encapsulamento)
    public int getId() { return id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    // Método abstrato — cada subclasse deve implementar (Polimorfismo)
    public abstract String getTipo();

    // Método geral de exibição
    public void exibirInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("ID        : " + id);
        System.out.println("Tipo      : " + getTipo());
        System.out.println("Título    : " + titulo);
        System.out.println("Autor     : " + autor);
        System.out.println("Ano       : " + anoPublicacao);
        System.out.println("Situação  : " + (disponivel ? "Disponível" : "Emprestado"));
    }
}
