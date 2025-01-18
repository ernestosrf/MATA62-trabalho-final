class AlunoGraduacao extends Usuario {
    private static final int LIMITE_EMPRESTIMOS = 2;

    public AlunoGraduacao(String id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        return livrosEmprestados.size() < LIMITE_EMPRESTIMOS;
    }
}