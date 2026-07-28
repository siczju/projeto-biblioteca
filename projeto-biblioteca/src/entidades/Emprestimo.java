package entidades;

import java.time.LocalDate;

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
}
