import java.util.ArrayList;
import java.util.List;

class Livro {
    private String codigo;
    private String titulo;
    private int exemplares;
    private List<Usuario> reservadoPor;

    public Livro(String codigo, String titulo, int exemplares) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.exemplares = exemplares;
        this.reservadoPor = new ArrayList<>();
    }

    public boolean estaDisponivel() {
        return exemplares > 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
}