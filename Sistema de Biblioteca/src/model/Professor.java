package model;

import observer.IObservador;

public class Professor implements IObservador {
    private int codigo;
    private String nome;

    public Professor(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public void notificar(String string) {
        System.out.println("model.Professor " + nome + " notificado sobre o livro: ");
    }
}