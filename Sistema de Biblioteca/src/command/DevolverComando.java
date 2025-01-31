package command;

import gerenciador.Gerenciador;

public class DevolverComando implements IComando {
    @Override
    public void executar(String[] args) {
        int codigoUsuario = Integer.parseInt(args[1]);
        int codigoLivro = Integer.parseInt(args[2]);

        // Obtém a instância do gerenciador.Gerenciador
        Gerenciador gerenciador = Gerenciador.getInstance(null); // O banco de dados já foi injetado na fábrica
        gerenciador.devolverLivro(codigoUsuario, codigoLivro);
    }
}