package command;

import service.Gerenciador;

public class ConsultarLivroComando implements IComando {
    private Gerenciador service;
    private int codigoLivro;

    public ConsultarLivroComando(Gerenciador service, int codigoLivro) {
        this.service = service;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String execute() {
        return service.consultarLivro(codigoLivro);
    }
}