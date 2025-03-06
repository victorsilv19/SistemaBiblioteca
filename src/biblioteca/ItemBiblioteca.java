package biblioteca;

public abstract class ItemBiblioteca {
    protected String titulo;
    protected String autor;
    protected int ano;

    public ItemBiblioteca(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }
    
    public abstract void exibirDetalhes();
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
}
