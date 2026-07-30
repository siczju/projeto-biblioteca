package entidades;

import services.ValidacaoEmprestimoService;

public class Pessoa implements ValidacaoEmprestimoService {
    private String nome;
    private String email;

    public Pessoa(){}

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public int quantidadeDeEmprestimosPossiveis() {
        return 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
