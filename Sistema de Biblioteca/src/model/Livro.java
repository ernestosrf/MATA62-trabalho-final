package model;

import observer.IObservador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Livro {
    private int codigo;
    private String titulo;
    private List<Exemplar> exemplares = new ArrayList<>();
    private String editora;
    private List<String> autores;
    private int edicao;
    private int anoPublicacao;
    private List<IObservador> observadores;
    private List<Reserva> reservas;

    public Livro(int codigo, String titulo, String editora, int edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.autores = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void adicionarObservador(IObservador observador) {
        observadores.add(observador);
    }

    public void notificarObservadores(String mensagem) {
        for (IObservador observador : observadores) {
            observadores.forEach(o -> o.notificar( mensagem));
        }
    }

    public void verificarReservas() {
        if (reservas.size() > 2) {
            notificarObservadores("Livro " + titulo + " tem mais de 2 reservas!");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Collection<Object> getExemplaresDisponiveis() {
        return List.of(1, 2,3);
    }
}