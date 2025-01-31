package database;

import model.Livro;
import model.Usuario;

import java.util.List;

public interface IBancoDeDados {
    void adicionarLivro(Livro livro);
    void adicionarUsuario(Usuario usuario);
    Livro buscarLivro(int codigo);
    Usuario buscarUsuario(int codigo);
    List<Livro> listarLivros();
    List<Usuario> listarUsuarios();
}