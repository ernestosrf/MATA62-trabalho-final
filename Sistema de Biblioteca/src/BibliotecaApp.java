import gerenciador.Gerenciador;
import gerenciador.Invocador;
import factory.Fabrica;

import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        Gerenciador gerenciador = fabrica.criarGerenciador();
        Invocador invocador = new Invocador(gerenciador);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Sistema de Biblioteca!");
        System.out.println("Comandos disponíveis: emp <código_usuario> <código_livro>, dev <código_usuario> <código_livro>, sai");

        while (true) {
            System.out.print("Digite um comando: ");
            String comandoStr = scanner.nextLine();

            if (comandoStr.equals("sai")) {
                System.out.println("Saindo do sistema...");
                break;
            }

            invocador.executarComando(comandoStr);
        }

        scanner.close();
    }
}
