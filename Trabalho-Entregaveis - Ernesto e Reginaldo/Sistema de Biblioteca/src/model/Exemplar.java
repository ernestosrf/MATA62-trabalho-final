package model;

public class Exemplar {
    private int codigo;
    private boolean disponivel;
    private Usuario usuarioEmprestimo;
    private Livro livro;
    private Emprestimo emprestimo;

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
        this.emprestimo = new Emprestimo(this, usuario);
    }

    public void devolver() {
        this.disponivel = true;
        if (this.emprestimo != null) {
            this.emprestimo.finalizarEmprestimo();
        }
        this.usuarioEmprestimo = null;
        this.emprestimo = null;
    }

    public Usuario getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
}