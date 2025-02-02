package model;

import java.time.LocalDate;

public class Emprestimo {
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    public Emprestimo(Exemplar exemplar, Usuario usuario) {
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(usuario.getDiasEmprestimo());
    }

    // Getters
    public Exemplar getExemplar() { return exemplar; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
}