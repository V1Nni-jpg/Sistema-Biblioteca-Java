// Classe Usuario — representa os usuários da biblioteca
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String telefone;

    public Usuario(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters (Encapsulamento)
    public int getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public void exibirInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("ID        : " + id);
        System.out.println("Nome      : " + nome);
        System.out.println("E-mail    : " + email);
        System.out.println("Telefone  : " + telefone);
        System.out.println("--------------------------------------------------");
    }
}
