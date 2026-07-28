package entidades;

public class Professor extends Pessoa {
    private String departamento;

    public Professor(Integer id, String nome, String email, String departamento) {
        super(id, nome, email);
        this.departamento = departamento;
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
                "Departamento: " + departamento + '\n' +
                "Id: " + getId() + "\n";
    }
}
