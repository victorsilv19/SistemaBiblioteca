package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca implements Operacoes {
    private ArrayList<Livro> livros = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void cadastrar() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        String autor;
        while (true) {
            System.out.print("Autor: ");
            autor = scanner.nextLine();
            if (autor.matches(".*\\d.*")) {
                System.out.println("Erro: O autor não pode conter números.");
            } else {
                break;
            }
        }

        int ano;
        while (true) {
            System.out.print("Ano: ");
            String anoStr = scanner.nextLine();
            if (anoStr.matches("\\d{4}")) {
                ano = Integer.parseInt(anoStr);
                break;
            } else {
                System.out.println("Erro: O ano deve ter exatamente 4 dígitos.");
            }
        }

        String isbn;
        while (true) {
            System.out.print("ISBN: ");
            isbn = scanner.nextLine();
            if (isbn.matches("\\d{13}")) {
                break;
            } else {
                System.out.println("Erro: O ISBN deve conter exatamente 13 dígitos numéricos.");
            }
        }

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
                String autor;
                while (true) {
                    System.out.print("Novo Autor: ");
                    autor = scanner.nextLine();
                    if (autor.matches(".*\\d.*")) {
                        System.out.println("Erro: O autor não pode conter números.");
                    } else {
                        break;
                    }
                }
                livro.setAutor(autor);

                int ano;
                while (true) {
                    System.out.print("Novo Ano: ");
                    String anoStr = scanner.nextLine();
                    if (anoStr.matches("\\d{4}")) {
                        ano = Integer.parseInt(anoStr);
                        break;
                    } else {
                        System.out.println("Erro: O ano deve ter exatamente 4 dígitos.");
                    }
                }
                livro.setAno(ano);

                String isbn;
                while (true) {
                    System.out.print("Novo ISBN: ");
                    isbn = scanner.nextLine();
                    if (isbn.matches("\\d{13}")) {
                        break;
                    } else {
                        System.out.println("Erro: O ISBN deve conter exatamente 13 dígitos numéricos.");
                    }
                }
                livro.setIsbn(isbn);

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
