package ufba;
import java.util.ArrayList;
import java.util.List;

abstract class Usuario {
    protected String id;
    protected String nome;
    protected boolean atraso;
    protected List<Exemplar> exemplaresEmprestados;
    protected List<Reserva> reservas;

    public Usuario(String id, String nome, boolean atraso) {
        this.id = id;
        this.nome = nome;
        this.exemplaresEmprestados = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.atraso = atraso;
    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public List<Exemplar> getExemplaresEmprestados() {
        return exemplaresEmprestados;
    }

    public void setExemplar(Exemplar exemplar) {
		this.exemplaresEmprestados.add(exemplar);
	}
    
	public List<Reserva> getReservas() {
		return reservas;
	}


	public void setReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
    
}
