package ufba;
class AlunoPosGraduacao extends Usuario implements IEmprestimo{
	private static final int limiteEmprestimo = 3;
    private static final int tempoEmprestimo = 5;
    
    public AlunoPosGraduacao(String id, String nome, boolean atraso) {
    	super(id, nome, atraso);
    }

    @Override
	public boolean emprestimoValido(Livro livro) {
		// TODO Auto-generated method stub
		return false;
	}
}