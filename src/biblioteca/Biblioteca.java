package biblioteca; 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Declara a classe 'Biblioteca', que implementa a interface 'Operacoes' (Herança e Polimorfismo)
public class Biblioteca implements Operacoes {  
    // Lista para armazenar os livros cadastrados (Encapsulamento)
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    // Scanner para entrada de dados pelo usuário
     Scanner scanner = new Scanner(System.in);

    // Método para cadastrar um novo livro na biblioteca
    @Override // Sobrescrita de metodo (Polimorfismo)
    public void cadastrar() {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine(); // Le o titulo do livro

        // Loop para validar a entrada do autor (não pode conter números)
        String autor;
        while (true) {
            System.out.print("Autor: ");
            autor = scanner.nextLine();
            if (autor.matches(".*\\d.*")) { // Verifica se o autor contem numeros
                System.out.println("Erro: O autor não pode conter números.");
            } else {
                break; // Sai do loop se o nome do autor for valido
            }
        }

        // Loop para validar o ano de publicação (deve ter 4 digitos)
        int ano;
        while (true) {
            System.out.print("Ano: ");
            String anoStr = scanner.nextLine();
            if (anoStr.matches("\\d{4}")) { // Verifica se o ano tem exatamente 4 digitos
                ano = Integer.parseInt(anoStr);
                break;
            } else {
                System.out.println("Erro: O ano deve ter exatamente 4 digitos.");
            }
        }

        // Loop para validar o ISBN (deve conter exatamente 13 dígitos numéricos)
        String isbn;
        while (true) {
            System.out.print("ISBN: ");
            isbn = scanner.nextLine();
            if (isbn.matches("\\d{13}")) { // Verifica se o ISBN tem exatamente 13 dígitos
                break;
            } else {
                System.out.println("Erro: O ISBN deve conter exatamente 13 dígitos numéricos.");
            }
        }

        // Adiciona um novo livro a lista (Criação de objeto)
        livros.add(new Livro(titulo, autor, ano, isbn));
        System.out.println("Livro cadastrado com sucesso!");
    }

    // Metodo para listar os livros cadastrados
    @Override // Sobrescrita de método (Polimorfismo)
    public void listar() {
        if (livros.isEmpty()) { // Verifica se a lista esta vazia
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        // Percorre a lista e exibe os detalhes de cada livro
        for (Livro livro : livros) {
            livro.exibirDetalhes(); // Chama um metodo do objeto Livro
        }
    }

    // Metodo para modificar os detalhes de um livro existente
    @Override // Sobrescrita de método (Polimorfismo)
    public void modificar() {
        System.out.print("Informe o título do livro para modificar: ");
        String titulo = scanner.nextLine(); // Lê o título do livro a ser modificado
        
        // Percorre a lista para encontrar o livro correspondente
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) { // Compara ignorando maiusculas e minusculas
                
                // Loop para validar o novo autor
                String autor;
                while (true) {
                    System.out.print("Novo Autor: ");
                    autor = scanner.nextLine();
                    if (autor.matches(".*\\d.*")) { // Verifica se o nome contem numeros
                        System.out.println("Erro: O autor não pode conter números.");
                    } else {
                        break;
                    }
                }
                livro.setAutor(autor); // Atualiza o autor do livro (Uso de setter)

                // Loop para validar o novo ano
                int ano;
                while (true) {
                    System.out.print("Novo Ano: ");
                    String anoStr = scanner.nextLine();
                    if (anoStr.matches("\\d{4}")) { // Verifica se o ano tem 4 dígitos
                        ano = Integer.parseInt(anoStr);
                        break;
                    } else {
                        System.out.println("Erro: O ano deve ter exatamente 4 dígitos.");
                    }
                }
                livro.setAno(ano); // Atualiza o ano do livro (Uso de setter)

                // Loop para validar o novo ISBN
                String isbn;
                while (true) {
                    System.out.print("Novo ISBN: ");
                    isbn = scanner.nextLine();
                    
                    if (isbn.matches("\\d{13}")) { // Se o ISBN tem exatamente 13 dígitos, sai do loop
                        break;
                    } else {
                        System.out.println("Erro: O ISBN deve conter exatamente 13 dígitos numéricos.");
                    }
                }
                livro.setIsbn(isbn); // Atualiza o ISBN do livro (Uso de setter)

                System.out.println("Livro atualizado com sucesso!");
                return; // Sai do metodo após modificar o livro
            }
        }
        System.out.println("Livro não encontrado."); // Exibe mensagem caso o livro não seja encontrado
    }

    // Metodo para remover um livro da lista pelo título
    @Override // Sobrescrita de método (Polimorfismo)
    public void remover() {
        System.out.print("Informe o título do livro para remover: ");
        String titulo = scanner.nextLine(); // Le o título do livro a ser removido

        // Remove o livro da lista caso o titulo corresponda (ignorando maiúsculas e minusculas)
        boolean removido = livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
        
        if (removido) {				
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void emprestimoLivros() {
    	System.out.println("Informe o título do Livro para o empréstimo: ");
    	String titulo = scanner.nextLine();
    	
    	for (Livro livro : livros) {
    		
    		if(livro.getTitulo().equalsIgnoreCase(titulo)) {
    			
    			if(livro.estaEmprestado()) {
    				System.out.println("Erro!!: Este livro já está emprestado.");
    			}else {
    				System.out.print("Nome do usuário : ");
    				String usuario = scanner.nextLine();
    				
    				LocalDate dataEmprestimo = LocalDate.now();
    				LocalDate dataDevolucao = dataEmprestimo.plusDays(7); //data de devolução dos livros
    				
    				Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
    				emprestimos.add(novoEmprestimo);
    				System.out.println("Livro emprestado com sucesso.");
    				novoEmprestimo.ExibirDetalhes();
    			}
    			return;
    		}
    	}
    	System.out.println("Erro!!: Livro não encontrado");
    }
    
    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum livro emprestado.");
            return;
        }

        System.out.println("Lista de livros emprestados:");
        for (Emprestimo emprestimo : emprestimos) {
            emprestimo.ExibirDetalhes();
        }
    }
    
    public void devolverLivros() {
    	System.out.println("Digite o título do livro a ser devolvido: ");
    	String titulo = scanner.nextLine(); //irá ler o título do livro que vai ser devolvido.
    	
    	//um pequeno For que irá percorrer a lista de empréstimos
    	for(Emprestimo emprestimo : emprestimos) {
    		if(emprestimo.getLivro().getTitulo().equals(titulo)) {
    			emprestimos.remove(emprestimo); //irá remover o emprestimo da lista
    			System.out.println("Livro devolvido com sucesso!!");
    			return; //após a devolução sai do método
    		}
    	}
    	System.out.println("Erro!!: Livro não encontrado");
    }
}


