package command;

import service.Gerenciador;

public class EmprestarComando implements IComando {
    private Gerenciador gerenciadorService;
    private int codigoUsuario;
    private int codigoLivro;

    public EmprestarComando(Gerenciador gerenciadorService, int codigoUsuario, int codigoLivro) {
        this.gerenciadorService = gerenciadorService;
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String execute() {
        return gerenciadorService.emprestarLivro(codigoUsuario, codigoLivro);
    }
}