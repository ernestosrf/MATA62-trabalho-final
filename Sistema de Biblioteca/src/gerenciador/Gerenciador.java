package gerenciador;

import database.IBancoDeDados;
import model.Livro;
import model.Reserva;
import model.Usuario;
import observer.ProfessorObservador;
import strategy.RegraAlunoGraduacao;
import strategy.RegraAlunoPosGraduacao;
import strategy.RegraEmprestimo;
import strategy.RegraProfessor;

import java.util.*;

public class Gerenciador {
    private Map<String, RegraEmprestimo> regrasEmprestimo;
    private static Gerenciador instance;
    private IBancoDeDados bancoDeDados;
    private List<Reserva> reservas;

    private Gerenciador(IBancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
        this.reservas = new ArrayList<>();
        this.regrasEmprestimo = new HashMap<>();
        inicializarRegrasEmprestimo();
    }

    private void inicializarRegrasEmprestimo() {
        regrasEmprestimo.put("Aluno de Graduação", new RegraAlunoGraduacao());
        regrasEmprestimo.put("Aluno de Pós-Graduação", new RegraAlunoPosGraduacao());
        regrasEmprestimo.put("Professor", new RegraProfessor());
    }

    public static Gerenciador getInstance(IBancoDeDados bancoDeDados) {
        if (instance == null) {
            instance = new Gerenciador(bancoDeDados);
        }
        return instance;
    }

    public boolean verificarDebito(int codigoUsuario) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        return usuario.getEmprestimosAtivos().stream()
                .anyMatch(e -> e.getDataDevolucao().before(new Date()));
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Livro buscarLivro(int codigoLivro) {
        return bancoDeDados.buscarLivro(codigoLivro);
    }

    public Usuario buscarUsuario(int codigoUsuario) {
        return bancoDeDados.buscarUsuario(codigoUsuario);
    }

    public List<Reserva> getReservasPorUsuario(int codigoUsuario) {
        List<Reserva> reservasUsuario = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoUsuario() == codigoUsuario) {
                reservasUsuario.add(reserva);
            }
        }
        return reservasUsuario;
    }

    public List<Reserva> getReservasPorLivro(int codigoLivro) {
        List<Reserva> reservasLivro = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoLivro() == codigoLivro) {
                reservasLivro.add(reserva);
            }
        }
        return reservasLivro;
    }

    public void cancelarReserva(int codigoUsuario, int codigoLivro) {
        reservas.removeIf(reserva -> reserva.getCodigoUsuario() == codigoUsuario && reserva.getCodigoLivro() == codigoLivro);
    }

    public boolean emprestarLivro(int codigoUsuario, int codigoLivro) {
        Usuario usuario = bancoDeDados.buscarUsuario(codigoUsuario);
        Livro livro = bancoDeDados.buscarLivro(codigoLivro);

        if (usuario == null || livro == null) {
            System.out.println("Usuário ou livro não encontrado.");
            return false;
        }

        RegraEmprestimo regra = regrasEmprestimo.get(usuario.getTipo());
        if (regra.podeEmprestar(usuario, livro, this)) {
            // Lógica de empréstimo (simplificada)
            System.out.println("Empréstimo realizado: " + usuario.getNome() + " pegou o livro '" + livro.getTitulo() + "'.");
            // usuario.adicionarEmprestimo(emprestimo);
            return true;
        } else {
            System.out.println("Empréstimo não permitido para o usuário " + usuario.getNome() + ".");
            return false;
        }
    }

    public boolean devolverLivro(int codigoUsuario, int codigoLivro) {
        Usuario usuario = bancoDeDados.buscarUsuario(codigoUsuario);
        Livro livro = bancoDeDados.buscarLivro(codigoLivro);

        if (usuario == null || livro == null) {
            System.out.println("Usuário ou livro não encontrado.");
            return false;
        }

        // Lógica de devolução (simplificada)
        System.out.println("Devolução realizada: " + usuario.getNome() + " devolveu o livro '" + livro.getTitulo() + "'.");
        return true;
    }

    public ProfessorObservador buscarObservador(int codigoUsuario) {
        // Implementar lógica para buscar observador (se necessário)
        return null;
    }

    public String getEmprestimosPorUsuario(int codigoUsuario) {
        return "1";
    }
}