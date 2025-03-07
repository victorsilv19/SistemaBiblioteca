package biblioteca; 


public abstract class ItemBiblioteca {
    protected String titulo; // Titulo do item
    protected String autor; // Autor do item
    protected int ano; // Ano de publicacao do item

    // Construtor da classe que inicializa os atributos
    public ItemBiblioteca(String titulo, String autor, int ano) {
        this.titulo = titulo;
        setAutor(autor); // Chama o setter para validar o autor
        setAno(ano); // Chama o setter para validar o ano
    }

    // Metodo abstrato que deve ser implementado pelas subclasses
    public abstract void exibirDetalhes();

    // Metodo getter para obter o titulo
    public String getTitulo() { return titulo; }

    // Metodo setter para definir o titulo
    public void setTitulo(String titulo) { this.titulo = titulo; }

    // Metodo getter para obter o autor
    public String getAutor() { return autor; }

    // Metodo setter para definir o autor com validacao
    public void setAutor(String autor) {
        if (autor.matches(".*\\d.*")) { // Verifica se tem numeros no nome do autor
            throw new IllegalArgumentException("Erro: O autor nao pode conter numeros.");
        }
        this.autor = autor;
    }

    // Metodo getter para obter o ano
    public int getAno() { return ano; }

    // Metodo setter para definir o ano com validacao
    public void setAno(int ano) {
        if (ano < 1000 || ano > 9999) { // Verifica se o ano tem exatamente 4 digitos
            throw new IllegalArgumentException("Erro: O ano deve ter exatamente 4 digitos.");
        }
        this.ano = ano;
    }
}
