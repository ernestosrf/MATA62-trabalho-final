package observer;

import model.Usuario;

public class ProfessorObservador implements IObservador {
    private Usuario professor;
    private int contadorNotificacoes;

    public ProfessorObservador(Usuario professor) {
        this.professor = professor;
        this.contadorNotificacoes = 0;
    }

    @Override
    public void notificar(String livroTitulo) {
        contadorNotificacoes++;
        System.out.println("Notificação para " + professor.getNome() +
                ": Livro '" + livroTitulo + "' tem mais de 2 reservas!");
    }

    @Override
    public int getContadorNotificacoes() {
        return contadorNotificacoes;
    }
}