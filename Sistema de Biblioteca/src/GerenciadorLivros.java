import java.util.ArrayList;
import java.util.List;

class GerenciadorLivros {
    private static GerenciadorLivros instance;
    private List<Livro> livros;

    private GerenciadorLivros() {
        livros = new ArrayList<>();
    }

    public static GerenciadorLivros getInstance() {
        if (instance == null) {
            instance = new GerenciadorLivros();
        }
        return instance;
    }

    public Livro encontrarLivro(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) return livro;
        }
        return null;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
}