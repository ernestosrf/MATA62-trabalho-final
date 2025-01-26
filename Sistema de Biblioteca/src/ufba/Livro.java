package ufba;
import java.util.ArrayList;
import java.util.List;

class Livro {
    private String codigo;
    private String titulo;
    private String editora;
    private String edicao;
    private String ano;
    private List<Exemplar> exemplares;
    private List<Autor> autores;
    private List<Reserva> reservas;
    private List<IObservador> observadores;

    public Livro(String codigo, String titulo, String editora, ArrayList<Autor> autores, String edicao, String ano, ArrayList<Exemplar> exemplares) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.ano = ano;
        this.exemplares = exemplares;
        this.reservas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void executarRegistroObservacao(IObservador observador) {
    	this.observadores.add(observador);
    }
    
    public void notificarObservacao() {
        for (IObservador observador : this.observadores) {
            observador.avisar();
        }
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar);
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void executarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}


	public List<IObservador> getObservadores() {
		return observadores;
	}
	
}