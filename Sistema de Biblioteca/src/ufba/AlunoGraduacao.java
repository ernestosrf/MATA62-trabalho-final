package ufba;
class AlunoGraduacao extends Usuario implements IEmprestimo{
    private static final int limiteEmprestimo = 2;
    private static final int tempoEmprestimo = 4;
    
    public AlunoGraduacao(String id, String nome, boolean atraso) {
        super(id, nome, atraso);
    }

	@Override
	public boolean emprestimoValido(Livro livro) {
		// TODO Auto-generated method stub
		return false;
	}

    
}