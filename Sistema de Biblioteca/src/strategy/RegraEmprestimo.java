package strategy;

import model.Usuario;
import model.Livro;

public interface RegraEmprestimo {
    boolean podeEmprestar(Usuario usuario, Livro livro);
    String getMensagemErro();
}