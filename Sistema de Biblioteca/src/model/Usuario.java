package model;

import observer.IObservador;
import strategy.RegraEmprestimo;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private int codigo;
    private String nome;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimosAtivos = new ArrayList<>();
    private List<Emprestimo> emprestimosInativos = new ArrayList<>();
    private IObservador observador;

    public Usuario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimosAtivos.add(emprestimo);
    }

    public void finalizarEmprestimo(Emprestimo emprestimo) {
        emprestimosAtivos.remove(emprestimo);
        emprestimosInativos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimosAtivos.remove(emprestimo);
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public List<Emprestimo> getEmprestimosInativos() {
        return emprestimosInativos;
    }

    public abstract RegraEmprestimo getRegraEmprestimo();

    public abstract int getLimiteEmprestimos();

    public abstract int getDiasEmprestimo();

    public IObservador getObservador() {
        return observador;
    }

    public void setObservador(IObservador observador) {
        this.observador = observador;
    }
}