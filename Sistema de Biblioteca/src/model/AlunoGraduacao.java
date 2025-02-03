package model;

import strategy.RegraAlunoGraduacao;
import strategy.RegraEmprestimo;

public class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(int codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public RegraEmprestimo getRegraEmprestimo() {
        return new RegraAlunoGraduacao();
    }

    @Override
    public int getLimiteEmprestimos() {
        return 2;
    }

    @Override
    public int getDiasEmprestimo() { return 4; }
}