package entidades;

import enums.LivroStatus;

public class Livro {
    private String nome;
    private String autor;
    private Integer linhas;
    private LivroStatus livroStatus;

    public Livro(String nome, String autor, Integer linhas) {
        this.nome = nome;
        this.autor = autor;
        this.linhas = linhas;
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
}
