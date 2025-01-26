package ufba;
import java.util.ArrayList;
import java.util.List;

class Gerenciador {
    private static Gerenciador instance;
    private List<AlunoGraduacao> usuarios;
    private List<Livro> livros;

    private Gerenciador() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
    }

    public static Gerenciador getInstance() {
        if (instance == null) {
            instance = new Gerenciador();
        }
        return instance;
    }

    public Usuario encontrarUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) return usuario;
        }
        
        return null;
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario instanceof AlunoGraduacao) {
            usuarios.add((AlunoGraduacao) usuario);
        } 
    }
    
    public Livro encontrarLivro(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) return livro;
        }
        return null;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
}