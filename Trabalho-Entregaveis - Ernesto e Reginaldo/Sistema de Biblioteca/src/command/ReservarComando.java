package command;

import service.Gerenciador;

public class ReservarComando implements IComando {
    private Gerenciador gerenciadorService;
    private int codigoUsuario;
    private int codigoLivro;

    public ReservarComando(Gerenciador gerenciadorService, int codigoUsuario, int codigoLivro) {
        this.gerenciadorService = gerenciadorService;
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String execute() {
        return gerenciadorService.reservarLivro(codigoUsuario, codigoLivro);
    }
}