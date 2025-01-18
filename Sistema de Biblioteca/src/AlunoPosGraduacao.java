class AlunoPosGraduacao extends Usuario {
    private static final int LIMITE_EMPRESTIMOS = 3;

    public AlunoPosGraduacao(String id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        return livrosEmprestados.size() < LIMITE_EMPRESTIMOS;
    }
}