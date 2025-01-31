package model;

public class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(int codigo, String nome) {
        super(codigo, nome, "Aluno de Graduação");
    }

    @Override
    public int getLimiteEmprestimos() {
        return 2;
    }
}