package model;

public class AlunoPosGraduacao extends Usuario {
    public AlunoPosGraduacao(int codigo, String nome) {
        super(codigo, nome, "Aluno de Pós-Graduação");
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }
}