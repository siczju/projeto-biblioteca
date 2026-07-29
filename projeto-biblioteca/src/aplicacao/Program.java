package aplicacao;

import entidades.Aluno;
import entidades.Livro;
import entidades.Professor;
import enums.LivroStatus;
import services.LivroService;
import services.PessoaService;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static PessoaService pessoaService = new PessoaService();
    public static LivroService livroService = new LivroService();

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        pessoaService.carregar();
        livroService.carregar();

        while (true) {

            int opcao = menuPrincipal(scanner);

            if (opcao == 0) {
                scanner.close();
                pessoaService.salvar();
                livroService.salvar();
                break;
            }
            else if (opcao == 1) {
                menuPessoas(scanner);
            }
            else if (opcao == 2) {
                menuLivros(scanner);
            }
            else
                System.out.println("Essa opção não existe.");
        }
    }

    private static int menuPrincipal(Scanner sc) {
        System.out.println("------------------MENU------------------");
        System.out.println("\t1 - Pessoas");
        System.out.println("\t2 - Livros");
        System.out.println("\t3 - Pegar emprestado");
        System.out.println("\t0 - Sair/Salvar");
        System.out.print("\nOpção: ");

        int opcao = sc.nextInt();
        sc.nextLine(); // limpa o enter

        return opcao;
    }

    public static void menuLivros(Scanner sc){
        System.out.println("\n------LIVROS------");
        System.out.println("\t1 - Listar");
        System.out.println("\t2 - Adicionar");
        System.out.println("\t3 - Remover");
        System.out.println("\t0 - Sair");
        System.out.print("\nOpção: ");

        int opcao = sc.nextInt();
        sc.nextLine();
        if(opcao == 0)
            return;
        else if(opcao == 1) {
            System.out.println("\nExibir livros:\n");
            livroService.exibirLivros();
        }
        else if(opcao == 2){
            System.out.println("\nAdicionar livro\n");

            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("Quantidade de linhas: ");
            int qtdLinha = sc.nextInt();
            sc.nextLine();

            System.out.print("Status do livro (EMPRESTADO/DISPONIVEL): ");
            String livroStatus = sc.nextLine();

            if(livroStatus.equals("EMPRESTADO") || livroStatus.equals("DISPONIVEL")) {
                LivroStatus enumLivro = LivroStatus.valueOf(livroStatus);
                livroService.adicionarLivros(new Livro(nome, autor, qtdLinha, livroService.gerarId(), enumLivro));
                System.out.println("\nLivro adicionado com sucesso!");
            }
            else
                System.out.println("Esse status não existe!");
        }
        else if(opcao == 3){
            System.out.println("\nRemover livro!!!!!!!!");
            System.out.print("Qual o ID do Livro a ser removido? ");
            int idLivro = sc.nextInt();
            sc.nextLine();

            livroService.removerLivros(idLivro);
        }
        else
            System.out.println("Essa opção não existe.");

    }

    private static void menuPessoas(Scanner sc) {
        System.out.println("\n------PESSOAS------");
        System.out.println("\t1 - Listar");
        System.out.println("\t2 - Adicionar");
        System.out.println("\t3 - Remover");
        System.out.println("\t0 - Sair");
        System.out.print("\nOpção: ");

        int opcaoPessoa = sc.nextInt();
        sc.nextLine();

        if (opcaoPessoa == 0)
            return;
        else if (opcaoPessoa == 1) {
            System.out.print("Listar Alunos ou Professores (a/p): ");
            char opcaoTipoPessoa = sc.nextLine().toLowerCase().charAt(0);

            if (opcaoTipoPessoa == 'a') {
                pessoaService.exibirAluno();
            } else if (opcaoTipoPessoa == 'p') {
                pessoaService.exibirProfessor();
            } else {
                System.out.println("Essa opção não existe.");
            }
        }

        else if (opcaoPessoa == 2) {
            System.out.print("Adicionar Aluno ou Professor (a/p): ");
            char opcaoTipoPessoa = sc.nextLine().toLowerCase().charAt(0);

            if (opcaoTipoPessoa == 'a') {
                System.out.print("Nome do aluno: ");
                String nome = sc.nextLine();

                System.out.print("Email do aluno: ");
                String email = sc.nextLine();

                System.out.print("Curso do aluno: ");
                String curso = sc.nextLine();

                pessoaService.adicionarAluno(new Aluno(pessoaService.gerarId(), nome, email, curso));

            } else if (opcaoTipoPessoa == 'p') {
                System.out.print("Nome do professor: ");
                String nome = sc.nextLine();

                System.out.print("Email do professor: ");
                String email = sc.nextLine();

                System.out.print("Departamento do professor: ");
                String departamento = sc.nextLine();

                pessoaService.adicionarProfessor(new Professor(pessoaService.gerarId(), nome, email, departamento));

            } else {
                System.out.println("Essa opção não existe.");
            }
        }

        else if (opcaoPessoa == 3) {
            System.out.print("Remover Aluno ou Professor (a/p): ");
            char opcaoTipoPessoa = sc.nextLine().toLowerCase().charAt(0);

            if (opcaoTipoPessoa == 'a') {
                System.out.print("Qual o ID do Aluno? ");
                int idAluno = sc.nextInt();
                sc.nextLine();

                pessoaService.removerAluno(idAluno);

            } else if (opcaoTipoPessoa == 'p') {
                System.out.print("Qual o ID do Professor? ");
                int idProfessor = sc.nextInt();
                sc.nextLine();

                pessoaService.removerProfessor(idProfessor);

            } else {
                System.out.println("Essa opção não existe.");
            }
        }
    }
}