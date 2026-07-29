package entidades;

public class Diretor extends Pessoa {

    public Diretor() {
    }

    public Diretor(String nome, String email) {
        super(nome, email);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
                "Email: " + getEmail() + "\n";
    }
}
