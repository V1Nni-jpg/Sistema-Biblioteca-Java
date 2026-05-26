[README.md](https://github.com/user-attachments/files/28240677/README.md)
# 📚 Sistema de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em **Java**, simulando operações reais de cadastro de acervo, usuários e controle de empréstimos.

---

## 📋 Descrição do Projeto

O **Sistema de Biblioteca** é uma aplicação de console que permite gerenciar o acervo de uma biblioteca, incluindo livros e revistas, cadastro de usuários e controle completo de empréstimos e devoluções.

O sistema foi desenvolvido aplicando os principais conceitos de **Programação Orientada a Objetos (POO)** exigidos na proposta, utilizando apenas recursos nativos da linguagem Java.

---

## ▶️ Como Executar

### Pré-requisitos
- Java JDK 17 ou superior instalado

### Compilar e rodar
```bash
# Na pasta contendo os arquivos .java
javac *.java
java Main
```

---

## 🗂️ Estrutura do Projeto

```
SistemaBiblioteca/
│
├── Main.java          → Ponto de entrada; menu interativo no console
├── Biblioteca.java    → Gerencia itens, usuários e empréstimos
├── Item.java          → Classe abstrata base do acervo
├── Livro.java         → Subclasse de Item (herança)
├── Revista.java       → Subclasse de Item (herança)
├── Usuario.java       → Representa membros da biblioteca
└── Emprestimo.java    → Registra empréstimos e devoluções
```

---

## 📐 Classes e Responsabilidades

### `Item` — Classe abstrata (superclasse)
Representa qualquer item do acervo. Define os atributos e comportamentos comuns a todos os itens.

**Atributos:** `id`, `titulo`, `autor`, `anoPublicacao`, `disponivel`

**Métodos:** `getTipo()` *(abstrato)*, `exibirInfo()`, getters e setters

---

### `Livro` — Subclasse de Item
Estende `Item` adicionando informações específicas de livros.

**Atributos:** `genero`, `numeroPaginas`

**Métodos:** `getTipo()` → retorna `"Livro"`, `exibirInfo()` *(sobrescrito)*

---

### `Revista` — Subclasse de Item
Estende `Item` adicionando informações específicas de revistas.

**Atributos:** `edicao`, `periodicidade`

**Métodos:** `getTipo()` → retorna `"Revista"`, `exibirInfo()` *(sobrescrito)*

---

### `Usuario`
Representa um membro cadastrado na biblioteca.

**Atributos:** `id`, `nome`, `email`, `telefone`

**Métodos:** `exibirInfo()`, getters e setters

---

### `Emprestimo`
Registra o vínculo entre um `Usuario` e um `Item`. Ao ser criado, marca automaticamente o item como indisponível.

**Atributos:** `id`, `usuario`, `item`, `dataEmprestimo`, `dataDevolucaoPrevista`, `devolvido`

**Métodos:** `registrarDevolucao()`, `exibirInfo()`, getters

---

### `Biblioteca`
Classe gerenciadora central. Mantém as listas de itens, usuários e empréstimos e oferece todos os métodos de operação.

**Métodos principais:** `cadastrarLivro()`, `cadastrarRevista()`, `listarItens()`, `consultarItemPorTitulo()`, `cadastrarUsuario()`, `listarUsuarios()`, `realizarEmprestimo()`, `registrarDevolucao()`, `listarEmprestimos()`

---

### `Main`
Ponto de entrada da aplicação. Responsável pelo menu interativo e pela leitura dos dados do usuário via `Scanner`.

---

## 🧩 Conceitos de POO Aplicados

### 1. Encapsulamento
Todos os atributos das classes são declarados como `private`. O acesso é feito exclusivamente por meio de **getters** e **setters** públicos, protegendo os dados de acessos indevidos.

```java
// Exemplo em Item.java
private String titulo;

public String getTitulo() { return titulo; }
public void setTitulo(String titulo) { this.titulo = titulo; }
```

---

### 2. Herança
`Livro` e `Revista` herdam da classe abstrata `Item`, reutilizando os atributos e métodos comuns e adicionando apenas o que é específico de cada tipo.

```java
public class Livro extends Item {
    // Herda id, titulo, autor, anoPublicacao, disponivel
    // Adiciona: genero, numeroPaginas
}
```

---

### 3. Polimorfismo
O método abstrato `getTipo()` é declarado em `Item` e implementado de forma diferente em cada subclasse. Isso permite tratar `Livro` e `Revista` de forma uniforme como `Item`, enquanto cada um responde com seu próprio tipo.

```java
// Item.java
public abstract String getTipo();

// Livro.java
@Override
public String getTipo() { return "Livro"; }

// Revista.java
@Override
public String getTipo() { return "Revista"; }
```

---

### 4. Abstração
A classe `Item` é abstrata — ela define o "contrato" que todas as subclasses devem cumprir, sem ser instanciada diretamente. O método `exibirInfo()` é sobrescrito nas subclasses para exibir campos específicos de cada tipo.

---

### 5. Criação de Objetos
Objetos são instanciados com o operador `new`, passando os dados pelo construtor:

```java
Livro livro = new Livro(1, "Dom Casmurro", "Machado de Assis", 1899, "Romance", 256);
Emprestimo emp = new Emprestimo(1, usuario, livro);
```

---

## ⚙️ Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| Cadastrar Livro | Registra um novo livro no acervo |
| Cadastrar Revista | Registra uma nova revista no acervo |
| Listar Acervo | Exibe todos os itens cadastrados com situação |
| Consultar por Título | Busca itens pelo título (parcial) |
| Cadastrar Usuário | Registra um novo membro |
| Listar Usuários | Exibe todos os usuários cadastrados |
| Realizar Empréstimo | Vincula um item a um usuário e marca como indisponível |
| Registrar Devolução | Libera o item e marca o empréstimo como encerrado |
| Listar Empréstimos | Exibe todos os empréstimos com data e situação |

---

## 👥 Integrantes do Grupo

- Nome 1
- Nome 2
- Nome 3

---

## 🏫 Informações Acadêmicas

**Disciplina:** Programação Orientada a Objetos  
**Instituição:** UNP SALGADO FILHO **
**Período:** 2025.1
