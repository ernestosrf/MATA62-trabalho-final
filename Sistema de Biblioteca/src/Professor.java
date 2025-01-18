class Professor extends Usuario {
    public Professor(String id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        return true;
    }
}