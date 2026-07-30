package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private LocalDate diaEmprestimo;
    private LocalDate diaVencimento;
    private Livro livro;
    private Pessoa pessoa;

    public Emprestimo(LocalDate diaEmprestimo, LocalDate diaVencimento, Livro livro, Pessoa pessoa) {
        this.diaEmprestimo = diaEmprestimo;
        this.diaVencimento = diaVencimento;
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public LocalDate getDiaEmprestimo() {
        return diaEmprestimo;
    }

    public void setDiaEmprestimo(LocalDate diaEmprestimo) {
        this.diaEmprestimo = diaEmprestimo;
    }

    public LocalDate getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(LocalDate diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return
                "Pessoa que emprestamos: " + pessoa.getNome() + "\n" +
                "Livro emprestado: " + livro.getNome() + "\n" +
                "Dia que ocorreu o emprestimo: " + diaEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "Dia que vai vencer o emprestimo: " + diaVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
    }
}
