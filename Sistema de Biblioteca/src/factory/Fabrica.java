package factory;

import gerenciador.Gerenciador;
import database.BancoDeDadosMemoria;
import database.IBancoDeDados;
import gerenciador.Invocador;
import model.AlunoGraduacao;
import model.AlunoPosGraduacao;
import model.Livro;
import model.ProfessorUsuario;

public class Fabrica {
    private IBancoDeDados bancoDeDados;

    public Fabrica() {
        bancoDeDados = new BancoDeDadosMemoria();
        inicializarDados();
    }

    public Gerenciador criarGerenciador() {
        return Gerenciador.getInstance(bancoDeDados);
    }

    private void inicializarDados() {
        // Adiciona alguns livros e usuários ao banco de dados
        bancoDeDados.adicionarLivro(new Livro(100, "Introdução à Programação", "Editora A", 1, 2020));
        bancoDeDados.adicionarLivro(new Livro(101, "Estruturas de Dados", "Editora B", 2, 2019));
        bancoDeDados.adicionarLivro(new Livro(102, "Padrões de Projeto", "Editora C", 3, 2021));

        bancoDeDados.adicionarUsuario(new AlunoGraduacao(123, "João Silva"));
        bancoDeDados.adicionarUsuario(new AlunoPosGraduacao(456, "Maria Souza"));
        bancoDeDados.adicionarUsuario(new ProfessorUsuario(789, "Carlos Oliveira"));
    }
}