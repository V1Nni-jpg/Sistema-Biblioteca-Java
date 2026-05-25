// Subclasse Revista — herda de Item (Herança)
public class Revista extends Item {

    private int edicao;
    private String periodicidade; // ex: mensal, semanal

    public Revista(int id, String titulo, String autor, int anoPublicacao, int edicao, String periodicidade) {
        super(id, titulo, autor, anoPublicacao);
        this.edicao = edicao;
        this.periodicidade = periodicidade;
    }

    // Getters e Setters
    public int getEdicao() { return edicao; }
    public void setEdicao(int edicao) { this.edicao = edicao; }

    public String getPeriodicidade() { return periodicidade; }
    public void setPeriodicidade(String periodicidade) { this.periodicidade = periodicidade; }

    // Implementação do método abstrato (Polimorfismo)
    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Edição    : " + edicao);
        System.out.println("Periodic. : " + periodicidade);
        System.out.println("--------------------------------------------------");
    }
}
