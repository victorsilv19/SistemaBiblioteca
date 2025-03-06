package biblioteca;

import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        biblioteca biblioteca = new biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Modificar Livro");
            System.out.println("4. Remover Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1 -> biblioteca.cadastrar();
                case 2 -> biblioteca.listar();
                case 3 -> biblioteca.modificar();
                case 4 -> biblioteca.remover();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
        scanner.close();
    }
}
