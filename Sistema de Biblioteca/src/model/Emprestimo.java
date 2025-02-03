package model;

import java.time.LocalDate;

public class Emprestimo {
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoRealizada;

    public Emprestimo(Exemplar exemplar, Usuario usuario) {
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(usuario.getDiasEmprestimo());
    }

    public void finalizarEmprestimo() {
        this.dataDevolucaoRealizada = LocalDate.now();
    }

    public String getStatus() {
        return dataDevolucaoRealizada == null ? "Em curso" : "Finalizado";
    }

    public Exemplar getExemplar() { return exemplar; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public LocalDate getDataDevolucaoRealizada() { return dataDevolucaoRealizada; }
}