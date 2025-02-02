package model;

public class Exemplar {
    private int codigo;
    private boolean disponivel;
    private Usuario usuarioEmprestimo;
    private Livro livro;

    public Exemplar(int codigo, Livro livro) {
        this.codigo = codigo;
        this.disponivel = true;
        this.livro = livro;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean getStatus() {
        return disponivel;
    }

    public void emprestar(Usuario usuario) {
        this.disponivel = false;
        this.usuarioEmprestimo = usuario;
    }

    public void devolver() {
        this.disponivel = true;
        this.usuarioEmprestimo = null;
    }

    public Usuario getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }
}