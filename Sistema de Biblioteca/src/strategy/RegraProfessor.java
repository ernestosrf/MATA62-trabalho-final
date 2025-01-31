package strategy;

import model.Usuario;
import model.Livro;
import gerenciador.Gerenciador;
import java.util.Date;
import java.util.Calendar;

public class RegraProfessor implements RegraEmprestimo {
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro, Gerenciador gerenciador) {
        return !gerenciador.verificarDebito(usuario.getCodigo());
    }

    @Override
    public Date calcularDataDevolucao(Date dataEmprestimo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataEmprestimo);
        cal.add(Calendar.DATE, 8);
        return cal.getTime();
    }
}