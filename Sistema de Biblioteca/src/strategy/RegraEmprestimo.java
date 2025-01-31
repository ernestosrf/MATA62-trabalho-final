package strategy;

import gerenciador.Gerenciador;
import model.Usuario;
import model.Livro;
import java.util.Date;

public interface RegraEmprestimo {
    boolean podeEmprestar(Usuario usuario, Livro livro, Gerenciador gerenciador);
    Date calcularDataDevolucao(Date dataEmprestimo);
}