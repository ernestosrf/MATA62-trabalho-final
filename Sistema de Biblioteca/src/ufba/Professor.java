package ufba;
class Professor extends Usuario implements IEmprestimo,IObservador{
    
	private static final int limiteEmprestimo = Integer.MAX_VALUE;
    private static final int tempoEmprestimo = 8;
    private int contador_notificacoes;
    
	public Professor(String id, String nome, boolean atraso) {
		super(id, nome, atraso);
        this.setContador_notificacoes(0);
    }

	@Override
	public void avisar() {
		setContador_notificacoes(getContador_notificacoes()+1) ;
		System.out.printf("Usuário %s foi notificado de a respeito de um livro observado.", nome);
		System.out.printf("Numero atual de notificacoes: %d.", getContador_notificacoes());
	}

	@Override
	public boolean emprestimoValido(Livro livro) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getContador_notificacoes() {
		return contador_notificacoes;
	}

	public void setContador_notificacoes(int contador_notificacoes) {
		this.contador_notificacoes = contador_notificacoes;
	}

	public static int getTempoemprestimo() {
		return tempoEmprestimo;
	}

	public static int getLimiteemprestimo() {
		return limiteEmprestimo;
	}

    
}