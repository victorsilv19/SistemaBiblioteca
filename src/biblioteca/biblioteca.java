package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class biblioteca implements Operacoes {
    private ArrayList<Livro> livros = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void cadastrar() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        livros.add(new Livro(titulo, autor, ano, isbn));
        System.out.println("Livro cadastrado com sucesso!");
    }

    @Override
    public void listar() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Livro livro : livros) {
            livro.exibirDetalhes();
        }
    }

    @Override
    public void modificar() {
        System.out.print("Informe o título do livro para modificar: ");
        String titulo = scanner.nextLine();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.print("Novo Autor: ");
                livro.setAutor(scanner.nextLine());
                System.out.print("Novo Ano: ");
                livro.setAno(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Novo ISBN: ");
                livro.setIsbn(scanner.nextLine());
                System.out.println("Livro atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    @Override
    public void remover() {
        System.out.print("Informe o título do livro para remover: ");
        String titulo = scanner.nextLine();
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("Livro removido com sucesso!");
    }
}
