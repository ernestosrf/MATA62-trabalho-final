package command;

import service.Gerenciador;

public class DevolverComando implements IComando {
    private Gerenciador gerenciadorService;
    private int codigoUsuario;
    private int codigoLivro;

    public DevolverComando(Gerenciador gerenciadorService, int codigoUsuario, int codigoLivro) {
        this.gerenciadorService = gerenciadorService;
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String execute() {
        return gerenciadorService.devolverLivro(codigoUsuario, codigoLivro);
    }
}