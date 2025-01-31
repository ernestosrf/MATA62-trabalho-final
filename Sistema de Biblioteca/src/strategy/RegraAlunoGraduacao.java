package strategy;

import model.Usuario;
import model.Livro;
import gerenciador.Gerenciador;
import java.util.Date;
import java.util.Calendar;

public class RegraAlunoGraduacao implements RegraEmprestimo {
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro, Gerenciador gerenciador) {
        return usuario.getEmprestimosAtivos().size() < 2 &&
                gerenciador.getReservasPorLivro(livro.getCodigo()).size() < livro.getExemplaresDisponiveis().size() &&
                !gerenciador.verificarDebito(usuario.getCodigo());
    }

    @Override
    public Date calcularDataDevolucao(Date dataEmprestimo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataEmprestimo);
        cal.add(Calendar.DATE, 4);
        return cal.getTime();
    }
}