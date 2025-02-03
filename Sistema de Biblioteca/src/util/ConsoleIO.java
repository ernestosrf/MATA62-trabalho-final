package util;

import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    public String lerComando() {
        System.out.print("\n> ");
        return scanner.nextLine();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirCabecalho() {
        System.out.println("Bem-vindo ao Sistema de Biblioteca!");
        System.out.println("""
            Comandos disponíveis:
             emp <código_usuario> <código_livro>
             dev <código_usuario> <código_livro>
             res <código_usuario> <código_livro>
             obs <código_usuario> <código_livro>
             liv <código_livro>
             usu <código_usuario>
             ntf <código_usuario>
             sai
            """);
    }

    public void fechar() {
        scanner.close();
    }
}