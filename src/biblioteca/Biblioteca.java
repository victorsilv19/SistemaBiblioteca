package biblioteca; 

import java.time.LocalDate; // Importa a classe LocalDate para lidar com datas
import java.util.ArrayList; // Importa a classe ArrayList para listas dinamicas
import java.util.Scanner; // Importa a classe Scanner para ler entradas do usuario

public class Biblioteca implements Operacoes {  // Classe Biblioteca que implementa as operacoes
    private ArrayList<Livro> livros = new ArrayList<>(); // Lista para armazenar os livros cadastrados
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>(); // Lista para armazenar os emprestimos
    private Scanner scanner = new Scanner(System.in); // Scanner para ler entradas do usuario

    // Metodo para pegar a lista de livros
    public ArrayList<Livro> getLivros() {
        return livros; // Retorna a lista de livros
    }

    // Metodo para definir a lista de livros
    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros; // Atribui a nova lista de livros
    }

    // Metodo para pegar a lista de emprestimos
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos; // Retorna a lista de emprestimos
    }

    // Metodo para definir a lista de emprestimos
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos; // Atribui a nova lista de emprestimos
    }

    // Metodo para pegar o objeto Scanner
    public Scanner getScanner() {
        return scanner; // Retorna o Scanner
    }

    // Metodo para definir o objeto Scanner
    public void setScanner(Scanner scanner) {
        this.scanner = scanner; // Atribui o novo Scanner
    }

    // Metodo para cadastrar um livro
    @Override
    public void cadastrar() {
        System.out.print("Titulo: "); // Pergunta pelo titulo do livro
        String titulo = scanner.nextLine(); // Lê o titulo

        String autor;
        while (true) { // Loop para garantir que o autor nao tenha numeros
            System.out.print("Autor: "); // Pergunta pelo autor
            autor = scanner.nextLine(); // Lê o autor
            if (autor.matches(".*\\d.*")) { // Verifica se o autor tem numeros
                System.out.println("Erro: O autor nao pode conter numeros."); // Erro se o autor tiver numeros
            } else {
                break; // Sai do loop se o autor for valido
            }
        }

        int ano;
        while (true) { // Loop para garantir que o ano tenha 4 digitos
            System.out.print("Ano: "); // Pergunta pelo ano
            String anoStr = scanner.nextLine(); // Lê o ano como string
            if (anoStr.matches("\\d{4}")) { // Verifica se o ano tem exatamente 4 digitos
                ano = Integer.parseInt(anoStr); // Converte o ano para inteiro
                break; // Sai do loop se o ano for valido
            } else {
                System.out.println("Erro: O ano deve ter exatamente 4 digitos."); // Erro se o ano for invalido
            }
        }

        String isbn;
        while (true) { // Loop para garantir que o ISBN tenha 13 digitos
            System.out.print("ISBN: "); // Pergunta pelo ISBN
            isbn = scanner.nextLine(); // Lê o ISBN
            if (isbn.matches("\\d{13}")) { // Verifica se o ISBN tem 13 digitos
                break; // Sai do loop se o ISBN for valido
            } else {
                System.out.println("Erro: O ISBN deve conter exatamente 13 digitos numericos."); // Erro se o ISBN for invalido
            }
        }

        Livro novoLivro = new Livro(titulo, autor, ano, isbn); // Cria um novo livro com os dados fornecidos
        livros.add(novoLivro); // Adiciona o livro a lista
        System.out.println("Livro cadastrado com sucesso!"); // Confirma o cadastro do livro
    }

    // Metodo para listar todos os livros cadastrados
    @Override
    public void listar() {
        if (livros.isEmpty()) { // Verifica se a lista de livros esta vazia
            System.out.println("Nenhum livro cadastrado."); // Informa que nao ha livros
            return; // Sai do metodo
        }

        for (Livro livro : livros) { // Itera sobre todos os livros
            livro.exibirDetalhes(); // Exibe os detalhes de cada livro
        }
    }

    // Metodo para modificar as informacoes de um livro
    @Override
    public void modificar() {
        System.out.print("Informe o titulo do livro para modificar: "); // Pergunta o titulo do livro
        String titulo = scanner.nextLine(); // Lê o titulo

        for (Livro livro : livros) { // Itera sobre os livros cadastrados
            if (livro.getTitulo().equalsIgnoreCase(titulo)) { // Verifica se o livro com o titulo existe
                String autor;
                while (true) { // Loop para garantir que o autor nao tenha numeros
                    System.out.print("Novo Autor: "); // Pergunta pelo novo autor
                    autor = scanner.nextLine(); // Lê o novo autor
                    if (autor.matches(".*\\d.*")) { // Verifica se o autor tem numeros
                        System.out.println("Erro: O autor nao pode conter numeros."); // Erro se o autor tiver numeros
                    } else {
                        break; // Sai do loop se o autor for valido
                    }
                }
                livro.setAutor(autor); // Atualiza o autor do livro

                int ano;
                while (true) { // Loop para garantir que o ano tenha 4 digitos
                    System.out.print("Novo Ano: "); // Pergunta pelo novo ano
                    String anoStr = scanner.nextLine(); // Lê o novo ano
                    if (anoStr.matches("\\d{4}")) { // Verifica se o ano tem 4 digitos
                        ano = Integer.parseInt(anoStr); // Converte o ano para inteiro
                        break; // Sai do loop se o ano for valido
                    } else {
                        System.out.println("Erro: O ano deve ter exatamente 4 digitos."); // Erro se o ano for invalido
                    }
                }
                livro.setAno(ano); // Atualiza o ano do livro

                String isbn;
                while (true) { // Loop para garantir que o ISBN tenha 13 digitos
                    System.out.print("Novo ISBN: "); // Pergunta pelo novo ISBN
                    isbn = scanner.nextLine(); // Lê o novo ISBN
                    if (isbn.matches("\\d{13}")) { // Verifica se o ISBN tem 13 digitos
                        break; // Sai do loop se o ISBN for valido
                    } else {
                        System.out.println("Erro: O ISBN deve conter exatamente 13 digitos numericos."); // Erro se o ISBN for invalido
                    }
                }
                livro.setIsbn(isbn); // Atualiza o ISBN do livro

                System.out.println("Livro atualizado com sucesso!"); // Confirma que o livro foi atualizado
                return; // Sai do metodo
            }
        }
        System.out.println("Livro nao encontrado."); // Informa que o livro nao foi encontrado
    }

    // Metodo para remover um livro
    @Override
    public void remover() {
        System.out.print("Informe o titulo do livro para remover: "); // Pergunta pelo titulo do livro
        String titulo = scanner.nextLine(); // Lê o titulo

        boolean removido = livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo)); // Tenta remover o livro da lista

        if (removido) { // Verifica se o livro foi removido
            System.out.println("Livro removido com sucesso!"); // Informa que o livro foi removido
        } else {
            System.out.println("Livro nao encontrado."); // Informa que o livro nao foi encontrado
        }
    }

    // Metodo para emprestar um livro
    public void emprestimoLivros() {
        System.out.println("Informe o titulo do Livro para o emprestimo: "); // Pergunta pelo titulo do livro
        String titulo = scanner.nextLine(); // Lê o titulo

        for (Livro livro : livros) { // Itera sobre todos os livros cadastrados
            if (livro.getTitulo().equalsIgnoreCase(titulo)) { // Verifica se o titulo do livro corresponde ao fornecido
                if (livro.estaEmprestado()) { // Verifica se o livro ja foi emprestado
                    System.out.println("Erro!!: Este livro ja esta emprestado."); // Informa que o livro nao esta disponivel
                } else {
                    System.out.print("Nome do usuario: "); // Pergunta pelo nome do usuario
                    String usuario = scanner.nextLine(); // Lê o nome do usuario

                    LocalDate dataEmprestimo = LocalDate.now(); // Define a data do emprestimo como a data atual
                    LocalDate dataDevolucao = dataEmprestimo.plusDays(7); // Define a data de devolucao para 7 dias depois

                    Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao); // Cria o emprestimo
                    emprestimos.add(novoEmprestimo); // Adiciona o emprestimo a lista
                    System.out.println("Livro emprestado com sucesso."); // Informa que o livro foi emprestado
                    novoEmprestimo.exibirDetalhes(); // Exibe os detalhes do emprestimo
                }
                return; // Sai do metodo
            }
        }
        System.out.println("Erro!!: Livro nao encontrado"); // Informa que o livro nao foi encontrado
    }

    // Metodo para listar os livros emprestados
    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) { // Verifica se a lista de emprestimos esta vazia
            System.out.println("Nenhum livro emprestado."); // Informa que nao ha livros emprestados
            return; // Sai do metodo
        }

        System.out.println("Lista de livros emprestados:"); // Exibe o titulo
        for (Emprestimo emprestimo : emprestimos) { // Itera sobre os emprestimos
            emprestimo.exibirDetalhes(); // Exibe os detalhes do emprestimo
        }
    }

    // Metodo para devolver um livro
    public void devolverLivros() {
        System.out.println("Digite o titulo do livro a ser devolvido: "); // Pergunta pelo titulo do livro
        String titulo = scanner.nextLine(); // Lê o titulo

        for (Emprestimo emprestimo : emprestimos) { // Itera sobre todos os emprestimos
            if (emprestimo.getLivro().getTitulo().equalsIgnoreCase(titulo)) { // Verifica se o livro corresponde ao emprestado
                emprestimos.remove(emprestimo); // Remove o emprestimo da lista
                System.out.println("Livro devolvido com sucesso!!"); // Informa que o livro foi devolvido
                return; // Sai do metodo
            }
        }
        System.out.println("Erro!!: Livro nao encontrado"); // Informa que o livro nao foi encontrado
    }
}
