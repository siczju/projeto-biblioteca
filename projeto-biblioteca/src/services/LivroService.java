package services;

import entidades.Livro;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import enums.LivroStatus;

public class LivroService {

    List<Livro> livros = new ArrayList<>();
    private String path = "C:\\Users\\JúlioCésar\\source\\github\\projeto-biblioteca\\projeto-biblioteca\\src\\arquivos\\livro.csv";

    public void carregar(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] dados = line.split(";");

                Livro livro = new Livro(
                        dados[0],
                        dados[1],
                        Integer.parseInt(dados[2]),
                        LivroStatus.valueOf(dados[3])
                );

                livros.add(livro);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void salvar(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Livro livro: livros) {
                bw.write(livro.getNome() + ";" +
                             livro.getAutor() + ";" +
                             livro.getLinhas() + ";" +
                             livro.getLivroStatus().name()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String nome){
        Livro livro = livros.stream()
                .filter(x -> x.getNome().equals(nome))
                .findFirst()
                .orElse(null);

        if (livro == null)
            System.out.println("Este livro não existe!");
        else {
            livros.remove(livro);
            System.out.println("Livro excluído com sucesso!");
        }
    }

    public void exibir(){
        for(Livro livro : livros){
            System.out.println(livro);
        }
    }

    public void adicionar(Livro livro){
        livros.add(livro);
    }

}
