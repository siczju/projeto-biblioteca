package entidades;

public class Aluno extends Pessoa {
    private String curso;

    public Aluno(Integer id, String nome, String email, String curso) {
        super(id, nome, email);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno: " + getNome() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Curso: " + curso + '\n' +
                "Id: " + getId() + "\n";
    }
}
