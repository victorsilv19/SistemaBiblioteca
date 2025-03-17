package biblioteca;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private String usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, String usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        livro.setEmprestado(true); // Define o livro como emprestado
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

	public void ExibirDetalhes() {
		
		System.out.println("Livro: " + livro.getTitulo() + "| Usuário: "
				+ "" + usuario + "| Data de Empréstimo: " + dataEmprestimo + "| Data de Devolução: " + 
		dataDevolucao);
		
	}

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void exibirDetalhes() {
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Usuário: " + usuario);
        System.out.println("Data do Empréstimo: " + dataEmprestimo);
        System.out.println("Data de Devolução: " + dataDevolucao);
        System.out.println("----------------------------------");
    }
}
