package biblioteca;

public class Livro extends ItemBiblioteca {
    private String isbn;

    public Livro(String titulo, String autor, int ano, String isbn) {
        super(titulo, autor, ano);
        this.isbn = isbn;
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Livro: " + titulo + " | Autor: " + autor + " | Ano: " + ano + " | ISBN: " + isbn);
    }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
