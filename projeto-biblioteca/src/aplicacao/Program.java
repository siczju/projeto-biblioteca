package aplicacao;

import entidades.Aluno;
import entidades.Pessoa;
import entidades.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();
        int id = pessoas.size();

        for(boolean i = true; i == true; ) {
            System.out.println("------------------MENU------------------");
            System.out.println("\t1 - Pessoas");
            System.out.println("\t2 - Livros");
            System.out.println("\t3 - Pegar emprestado");
            System.out.println("\t0 - Sair");
            System.out.print("\nOpcao: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 0)
                i = false;
            else if(opcao == 1){
                System.out.println("\n------PESSOAS------");
                System.out.println("\t1 - Listar");
                System.out.println("\t2 - Adicionar");
                System.out.println("\t3 - Remover");
                System.out.println("\t0 - Sair");
                System.out.print("\nOpcao: ");
                int opcaoPessoa = sc.nextInt();
                sc.nextLine();

                if(opcaoPessoa == 0)
                    continue;
                else if(opcaoPessoa == 1) {
                    System.out.println("Listar Alunos ou Professores (a/p)");
                    System.out.print("Opcao: ");
                    char opcaoTipoPessoa = sc.nextLine().toLowerCase().charAt(0);
                    if(opcaoTipoPessoa == 'a') {
                        for (Pessoa pessoa : pessoas)
                            if (pessoa instanceof Aluno)
                                System.out.println(pessoa);
                    }
                    if(opcaoTipoPessoa == 'p') {
                        for (Pessoa pessoa : pessoas)
                            if (pessoa instanceof Professor)
                                System.out.println(pessoa);
                    }
                        }
                else if(opcaoPessoa == 2){
                    System.out.print("Adicionar Aluno ou Professor (a/p): ");
                    char opcaoTipoPessoa = sc.nextLine().toLowerCase().charAt(0);
                    if(opcaoTipoPessoa == 'a'){
                        System.out.print("Nome do aluno: ");
                        String nome = sc.nextLine();
                        System.out.print("Email do aluno: ");
                        String email = sc.nextLine();
                        System.out.print("Turma do aluno: ");
                        String curso = sc.nextLine();

                        pessoas.add(new Aluno(id++, nome, email, curso));
                    }
                    else if(opcaoTipoPessoa == 'p'){
                        System.out.print("Nome do professor: ");
                        String nome = sc.nextLine();
                        System.out.print("Email do professor: ");
                        String email = sc.nextLine();
                        System.out.print("Departamento do professor: ");
                        String departamento = sc.nextLine();
                        pessoas.add(new Professor(id++, nome, email, departamento));
                    }
                    else
                        System.out.println("Essa opção não existe.");
                }
                else if(opcaoPessoa == 3){
                    System.out.print("Remover Aluno ou Professor (a/p): ");
                    char opcaoTipoPessoa = sc.nextLine().toLowerCase().charAt(0);
                    if(opcaoTipoPessoa == 'a'){
                        System.out.print("Qual o ID do Aluno? ");
                        int idAluno = sc.nextInt();
                        sc.nextLine();

                        Pessoa pessoa = pessoas.stream()
                                .filter(x -> x.getId() == idAluno)
                                .findFirst()
                                .orElse(null);

                        if(pessoa instanceof Professor )
                            System.out.println("É um Professor, nao um Aluno!");
                        else {

                            if (pessoa == null)
                                System.out.println("Este Aluno não existe!");
                            else {
                                System.out.println("Aluno excluído com sucesso!");
                                pessoas.remove(pessoa);
                            }
                        }

                    }
                    else if(opcaoTipoPessoa == 'p'){
                        System.out.print("Qual o ID do Professor? ");
                        int idProfessor = sc.nextInt();
                        sc.nextLine();

                        Pessoa pessoa = pessoas.stream()
                                .filter(x -> x.getId() == idProfessor)
                                .findFirst()
                                .orElse(null);

                        if(pessoa instanceof Aluno )
                            System.out.println("É um Aluno, nao um Professor!");
                        else {
                            if (pessoa == null)
                                System.out.println("Este Professor não existe!");
                            else {
                                System.out.println("Professor excluído com sucesso!");
                                pessoas.remove(pessoa);
                            }
                        }
                    }
                    else
                        System.out.println("Essa opção não existe.");
                }

            }

        }


    }

}
