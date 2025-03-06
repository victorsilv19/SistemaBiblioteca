package biblioteca;

public abstract class ItemBiblioteca {
    protected String titulo;
    protected String autor;
    protected int ano;

    public ItemBiblioteca(String titulo, String autor, int ano) {
        this.titulo = titulo;
        setAutor(autor); // Validação no setter
        setAno(ano); // Validação no setter
    }

    public abstract void exibirDetalhes();

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) {
        if (autor.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Erro: O autor não pode conter números.");
        }
        this.autor = autor;
    }

    public int getAno() { return ano; }

    public void setAno(int ano) {
        if (ano < 1000 || ano > 9999) {
            throw new IllegalArgumentException("Erro: O ano deve ter exatamente 4 dígitos.");
        }
        this.ano = ano;
    }
}
