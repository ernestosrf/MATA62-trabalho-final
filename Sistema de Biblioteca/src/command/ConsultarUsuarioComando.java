package command;

import model.Usuario;
import service.Gerenciador;

public class ConsultarUsuarioComando implements IComando {
    private Gerenciador service;
    private int codigoUsuario;

    public ConsultarUsuarioComando(Gerenciador service, int codigoUsuario) {
        this.service = service;
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String execute() {
        return service.consultarUsuario(codigoUsuario);
    }
}