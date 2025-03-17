package biblioteca;

public class Livro extends ItemBiblioteca {
    private String isbn;
    private boolean emprestado;

    public Livro(String titulo, String autor, int ano, String isbn) {
        super(titulo, autor, ano);
        setIsbn(isbn); // Aplicando validação ao definir ISBN
       
        this.emprestado = false;
    }

    @Override
    public void exibirDetalhes() {
    	String status = emprestado ? "Emprestado" : "Disponível";
        System.out.println("Livro: " + titulo + " | Autor: " + autor + " | Ano: " + ano + " | ISBN: " + isbn);
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) {
        if (!isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("Erro: O ISBN deve conter exatamente 13 dígitos numéricos.");
        }
        this.isbn = isbn;
    }
    
    public boolean estaEmprestado() {return emprestado;}
    
    public void setEmprestado (boolean emprestado) {this.emprestado = emprestado;}
}
