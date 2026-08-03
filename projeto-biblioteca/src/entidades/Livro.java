package entidades;

import enums.LivroStatus;

public class Livro {
    private String nome;
    private String autor;
    private Integer paginas;
    private LivroStatus livroStatus;

    public Livro(String nome, String autor, Integer paginas, LivroStatus livroStatus) {
        this.nome = nome;
        this.autor = autor;
        this.paginas = paginas;
        this.livroStatus = livroStatus;
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

    public Integer getPaginas() {
        return paginas;
    }

    public void setLinhas(Integer linhas) {
        this.paginas = linhas;
    }

    @Override
    public String toString() {
        return nome + ", " + autor + ", " + paginas + ", " + livroStatus + "\n";
    }
}
