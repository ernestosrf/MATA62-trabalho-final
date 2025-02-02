package model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private int codigo;
    private String titulo;
    private String editora;
    private List<String> autores;
    private String edicao;
    private int anoPublicacao;
    private List<Exemplar> exemplares;
    private List<Reserva> reservas;

    public Livro(int codigo, String titulo, String editora, List<String> autores, String edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Exemplar encontrarExemplarDisponivel() {
        return exemplares.stream()
                .filter(Exemplar::getStatus)
                .findFirst()
                .orElse(null);
    }
}