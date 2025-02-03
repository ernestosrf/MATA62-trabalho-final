package command;

import service.Gerenciador;

public class ConsultarNotificacoesComando implements IComando {
    private Gerenciador service;
    private int codigoUsuario;

    public ConsultarNotificacoesComando(Gerenciador service, int codigoUsuario) {
        this.service = service;
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String execute() {
        return service.consultarNotificacoes(codigoUsuario);
    }
}