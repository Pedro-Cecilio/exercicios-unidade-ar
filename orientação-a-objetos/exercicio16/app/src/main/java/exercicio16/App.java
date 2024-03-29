/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package exercicio16;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    private static List<Emprestimo> listaDeEmprestimos = new ArrayList<>();
    public static void main(String[] args) {
        Livro livro1 = new Livro(1, "Dom Quixote", "Miguel de Cervantes", 863);
        Livro livro2 = new Livro(2, "Cem Anos de Solidão", "Gabriel García Márquez", 448);
        Livro livro3 = new Livro(3, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 96);

        Pessoa pessoa1 = new Pessoa(1, "João");
        Pessoa pessoa2 = new Pessoa(2, "Maria");
        Pessoa pessoa3 = new Pessoa(3, "Pedro");

        gerarEmprestimo(livro1, pessoa1);
        gerarEmprestimo(livro2, pessoa2);
        gerarEmprestimo(livro3, pessoa3);
        gerarEmprestimo(livro2, pessoa1);
        gerarEmprestimo(livro1, pessoa3);

        desfazerEmprestimo(livro1);
        gerarEmprestimo(livro1, pessoa3);


    }

    private static void gerarEmprestimo(Livro livro, Pessoa pessoa) {
        Optional<Emprestimo> emprestimo = listaDeEmprestimos.stream().filter(emp -> {
            return (emp.getLivro().getId() == livro.getId() && emp.isAtivo());
        }).findFirst();
        if(emprestimo.isPresent()){
            System.out.printf("O livro de nome: %s e id: %d ja esta emprestado.\n", livro.getNome(), livro.getId());
            return;
        }
        Emprestimo novoEmprestimo = new Emprestimo(livro, pessoa);
        listaDeEmprestimos.add(novoEmprestimo);
        System.out.println("Livro emprestado com sucesso!");
    }
    private static void desfazerEmprestimo( Livro livro) {
        Optional<Emprestimo> emprestimo = listaDeEmprestimos.stream().filter(emp -> {
            return (emp.getLivro().getId() == livro.getId() && emp.isAtivo());
        }).findFirst();
        if(emprestimo.isPresent()){
            emprestimo.get().setAtivo(false);
            return;
        }
        System.out.println("Livro não está emprestado");
    }
}
