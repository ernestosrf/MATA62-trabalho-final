import java.util.ArrayList;
import java.util.List;

class GerenciadorUsuarios {
    private static GerenciadorUsuarios instance;
    private List<AlunoGraduacao> alunos;
    private List<AlunoPosGraduacao> alunosPos;
    private List<Professor> professores;

    private GerenciadorUsuarios() {
        alunos = new ArrayList<>();
        alunosPos = new ArrayList<>();
        professores = new ArrayList<>();
    }

    public static GerenciadorUsuarios getInstance() {
        if (instance == null) {
            instance = new GerenciadorUsuarios();
        }
        return instance;
    }

    public Usuario encontrarUsuario(String id) {
        for (Usuario usuario : alunos) {
            if (usuario.getId().equals(id)) return usuario;
        }
        for (Usuario usuario : alunosPos) {
            if (usuario.getId().equals(id)) return usuario;
        }
        for (Usuario usuario : professores) {
            if (usuario.getId().equals(id)) return usuario;
        }
        return null;
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario instanceof AlunoGraduacao) {
            alunos.add((AlunoGraduacao) usuario);
        } else if (usuario instanceof AlunoPosGraduacao) {
            alunosPos.add((AlunoPosGraduacao) usuario);
        } else if (usuario instanceof Professor) {
            professores.add((Professor) usuario);
        }
    }
}