package database;

import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosMemoria implements IBancoDeDados {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public BancoDeDadosMemoria() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    @Override
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Livro buscarLivro(int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public Usuario buscarUsuario(int codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo() == codigo) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Livro> listarLivros() {
        return livros;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}