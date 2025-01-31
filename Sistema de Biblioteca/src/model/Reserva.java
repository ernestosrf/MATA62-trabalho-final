package model;

import java.util.Date;

public class Reserva {
    private int codigoUsuario;
    private int codigoLivro;
    private Date dataReserva;

    public Reserva(int codigoUsuario, int codigoLivro, Date dataReserva) {
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
        this.dataReserva = dataReserva;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public Date getDataReserva() {
        return dataReserva;
    }
}