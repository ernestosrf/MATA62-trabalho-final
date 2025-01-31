package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private int codigo;
    private String nome;
    private String tipo;
    private List<Emprestimo> emprestimosAtivos = new ArrayList<>();

    public Usuario(int codigo, String nome, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimosAtivos.add(emprestimo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract int getLimiteEmprestimos();
}