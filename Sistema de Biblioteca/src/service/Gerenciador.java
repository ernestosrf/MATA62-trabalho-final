package service;

import model.*;
import strategy.RegraEmprestimo;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private static Gerenciador instance;
    private List<Usuario> usuarios;
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

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public Usuario buscarUsuario(int codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo() == codigo) {
                return usuario;
            }
        }
        return null;
    }

    public Livro buscarLivro(int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    public String emprestarLivro(int codigoUsuario, int codigoLivro) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        Livro livro = buscarLivro(codigoLivro);

        if (usuario == null || livro == null) {
            return "Usuário ou livro não encontrado.";
        }

        cancelarReservaSeExistir(usuario, livro);

        RegraEmprestimo regra = usuario.getRegraEmprestimo();
        if (!regra.podeEmprestar(usuario, livro)) {
            return "Falha no empréstimo para " + usuario.getNome() + ": " + regra.getMensagemErro();
        }

        Exemplar exemplar = livro.encontrarExemplarDisponivel();
        if (exemplar != null) {
            Emprestimo emprestimo = new Emprestimo(exemplar, usuario);
            usuario.adicionarEmprestimo(emprestimo);
            exemplar.emprestar(usuario);
            return "Empréstimo realizado: " + usuario.getNome() + " pegou o livro '" + livro.getTitulo() + "'.";
        }

        return "Não há exemplares disponíveis para empréstimo.";

    }

    private void cancelarReservaSeExistir(Usuario usuario, Livro livro) {
        Reserva reserva = usuario.getReservas().stream()
                .filter(r -> r.getLivro().equals(livro))
                .findFirst()
                .orElse(null);

        if (reserva != null) {
            usuario.removerReserva(reserva);
            livro.getReservas().remove(reserva);
        }
    }

    public String reservarLivro(int codigoUsuario, int codigoLivro) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        Livro livro = buscarLivro(codigoLivro);

        if (usuario.getReservas().size() >= 3) {
            return "Limite de reservas excedido para " + usuario.getNome();
        }

        Reserva reserva = new Reserva(usuario, livro);
        usuario.adicionarReserva(reserva);
        livro.adicionarReserva(reserva);

        return "Reserva realizada com sucesso para " + usuario.getNome() + " - " + livro.getTitulo();
    }

    public String devolverLivro(int codigoUsuario, int codigoLivro) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        Livro livro = buscarLivro(codigoLivro);

        if (usuario == null || livro == null) {
            return "Usuário ou livro não encontrado.";
        }

        for (Exemplar exemplar : livro.getExemplares()) {
            if (!exemplar.getStatus() && exemplar.getUsuarioEmprestimo().getCodigo() == codigoUsuario) {
                exemplar.devolver();
                return "Devolução realizada: " + usuario.getNome() + " devolveu o livro '" + livro.getTitulo() + "'.";
            }
        }

        return "Não há empréstimo em aberto para este livro e usuário.";
    }
}