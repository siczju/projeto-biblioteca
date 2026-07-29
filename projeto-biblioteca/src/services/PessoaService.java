package services;

import entidades.Aluno;
import entidades.Diretor;
import entidades.Pessoa;
import entidades.Professor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private List<Pessoa> pessoas = new ArrayList<>();
    private String path = "C:\\Users\\JúlioCésar\\source\\github\\projeto-biblioteca\\projeto-biblioteca\\src\\arquivos\\pessoa.csv";

    public void carregar() {
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

                    pessoas.add(professor);
                }
                else if (dados[0].equals("ALUNO")) {
                    Aluno aluno = new Aluno(
                            dados[2], // nome
                            dados[3], // email
                            dados[1] // curso
                    );
                    pessoas.add(aluno);
                }
                else if (dados[0].equals("DIRETOR")) {
                        Diretor diretor = new Diretor(
                                dados[1], // nome
                                dados[2] // email
                        );
                    pessoas.add(diretor);
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Pessoa pessoa : pessoas) {
                if (pessoa instanceof Professor)
                    bw.write("PROFESSOR;" + ((Professor) pessoa).getDepartamento() + ";");
                else if(pessoa instanceof Aluno)
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
        Pessoa pessoa = pessoas.stream()
                .filter(x -> x.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (pessoa == null)
            System.out.println("Esta pessoa não existe!");
        else {
            System.out.println(pessoa.getNome() + " excluído (a) com sucesso!");
            pessoas.remove(pessoa);
        }
    }

    public void adicionar(Pessoa professor) {
        pessoas.add(professor);
    }

    public void exibir(char opcao) {
        for (Pessoa pessoa : pessoas) {
            if (opcao == 'a') {
                if (pessoa instanceof Aluno)
                    System.out.println(pessoa);
            }
            else if (opcao == 'p') {
                if (pessoa instanceof Professor)
                    System.out.println(pessoa);
            }
            else {
                if (pessoa instanceof Diretor)
                    System.out.println(pessoa);
            }
        }
    }
}
