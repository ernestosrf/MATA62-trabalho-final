package gerenciador;

import command.DevolverComando;
import command.EmprestarComando;
import command.IComando;

import java.util.HashMap;
import java.util.Map;

public class Invocador {
    private Map<String, IComando> comandos;
    private Gerenciador gerenciador;

    public Invocador(Gerenciador gerenciador) {
        this.gerenciador = gerenciador;
        comandos = new HashMap<>();
        comandos.put("emp", new EmprestarComando());
        comandos.put("dev", new DevolverComando());
    }

    public void executarComando(String comandoStr) {
        String[] partes = comandoStr.split(" ");
        String comandoChave = partes[0];
        IComando comando = comandos.get(comandoChave);
        if (comando != null) {
            comando.executar(partes);
        } else {
            System.out.println("Comando não reconhecido.");
        }
    }
}