package biblioteca; 

import java.time.LocalDate; // Importa a classe LocalDate para trabalhar com datas

public class Emprestimo {
    private Livro livro; 
    private String usuario; 
    private LocalDate dataEmprestimo; 
    private LocalDate dataDevolucao; 

    // Construtor que cria um novo emprestimo
    public Emprestimo(Livro livro, String usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro; // Atribui o livro emprestado
        this.usuario = usuario; // Atribui o nome do usuario
        this.dataEmprestimo = dataEmprestimo; // Atribui a data de emprestimo
        this.dataDevolucao = dataDevolucao; // Atribui a data de devolucao
        livro.setEmprestado(true); // Marca o livro como emprestado
    }

    // Metodo para obter o livro emprestado
    public Livro getLivro() {
        return livro; // Retorna o livro
    }

    // Metodo para definir o livro emprestado
    public void setLivro(Livro livro) {
        this.livro = livro; // Define o livro emprestado
    }

    // Metodo para obter o nome do usuario
    public String getUsuario() {
        return usuario; // Retorna o nome do usuario
    }

    // Metodo para definir o nome do usuario
    public void setUsuario(String usuario) {
        this.usuario = usuario; // Define o nome do usuario
    }

    // Metodo para exibir os detalhes do emprestimo
    public void ExibirDetalhes() {
        // Exibe os detalhes do emprestimo de forma compacta
        System.out.println("Livro: " + livro.getTitulo() + "| Usuario: "
                + usuario + "| Data de Emprestimo: " + dataEmprestimo + "| Data de Devolucao: " +
                dataDevolucao);
    }

    // Metodo para definir a data de emprestimo
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo; // Define a data do emprestimo
    }

    // Metodo para obter a data de devolucao
    public LocalDate getDataDevolucao() {
        return dataDevolucao; // Retorna a data de devolucao
    }

    // Metodo para definir a data de devolucao
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao; // Define a data de devolucao
    }

    // Metodo para exibir os detalhes do emprestimo de forma mais detalhada
    public void exibirDetalhes() {
        System.out.println("Livro: " + livro.getTitulo()); // Exibe o titulo do livro
        System.out.println("Usuario: " + usuario); // Exibe o nome do usuario
        System.out.println("Data do Emprestimo: " + dataEmprestimo); // Exibe a data de emprestimo
        System.out.println("Data de Devolucao: " + dataDevolucao); // Exibe a data de devolucao
        System.out.println("----------------------------------"); // 
    }
}
