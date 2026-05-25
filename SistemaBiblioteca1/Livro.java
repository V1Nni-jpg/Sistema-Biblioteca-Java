// Subclasse Livro — herda de Item (Herança)
public class Livro extends Item {

    private String genero;
    private int numeroPaginas;

    public Livro(int id, String titulo, String autor, int anoPublicacao, String genero, int numeroPaginas) {
        super(id, titulo, autor, anoPublicacao); // chama o construtor da superclasse
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
    }

    // Getters e Setters
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }

    // Implementação do método abstrato (Polimorfismo)
    @Override
    public String getTipo() {
        return "Livro";
    }

    // Sobrescreve exibirInfo() adicionando campos específicos
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Gênero    : " + genero);
        System.out.println("Páginas   : " + numeroPaginas);
        System.out.println("--------------------------------------------------");
    }
}
