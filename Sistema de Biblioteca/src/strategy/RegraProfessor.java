package strategy;

import model.*;

import java.time.LocalDate;

public class RegraProfessor implements RegraEmprestimo {
    private String mensagemErro = "";

    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        mensagemErro = "";

        if (!temExemplaresDisponiveis(livro)) {
            mensagemErro = "Não há exemplares disponíveis.";
            return false;
        }
        if (usuarioTemAtrasos(usuario)) {
            mensagemErro = "Usuário possui empréstimos em atraso.";
            return false;
        }

        return true;
    }

    private boolean temExemplaresDisponiveis(Livro livro) {
        return livro.getExemplares().stream().anyMatch(Exemplar::getStatus);
    }

    private boolean usuarioTemAtrasos(Usuario usuario) {
        return usuario.getEmprestimosAtivos().stream()
                .anyMatch(e -> LocalDate.now().isAfter(e.getDataDevolucaoPrevista()));
    }

    @Override
    public String getMensagemErro() {
        return mensagemErro;
    }
}