package biblioteca;

import java.time.LocalDate;

public class Emprestimo {
	private Livro livro;
	private String usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;


	//construtor
public Emprestimo(Livro livro, String usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
	
	this.livro = livro;
	this.usuario = usuario;
	this.dataEmprestimo = dataEmprestimo;
	this.dataDevolucao = dataDevolucao;
	livro.setEmprestado(true); //irá marcar que o livro foi emprestado
   }


   //getters
public Livro getLivro() {return livro;}
public String getUsuario() {return usuario;}
public LocalDate getDataEmprestimo() {return dataEmprestimo;}
public LocalDate getDataDevolucao() {return dataDevolucao;}

	//exibir os detalhes de empréstimo

	public void ExibirDetalhes() {
		
		System.out.println("Livro: " + livro.getTitulo() + "| Usuário: "
				+ "" + usuario + "| Data de Empréstimo: " + dataEmprestimo + "| Data de Devolução: " + 
		dataDevolucao);
		
	}


}
