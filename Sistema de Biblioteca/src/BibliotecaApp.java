import command.*;
import model.*;
import repository.BancoDeDadosEmMemoria;
import service.Gerenciador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.ConsoleIO;

public class BibliotecaApp {
    public static void main(String[] args) {
        Gerenciador gerenciador = BancoDeDadosEmMemoria.inicializar();
        ConsoleIO console = new ConsoleIO();

        console.exibirCabecalho();

        while(true) {
            String input = console.lerComando();
            String[] partes = input.split(" ");

            if(partes.length == 0) continue;

            String comando = partes[0];
            if(comando.equalsIgnoreCase("sai")) break;

            IComando command = criarCommand(comando, gerenciador, partes);
            if(command != null) {
                console.exibirMensagem(command.execute());
            } else {
                console.exibirMensagem("Comando inválido!");
            }
        }

        console.fechar();
    }

    private static IComando criarCommand(String comando, Gerenciador service, String[] partes) {
        try {
            return switch(comando.toLowerCase()) {
                case "emp", "dev", "res", "obs" -> criarCommandCom2Parametros(comando, service, partes);
                case "liv", "usu", "ntf" -> criarCommandCom1Parametro(comando, service, partes);
                default -> null;
            };
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return new ComandoInvalido();
        }
    }

    private static IComando criarCommandCom2Parametros(String comando, Gerenciador service, String[] partes) {
        int codigoUsuario = Integer.parseInt(partes[1]);
        int codigoLivro = Integer.parseInt(partes[2]);
        return switch(comando.toLowerCase()) {
            case "emp" -> new EmprestarComando(service, codigoUsuario, codigoLivro);
            case "dev" -> new DevolverComando(service, codigoUsuario, codigoLivro);
            case "res" -> new ReservarComando(service, codigoUsuario, codigoLivro);
            case "obs" -> new ObservarComando(service, codigoUsuario, codigoLivro);
            default -> null;
        };
    }

    private static IComando criarCommandCom1Parametro(String comando, Gerenciador service, String[] partes) {
        int codigo = Integer.parseInt(partes[1]);
        return switch(comando.toLowerCase()) {
            case "liv" -> new ConsultarLivroComando(service, codigo);
            case "usu" -> new ConsultarUsuarioComando(service, codigo);
            case "ntf" -> new ConsultarNotificacoesComando(service, codigo);
            default -> null;
        };
    }
}
