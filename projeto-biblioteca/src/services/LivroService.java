package services;

import entidades.Livro;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import enums.LivroStatus;

public class LivroService {

    List<Livro> livros = new ArrayList<>();
    private String path = "C:\\Users\\JúlioCésar\\source\\github\\projeto-biblioteca\\projeto-biblioteca\\src\\arquivos\\livro.csv";

    public int gerarId() {
        int maiorId = 0;

        for (Livro livro : livros) {
            if (livro.getId() > maiorId) {
                maiorId = livro.getId();
            }
        }
        return maiorId + 1;
    }

    public void carregar(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] dados = line.split(";");

                Livro livro = new Livro(
                        dados[0],
                        dados[1],
                        Integer.parseInt(dados[2]),
                        Integer.parseInt(dados[3]),
                        LivroStatus.valueOf(dados[4])
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
                             livro.getId() + ";" +
                             livro.getLivroStatus().name()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removerLivros(Integer id){
        Livro livro = livros.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (livro == null)
            System.out.println("Este livro não existe!");
        else {
            livros.remove(livro);
            System.out.println("Livro excluído com sucesso!");
        }
    }

    public void exibirLivros(){
        for(Livro livro : livros){
            System.out.println(livro);
        }
    }

    public void adicionarLivros(Livro livro){
        livros.add(livro);
    }

    public void removerLivros(int id){
        Livro livro = livros.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

        if (livro == null)
            System.out.println("Este livro não existe!");
        else {
            livros.remove(livro);
            System.out.println("Livro excluído com sucesso!");
        }
    }
}
