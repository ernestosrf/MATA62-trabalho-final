package repository;

import model.*;
import service.Gerenciador;
import java.util.List;

public class BancoDeDadosEmMemoria {

    public static Gerenciador inicializar() {
        Gerenciador gerenciador = Gerenciador.getInstance();

        // Usuários
        gerenciador.adicionarUsuario(new AlunoGraduacao(123, "Ernesto Reis"));
        gerenciador.adicionarUsuario(new AlunoPosGraduacao(456, "Reginaldo Silva"));
        gerenciador.adicionarUsuario(new AlunoGraduacao(789, "Pedro Paulo"));
        gerenciador.adicionarUsuario(new Professor(100, "Claudio Sant'anna"));

        // Livros
        List<Livro> livros = List.of(
                criarLivro(100, "Engenharia de Software", "Addison Wesley",
                        List.of("Ian Sommervile"), "6ª", 2000, 2),
                criarLivro(101, "UML - Guia do Usuário", "Campus",
                        List.of("Grady Booch", "James Rumbaugh", "Ivar Jacobson"), "7ª", 2000, 1),
                criarLivro(102, "Engenharia de Software Moderna", "Independente",
                        List.of("Marco Tulio Valente"), "1ª", 2022, 2)
        );

        livros.forEach(gerenciador::adicionarLivro);

        return gerenciador;
    }

    private static Livro criarLivro(int codigo, String titulo, String editora,
                                    List<String> autores, String edicao, int ano, int exemplares) {
        Livro livro = new Livro(codigo, titulo, editora, autores, edicao, ano);
        for(int i = 1; i <= exemplares; i++) {
            livro.adicionarExemplar(new Exemplar(i, livro));
        }
        return livro;
    }
}