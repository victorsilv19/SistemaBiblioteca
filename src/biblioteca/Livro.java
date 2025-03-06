package biblioteca;

public class Livro extends ItemBiblioteca {
    private String isbn;

    public Livro(String titulo, String autor, int ano, String isbn) {
        super(titulo, autor, ano);
        setIsbn(isbn); // Aplicando validação ao definir ISBN
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro: " + titulo + " | Autor: " + autor + " | Ano: " + ano + " | ISBN: " + isbn);
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) {
        if (!isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("Erro: O ISBN deve conter exatamente 13 dígitos numéricos.");
        }
        this.isbn = isbn;
    }
}
