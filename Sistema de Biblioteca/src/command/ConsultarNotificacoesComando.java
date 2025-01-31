package command;

import gerenciador.Gerenciador;
import observer.ProfessorObservador;

public class ConsultarNotificacoesComando implements IComando {
    @Override
    public void executar(String[] args) {
        int codigoUsuario = Integer.parseInt(args[1]);

        Gerenciador gerenciador = Gerenciador.getInstance(null);
        ProfessorObservador observador = gerenciador.buscarObservador(codigoUsuario);

        if (observador == null) {
            System.out.println("model.Professor não encontrado ou não é observador.");
            return;
        }

        System.out.println("Notificações recebidas: " + observador.getContadorNotificacoes());
    }
}