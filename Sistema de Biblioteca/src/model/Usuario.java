package model;

import strategy.RegraEmprestimo;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private int codigo;
    private String nome;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimosAtivos = new ArrayList<>();

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

    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimosAtivos.remove(emprestimo);
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public abstract RegraEmprestimo getRegraEmprestimo();

    public abstract int getLimiteEmprestimos();

    public abstract int getDiasEmprestimo();
}