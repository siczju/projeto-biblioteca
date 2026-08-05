package services;

import entidades.Livro;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.LivroStatus;

public class LivroService {

    private Map<String, Livro> livros = new HashMap<>();
    private final String path = "C:\\Users\\JúlioCésar\\source\\github\\projeto-biblioteca\\projeto-biblioteca\\src\\arquivos\\livro.csv";

    public Livro procurarLivro(String nome) {
        return livros.get(nome);
    }

    public Map<String, Livro> carregar() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] dados = line.split(";");

                Livro livro = new Livro( // Os irmaos karamazov;Dostoiesvki;231;DISPONIVEL
                        dados[0],
                        dados[1],
                        Integer.parseInt(dados[2]),
                        LivroStatus.valueOf(dados[3])
                );

                livros.put(livro.getNome(), livro);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return livros;
    }

    public void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Livro livro : livros.values()) {
                bw.write(livro.getNome() + ";" +
                        livro.getAutor() + ";" +
                        livro.getPaginas() + ";" +
                        livro.getLivroStatus().name()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String nome) {
        Livro livro = livros.get(nome);

        if (livro == null)
            System.out.println("Este livro não existe!");
        else {
            livros.remove(nome);
            System.out.println("Livro excluído com sucesso!");
        }
    }

    public void exibir() {
        livros.values().forEach(System.out::println);
    }

    public void adicionar(Livro livro) {
        livros.put(livro.getNome(), livro);
    }

}
