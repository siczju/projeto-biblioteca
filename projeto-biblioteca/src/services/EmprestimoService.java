package services;

import entidades.Emprestimo;
import entidades.Livro;
import entidades.Pessoa;
import enums.LivroStatus;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {
    List<Emprestimo> emprestimos = new ArrayList<>();
    private String path = "C:\\Users\\JúlioCésar\\source\\github\\projeto-biblioteca\\projeto-biblioteca\\src\\arquivos\\emprestimo.csv";

    public void carregar(List<Pessoa> pessoas, List<Livro> livros){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while(line != null){
                String[] dados = line.split(";");
                LocalDate diaEmprestimo = LocalDate.parse(dados[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate diaVencimento = LocalDate.parse(dados[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                Pessoa pessoa = pessoas.stream().filter(p -> p.getEmail() == dados[0]).findFirst().orElse(null);
                Livro livro = livros.stream().filter(l -> l.getNome() == dados[1]).findFirst().orElse(null);

                emprestimos.add(new Emprestimo(diaEmprestimo, diaVencimento, livro, pessoa));

                line = br.readLine();
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvar(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (Emprestimo emprestimo : emprestimos) { // email/livro/dataEmprestimo/dataVencimento
                String email = emprestimo.getPessoa().getEmail();
                String nomeLivro = emprestimo.getLivro().getNome();
                bw.write(email + ";" +
                        nomeLivro + ";" +
                        emprestimo.getDiaEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" +
                        emprestimo.getDiaVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                );
                    bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibir(){
        for(Emprestimo emprestimo : emprestimos){
            System.out.println(emprestimo);
        }
    }

    public void emprestar(Pessoa pessoa, Livro livro){
        LocalDate diaVencimento = LocalDate.now().plusDays(5);
        if(livro == null)
            System.out.println("Não emprestado pois livro não existe.");
        else if (pessoa == null)
            System.out.println("Não emprestado pois pessoa não existe");
        else {
            livro.setLivroStatus(LivroStatus.EMPRESTADO);
            emprestimos.add(new Emprestimo(LocalDate.now(), diaVencimento, livro, pessoa));
            System.out.println("Livro emprestado!");
        }
    }

    public void devolver(String nomeDoLivro){
        Emprestimo emprestimoDevolvido = emprestimos
                .stream().
                filter(e -> e.getLivro().getNome().equals(nomeDoLivro)).
                findFirst().orElse(null);

        if(emprestimoDevolvido != null) {
            emprestimoDevolvido.getLivro().setLivroStatus(LivroStatus.DISPONIVEL);
            System.out.println("\nEmprestimo devolvido!");
        }
        else
            System.out.println("\nEste livro não foi emprestado!!");
    }

}
