package service;

import model.*;
import observer.IObservador;
import observer.ProfessorObservador;
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

        RegraEmprestimo regra = usuario.getRegraEmprestimo();
        if (!regra.podeEmprestar(usuario, livro)) {
            return "Falha no empréstimo para " + usuario.getNome() + ": " + regra.getMensagemErro();
        }

        cancelarReservaSeExistir(usuario, livro);

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

                Emprestimo emprestimo = exemplar.getEmprestimo();
                emprestimo.finalizarEmprestimo();

                usuario.finalizarEmprestimo(emprestimo);

                exemplar.devolver();

                usuario.getEmprestimosAtivos().removeIf(e ->
                        e.getExemplar().equals(exemplar)
                );

                return "Devolução realizada: " + usuario.getNome() + " devolveu o livro '" + livro.getTitulo() + "'.";
            }
        }

        return "Não há empréstimo em aberto para este livro e usuário.";
    }

    public String consultarLivro(int codigoLivro) {
        Livro livro = buscarLivro(codigoLivro);
        if (livro == null) return "Livro não encontrado.";

        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(livro.getTitulo()).append("\n");
        sb.append("Reservas: ").append(livro.getReservas().size()).append("\n");

        if (!livro.getReservas().isEmpty()) {
            sb.append("Reservado por:\n");
            livro.getReservas().forEach(r ->
                    sb.append("- ").append(r.getUsuario().getNome()).append("\n"));
        }

        sb.append("Exemplares:\n");
        livro.getExemplares().forEach(e -> {
            sb.append("- Código: ").append(e.getCodigo())
                    .append(", Disponível: ").append(e.getStatus());
            if (!e.getStatus()) {
                sb.append(", Emprestado para: ")
                        .append(e.getUsuarioEmprestimo().getNome())
                        .append(", Data Empréstimo: ")
                        .append(e.getEmprestimo().getDataEmprestimo())
                        .append(", Devolução Prevista: ")
                        .append(e.getEmprestimo().getDataDevolucaoPrevista());
            }
            sb.append("\n");
        });

        return sb.toString();
    }

    public String consultarUsuario(int codigoUsuario) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null) return "Usuário não encontrado.";

        StringBuilder sb = new StringBuilder();
        sb.append("Usuário: ").append(usuario.getNome()).append("\n");

        // Empréstimos Ativos
        sb.append("=== Empréstimos Ativos ===\n");
        usuario.getEmprestimosAtivos().forEach(e -> {
            sb.append("- Livro: ").append(e.getExemplar().getLivro().getTitulo())
                    .append(", Data Empréstimo: ").append(e.getDataEmprestimo())
                    .append(", Status: ").append(e.getStatus())
                    .append(", Devolução Prevista: ").append(e.getDataDevolucaoPrevista())
                    .append("\n");
        });

        // Empréstimos Inativos (Passados)
        sb.append("\n=== Empréstimos Passados ===\n");
        usuario.getEmprestimosInativos().forEach(e -> {
            sb.append("- Livro: ").append(e.getExemplar().getLivro().getTitulo())
                    .append(", Data Empréstimo: ").append(e.getDataEmprestimo())
                    .append(", Status: ").append(e.getStatus())
                    .append(", Devolução Realizada: ").append(e.getDataDevolucaoRealizada())
                    .append("\n");
        });

        sb.append("Reservas:\n");
        usuario.getReservas().forEach(r -> {
            sb.append("- Livro: ").append(r.getLivro().getTitulo())
                    .append(", Data Reserva: ").append(r.getDataReserva())
                    .append("\n");
        });

        return sb.toString();
    }

    public String consultarNotificacoes(int codigoUsuario) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null) return "Usuário não encontrado.";

        if (usuario instanceof Professor) {
            IObservador observador = usuario.getObservador();

            if (observador == null) return "O usuário " + usuario.getNome() + " não está observando nenhum livro.";

            return "Notificações recebidas: " + observador.getContadorNotificacoes();
        }
        return "Este usuário não tem permissão de observar livros.";
    }

    public String adicionarObservador(int codigoUsuario, int codigoLivro) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        Livro livro = buscarLivro(codigoLivro);

        if (usuario == null || livro == null) {
            return "Usuário ou livro não encontrado.";
        }

        ProfessorObservador observador = (ProfessorObservador) usuario.getObservador();

        if (observador == null) {
            observador = new ProfessorObservador(usuario);
            usuario.setObservador(observador);
        }

        if (!livro.getObservadores().contains(observador)) {
            livro.adicionarObservador(observador);
        }

        return "Observador registrado para " + usuario.getNome() + " no livro " + livro.getTitulo();
    }
}