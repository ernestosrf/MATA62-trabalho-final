package observer;

public interface IObservador {
    void notificar(String livroTitulo);
    int getContadorNotificacoes();
}