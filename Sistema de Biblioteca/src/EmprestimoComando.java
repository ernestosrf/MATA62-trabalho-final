class EmprestimoComando implements Comando {
    private Usuario usuario;
    private Livro livro;

    public EmprestimoComando(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    @Override
    public void executar() {
        if (!usuario.podeEmprestar(livro)) {
            System.out.println("Empréstimo falhou: Limite de livros atingido ou restrições de usuário.");
            return;
        }
        if (livro.estaDisponivel()) {
            System.out.println("Empréstimo realizado para: " + usuario.getNome() + " - Livro: " + livro.getTitulo());
        } else {
            System.out.println("Empréstimo falhou: Livro indisponível.");
        }
    }
}