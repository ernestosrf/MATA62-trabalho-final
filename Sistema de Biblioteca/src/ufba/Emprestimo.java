package ufba;

import java.util.Date;

public class Emprestimo {
	private Livro livro;
	private Date data;
	private boolean emCurso;
	private Date dataDevolucao;
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isEmCurso() {
		return emCurso;
	}
	public void setEmCurso(boolean emCurso) {
		this.emCurso = emCurso;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}
