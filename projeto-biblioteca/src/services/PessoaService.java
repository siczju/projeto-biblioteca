package services;

import entidades.Aluno;
import entidades.Diretor;
import entidades.Pessoa;
import entidades.Professor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoaService {
    private Map<String, Pessoa> pessoas = new HashMap<>();
    private final String path = "C:\\Users\\JúlioCésar\\source\\github\\projeto-biblioteca\\projeto-biblioteca\\src\\arquivos\\pessoa.csv";

    public Pessoa procurarPessoa(String email) {
        return pessoas.get(email);
    }

    public Map<String, Pessoa> carregar() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] dados = line.split(";");

                if (dados[0].equals("PROFESSOR")) {
                    Professor professor = new Professor(
                            dados[2], // nome
                            dados[3], // email
                            dados[1] // departamento
                    );

                    pessoas.put(professor.getEmail(), professor);

                } else if (dados[0].equals("ALUNO")) {
                    Aluno aluno = new Aluno(
                            dados[2], // nome
                            dados[3], // email
                            dados[1] // curso
                    );

                    pessoas.put(aluno.getEmail(), aluno);

                } else if (dados[0].equals("DIRETOR")) {
                    Diretor diretor = new Diretor(
                            dados[1], // nome
                            dados[2] // email
                    );
                    pessoas.put(diretor.getEmail(), diretor);
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Pessoa pessoa : pessoas.values()) {
                if (pessoa instanceof Professor)
                    bw.write("PROFESSOR;" + ((Professor) pessoa).getDepartamento() + ";");
                else if (pessoa instanceof Aluno)
                    bw.write("ALUNO;" + ((Aluno) pessoa).getCurso() + ";");
                else
                    bw.write("DIRETOR;");

                bw.write(pessoa.getNome() + ";" +
                        pessoa.getEmail()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String email) {
        Pessoa pessoa = pessoas.get(email);

        if (pessoa == null)
            System.out.println("Esta pessoa não existe!");
        else {
            System.out.println(pessoa.getNome() + " excluído (a) com sucesso!");
            pessoas.remove(email);
        }
    }

    public void adicionar(Pessoa professor) {
        if(pessoas.containsKey(professor.getEmail()))
            System.out.println("Esse professor ja existe!");
        else
            pessoas.put(professor.getEmail(), professor);
    }

    public void exibir(char opcao) {
        for (Pessoa pessoa : pessoas.values()) {
            if (opcao == 'a') {
                if (pessoa instanceof Aluno)
                    System.out.println(pessoa);
            } else if (opcao == 'p') {
                if (pessoa instanceof Professor)
                    System.out.println(pessoa);
            } else {
                if (pessoa instanceof Diretor)
                    System.out.println(pessoa);
            }
        }
    }
}
