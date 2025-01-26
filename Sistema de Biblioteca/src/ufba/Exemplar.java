package ufba;


public class Exemplar {
	private String codigo;
	private boolean disponivel;
	private String dataEmprestimo;
	private String dataDevolucao;
	private String nomeUsuario;
    private String tituloLivro;
    
   

    public Exemplar(String codigo, boolean disponivel, String tituloLivro) {
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.dataEmprestimo="";
        this.dataDevolucao="";
        this.nomeUsuario="";
        this.tituloLivro = tituloLivro;        
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getTituloLivro() {
        return this.tituloLivro;
    }
    
    public boolean getDisponivel() {
        return this.disponivel;
    }

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	
}
