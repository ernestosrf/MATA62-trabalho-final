package strategy;

import gerenciador.Gerenciador;
import model.Livro;
import model.Usuario;

import java.util.Date;

public class RegraAlunoPosGraduacao implements RegraEmprestimo {

    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro, Gerenciador gerenciador) {
        return false;
    }

    @Override
    public Date calcularDataDevolucao(Date dataEmprestimo) {
        return null;
    }
}