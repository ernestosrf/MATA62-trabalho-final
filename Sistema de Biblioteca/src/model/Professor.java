package model;

import strategy.RegraEmprestimo;
import strategy.RegraProfessor;

public class Professor extends Usuario {
    public Professor(int codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public RegraEmprestimo getRegraEmprestimo() {
        return new RegraProfessor();
    }

    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE; // Sem limite de empréstimos
    }

    @Override
    public int getDiasEmprestimo() { return 8; }
}