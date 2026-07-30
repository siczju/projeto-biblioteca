package entidades;

public class Professor extends Pessoa {
    private String departamento;

    public Professor(String nome, String email, String departamento) {
        super(nome, email);
        this.departamento = departamento;
    }

    @Override
    public int quantidadeDeEmprestimosPossiveis(){
        return 3;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Professor: " + getNome() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Departamento: " + departamento + "\n";
    }
}
