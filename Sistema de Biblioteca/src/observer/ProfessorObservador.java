package observer;

public class ProfessorObservador implements IObservador {
    private int codigoProfessor;
    private int contadorNotificacoes;

    public ProfessorObservador(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
        this.contadorNotificacoes = 0;
    }

    @Override
    public void notificar(String mensagem) {
        contadorNotificacoes++;
        System.out.println("Notificação para professor " + codigoProfessor + ": " + mensagem);
    }

    public int getContadorNotificacoes() {
        return contadorNotificacoes;
    }
}