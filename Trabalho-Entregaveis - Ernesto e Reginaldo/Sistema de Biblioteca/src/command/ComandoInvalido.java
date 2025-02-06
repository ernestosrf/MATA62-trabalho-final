package command;

public class ComandoInvalido implements IComando {
    public ComandoInvalido() {
    }

    @Override
    public String execute() {
        return "Comando inválido!";
    }
}
