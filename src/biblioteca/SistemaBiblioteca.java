package biblioteca; 

import java.util.Scanner; 

// Classe principal do sistema da biblioteca
public class SistemaBiblioteca {
    
    // Metodo para pausar a execucao e aguardar o usuario pressionar Enter
    public static void pausa() {
        System.out.println("\nPressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda o usuario pressionar Enter
    }

    // Metodo principal (ponto de entrada do programa)
    public static void main(String[] args) {
        biblioteca biblioteca = new biblioteca(); // Instancia um objeto da classe biblioteca
        Scanner scanner = new Scanner(System.in); // Instancia um objeto Scanner para entrada de dados
        int opcao; // Variavel para armazenar a opcao do usuario
        
        // Loop do menu principal
        do {
            // Exibe as opcoes do menu
            System.out.println("\n1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Modificar Livro");
            System.out.println("4. Remover Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt(); // Le a opcao escolhida pelo usuario
            scanner.nextLine(); // Limpa o buffer do teclado
            
            // Estrutura switch para executar a opcao escolhida
            switch (opcao) {
                case 1 -> { 
                    biblioteca.cadastrar(); // Chama o metodo para cadastrar um livro
                    pausa(); // Aguarda o usuario pressionar Enter antes de continuar
                }
                case 2 -> { 
                    biblioteca.listar(); // Chama o metodo para listar os livros
                    pausa(); // Aguarda o usuario pressionar Enter antes de continuar
                }
                case 3 -> { 
                    biblioteca.modificar(); // Chama o metodo para modificar um livro
                    pausa(); // Aguarda o usuario pressionar Enter antes de continuar
                }
                case 4 -> { 
                    biblioteca.remover(); // Chama o metodo para remover um livro
                    pausa(); // Aguarda o usuario pressionar Enter antes de continuar
                }
                case 5 -> System.out.println("Saindo..."); // Mensagem ao sair do programa
                default -> System.out.println("Opcao invalida!"); // Mensagem para opcao invalida
            }
        } while (opcao != 5); // O loop continua ate que o usuario escolha a opcao 5 (Sair)
        
        scanner.close(); // Fecha o scanner para liberar recursos
    }
}
