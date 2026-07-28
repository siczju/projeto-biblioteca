package aplicacao;

import entidades.Aluno;
import entidades.Pessoa;
import entidades.Professor;
import services.PessoaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static PessoaService pessoaService = new PessoaService();
    public static int id = pessoaService.gerarId();


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        pessoaService.carregar();

        for (boolean i = true; i == true; ) {

            int opcao = menuPrincipal(scanner);

            if (opcao == 0) {
                i = false;
                pessoaService.salvar();
            }
            else if (opcao == 1) {
                menuPessoas(scanner);
            } else
                System.out.println("Essa opção não existe.");
        }
        scanner.close();
    }

    private static int menuPrincipal(Scanner sc) {
        System.out.println("------------------MENU------------------");
        System.out.println("\t1 - Pessoas");
        System.out.println("\t2 - Livros");
        System.out.println("\t3 - Pegar emprestado");
        System.out.println("\t0 - Sair");
        System.out.print("\nOpção: ");

        int opcao = sc.nextInt();
        sc.nextLine(); // limpa o Enter

        return opcao;
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

                pessoaService.adicionarAluno(new Aluno(id++, nome, email, curso));

            } else if (opcaoTipoPessoa == 'p') {
                System.out.print("Nome do professor: ");
                String nome = sc.nextLine();

                System.out.print("Email do professor: ");
                String email = sc.nextLine();

                System.out.print("Departamento do professor: ");
                String departamento = sc.nextLine();

                pessoaService.adicionarProfessor(new Professor(id++, nome, email, departamento));

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