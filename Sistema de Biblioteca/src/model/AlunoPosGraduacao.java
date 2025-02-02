package model;

import strategy.RegraAlunoPosGraduacao;
import strategy.RegraEmprestimo;

public class AlunoPosGraduacao extends Usuario {
    public AlunoPosGraduacao(int codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public RegraEmprestimo getRegraEmprestimo() {
        return new RegraAlunoPosGraduacao();
    }
    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }

    @Override
    public int getDiasEmprestimo() { return 5; }
}