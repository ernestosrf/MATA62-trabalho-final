class ProcessadorComandos {
    public void executarComando(String comando) {
        String[] partes = comando.split(" ");
        String acao = partes[0];
        if (acao.equals("emp")) {
            Usuario usuario = GerenciadorUsuarios.getInstance().encontrarUsuario(partes[1]);
            Livro livro = GerenciadorLivros.getInstance().encontrarLivro(partes[2]);
            if (usuario != null && livro != null) {
                Comando emprestimo = new EmprestimoComando(usuario, livro);
                emprestimo.executar();
            } else {
                System.out.println("Usuário ou livro não encontrado.");
            }
        }
    }
}