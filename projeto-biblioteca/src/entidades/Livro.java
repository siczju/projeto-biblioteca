package entidades;

import enums.LivroStatus;

public class Livro {
    private Integer id;
    private String nome;
    private String autor;
    private Integer linhas;
    private LivroStatus livroStatus;

    public Livro(String nome, String autor, Integer linhas, Integer id, LivroStatus livroStatus) {
        this.nome = nome;
        this.autor = autor;
        this.linhas = linhas;
        this.id = id;
        this.livroStatus = livroStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LivroStatus getLivroStatus() {
        return livroStatus;
    }

    public void setLivroStatus(LivroStatus livroStatus) {
        this.livroStatus = livroStatus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getLinhas() {
        return linhas;
    }

    public void setLinhas(Integer linhas) {
        this.linhas = linhas;
    }

    @Override
    public String toString() {
        return
                "Nome: " + nome + '\n' +
                "Autor: " + autor + '\n' +
                "Quantidade de linhas: " + linhas + '\n' +
                "Status do livro: " + livroStatus + "\n" +
                "Id: " + id + "\n";
    }
}
