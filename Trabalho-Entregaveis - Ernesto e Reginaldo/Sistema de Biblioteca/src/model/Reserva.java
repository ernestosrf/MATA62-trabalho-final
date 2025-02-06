package model;

import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataReserva;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = LocalDate.now();
    }

    // Getters
    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataReserva() { return dataReserva; }

    @Override
    public String toString() {
        return "Reserva{" +
                " usuario='" + usuario.getNome() + '\'' +
                ", livro='" + livro.getTitulo() + '\'' +
                '}';
    }

}