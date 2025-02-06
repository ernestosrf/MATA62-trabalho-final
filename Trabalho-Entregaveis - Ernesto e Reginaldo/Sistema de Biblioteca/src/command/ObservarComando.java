package command;

import service.Gerenciador;

public class ObservarComando implements IComando {
    private Gerenciador service;
    private int codigoUsuario;
    private int codigoLivro;

    public ObservarComando(Gerenciador service, int codigoUsuario, int codigoLivro) {
        this.service = service;
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String execute() {
        return service.adicionarObservador(codigoUsuario, codigoLivro);
    }
}