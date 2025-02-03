package strategy;

import model.*;

import java.time.LocalDate;

public class RegraAlunoGraduacao implements RegraEmprestimo {
    private String mensagemErro = "";


    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        mensagemErro = ""; // Reinicia a mensagem de erro

        if (usuarioJaTemEmprestimo(usuario, livro)) {
            mensagemErro = "Usuário já possui empréstimo de um exemplar deste livro.";
            return false;
        }
        if (!temExemplaresDisponiveis(livro)) {
            mensagemErro = "Não há exemplares disponíveis.";
            return false;
        }
        if (usuarioTemAtrasos(usuario)) {
            mensagemErro = "Usuário possui empréstimos em atraso.";
            return false;
        }
        if (excedeuLimiteEmprestimos(usuario)) {
            mensagemErro = "Limite de empréstimos atingido (máximo 2).";
            return false;
        }
        if (!verificarReservas(usuario, livro)) {
            mensagemErro = "O livro se encontra reservado.";
            return false;
        }

        return true;
    }

    private boolean temExemplaresDisponiveis(Livro livro) {
        return livro.getExemplares().stream().anyMatch(Exemplar::getStatus);
    }

    private boolean excedeuLimiteEmprestimos(Usuario usuario) {
        return usuario.getEmprestimosAtivos().size() >= 2;
    }

    private boolean usuarioTemAtrasos(Usuario usuario) {
        return usuario.getEmprestimosAtivos().stream()
                .anyMatch(e -> LocalDate.now().isAfter(e.getDataDevolucaoPrevista()));
    }

    private boolean verificarReservas(Usuario usuario, Livro livro) {
        long numReservas = livro.getReservas().size();
        long exemplaresDisponiveis = livro.getExemplares().stream()
                .filter(Exemplar::getStatus).count();
        if (numReservas < exemplaresDisponiveis) {
            return true;
        } else {
            return livro.getReservas().stream().anyMatch(r -> r.getUsuario().equals(usuario));
        }
    }

    private boolean usuarioJaTemEmprestimo(Usuario usuario, Livro livro) {
        return usuario.getEmprestimosAtivos().stream()
                .anyMatch(e -> e.getExemplar().getLivro().equals(livro));
    }

    @Override
    public String getMensagemErro() {
        return mensagemErro;
    }
}