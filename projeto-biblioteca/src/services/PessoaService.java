package services;

import entidades.Aluno;
import entidades.Pessoa;
import entidades.Professor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private List<Pessoa> pessoas = new ArrayList<>();
    private String path = "C:\\Users\\JúlioCésar\\source\\github\\projeto-biblioteca\\projeto-biblioteca\\src\\arquivos\\pessoa.csv";

    public void carregar(){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while(line != null){
                String[] dados = line.split(";");

                if(dados[0].equals("PROFESSOR")){
                    Professor professor = new Professor(
                            Integer.parseInt(dados[3]), // id
                            dados[2], // nome
                            dados[4], // email
                            dados[1] // departamento
                    );
                pessoas.add(professor);
                }
                else if(dados[0].equals("ALUNO")){
                    Aluno aluno = new Aluno(
                            Integer.parseInt(dados[3]), // id
                            dados[2], // nome
                            dados[4], // email
                            dados[1] // curso
                    );
                pessoas.add(aluno);
                }
                line = br.readLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void salvar(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (Pessoa pessoa : pessoas){
                if(pessoa instanceof Professor)
                    bw.write("PROFESSOR;" + ((Professor) pessoa).getDepartamento() + ";");
                else
                    bw.write("ALUNO;" + ((Aluno) pessoa).getCurso() + ";");

                bw.write(pessoa.getNome() + ";" +
                        pessoa.getId() + ";" +
                        pessoa.getEmail()
                        );
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int gerarId() {
        int maiorId = 0;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() > maiorId) {
                maiorId = pessoa.getId();
            }
        }

        return maiorId + 1;
    }

    public List<Pessoa> getPessoas(){
        carregar();
        return pessoas;
    }

    public void removerProfessor(int id){
        Pessoa pessoa = pessoas.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

        if (pessoa == null)
            System.out.println("Este Professor não existe!");
        else if (pessoa instanceof Aluno)
            System.out.println("É um Aluno, não um Professor!");
        else {
            pessoas.remove(pessoa);
            System.out.println("Professor excluído com sucesso!");
        }
    }

    public void removerAluno(int id){
        Pessoa pessoa = pessoas.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

        if (pessoa == null)
            System.out.println("Este Aluno não existe!");
        else if (pessoa instanceof Professor)
            System.out.println("É um Professor, não um Aluno!");
        else {
            pessoas.remove(pessoa);
            System.out.println("Aluno excluído com sucesso!");
        }
    }

    public void adicionarProfessor(Professor professor){
        pessoas.add(professor);
    }

    public void adicionarAluno(Aluno aluno){
        pessoas.add(aluno);
    }

    public void exibirAluno(){
        for (Pessoa pessoa : pessoas)
            if (pessoa instanceof Aluno)
                System.out.println(pessoa);
    }

    public void exibirProfessor(){
        for (Pessoa pessoa : pessoas)
            if (pessoa instanceof Professor)
                System.out.println(pessoa);
    }
}
