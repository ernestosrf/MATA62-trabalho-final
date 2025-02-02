package observer;

public class ProfessorObservador implements IObservador {
    private int codigo;
    private String nome;
    private int contadorNotificacoes;

    public ProfessorObservador(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.contadorNotificacoes = 0;
    }

    @Override
    public void notificar(String mensagem) {
        contadorNotificacoes++;
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }

    public int getContadorNotificacoes() {
        return contadorNotificacoes;
    }
}