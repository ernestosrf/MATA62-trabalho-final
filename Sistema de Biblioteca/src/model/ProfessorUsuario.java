package model;

public class ProfessorUsuario extends Usuario {
    public ProfessorUsuario(int codigo, String nome) {
        super(codigo, nome, "model.Professor");
    }

    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE; // Sem limite
    }
}