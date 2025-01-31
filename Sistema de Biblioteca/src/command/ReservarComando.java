package command;

import gerenciador.Gerenciador;
import model.Livro;
import model.Reserva;
import model.Usuario;

import java.util.Date;

public class ReservarComando implements IComando {
    @Override
    public void executar(String[] args) {
        int codigoUsuario = Integer.parseInt(args[1]);
        int codigoLivro = Integer.parseInt(args[2]);

        Gerenciador gerenciador = Gerenciador.getInstance(null);
        Usuario usuario = gerenciador.buscarUsuario(codigoUsuario);
        Livro livro = gerenciador.buscarLivro(codigoLivro);

        if (usuario == null || livro == null) {
            System.out.println("Usuário ou livro não encontrado.");
            return;
        }

        // Verifica se o usuário já atingiu o limite de reservas
        if (gerenciador.getReservasPorUsuario(codigoUsuario).size() >= 3) {
            System.out.println("Limite de reservas atingido para o usuário " + usuario.getNome() + ".");
            return;
        }

        // Cria a reserva
        Reserva reserva = new Reserva(codigoUsuario, codigoLivro, new Date());
        gerenciador.adicionarReserva(reserva);

        System.out.println("model.Reserva realizada: " + usuario.getNome() + " reservou o livro '" + livro.getTitulo() + "'.");
    }
}