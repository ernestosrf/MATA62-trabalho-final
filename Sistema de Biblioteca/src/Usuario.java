import java.util.ArrayList;
import java.util.List;

abstract class Usuario {
    protected String id;
    protected String nome;
    protected List<Livro> livrosEmprestados;

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    public abstract boolean podeEmprestar(Livro livro);

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
