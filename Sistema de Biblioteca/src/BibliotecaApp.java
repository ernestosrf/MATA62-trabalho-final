import command.DevolverComando;
import command.EmprestarComando;
import command.IComando;
import command.ReservarComando;
import model.*;
import service.Gerenciador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Gerenciador gerenciadorService = Gerenciador.getInstance();

        // Inicialização dos dados de teste
        Usuario joao = new AlunoGraduacao(123, "Ernesto Reis");
        Usuario luiz = new AlunoPosGraduacao(456, "Reginaldo Silva");
        Usuario pedro = new AlunoGraduacao(789, "Pedro Paulo");
        Usuario carlos = new Professor(100, "Claudio Sant'anna");

        gerenciadorService.adicionarUsuario(joao);
        gerenciadorService.adicionarUsuario(luiz);
        gerenciadorService.adicionarUsuario(pedro);
        gerenciadorService.adicionarUsuario(carlos);

        List<String> autores1 = new ArrayList<>();
            autores1.add("Ian Sommervile");
        Livro livro1 = new Livro(100, "Engenharia de Software", "Addison Wesley", autores1, "6ª", 2000);
            livro1.adicionarExemplar(new Exemplar(1, livro1));
            livro1.adicionarExemplar(new Exemplar(2, livro1));

        List<String> autores2 = new ArrayList<>();
            autores2.add("Grady Booch");
            autores2.add("James Rumbaugh");
            autores2.add("Ivar Jacobson");
        Livro livro2 = new Livro(101, "UML - Guia do Usuário", "Campus", autores2, "7ª", 2000);
            livro2.adicionarExemplar(new Exemplar(3, livro2));

        List<String> autores3 = new ArrayList<>();
        autores1.add("Marco Tulio Valente");
        Livro livro3 = new Livro(102, "Engenharia de Software Moderna", "Addison Wesley", autores1, "6ª", 2000);
        livro3.adicionarExemplar(new Exemplar(1, livro3));
        livro3.adicionarExemplar(new Exemplar(2, livro3));

            gerenciadorService.adicionarLivro(livro1);
            gerenciadorService.adicionarLivro(livro2);
            gerenciadorService.adicionarLivro(livro3);

        System.out.println("Bem-vindo ao Sistema de Biblioteca!");
        System.out.println("Comandos disponíveis: \n " +
                "emp <código_usuario> <código_livro> \n " +
                "dev <código_usuario> <código_livro> \n " +
                "res <código_usuario> <código_livro> \n " +
                "sai");
        Scanner scanner = new Scanner(System.in);
            while (true) {
            System.out.println("Digite um comando:");
            String comando = scanner.next();

            if (comando.equals("sai")) {
                break;
            }

            int codigoUsuario = scanner.nextInt();
            int codigoLivro = scanner.nextInt();

            IComando command = null;
                switch (comando) {
                    case "emp":
                        command = new EmprestarComando(gerenciadorService, codigoUsuario, codigoLivro);
                        break;
                    case "dev":
                        command = new DevolverComando(gerenciadorService, codigoUsuario, codigoLivro);
                        break;
                    case "res":
                        command = new ReservarComando(gerenciadorService, codigoUsuario, codigoLivro);
                        break;
                }

            if (command != null) {
                System.out.println(command.execute());
            }
        }

            scanner.close();
    }
}
