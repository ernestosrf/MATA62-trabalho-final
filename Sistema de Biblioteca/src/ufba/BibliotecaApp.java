package ufba;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Gerenciador gerenciador = Fabrica.getInstanciaGerenciador();
        Invocador invocador = Fabrica.getInstanciaInvocador();
        Scanner scanner = new Scanner(System.in);
        IBancoDeDados BancoDeDados = Fabrica.getInstanciaBancoDeDados();
        
        // Adicionando dados de usuarios
        BancoDeDados.cadastrarDados();
        

        System.out.println("Sistema de Biblioteca. Digite um comando ou 'sair' para encerrar:");
        while (true) {
            System.out.print("> ");
            String comando = scanner.nextLine();
            if (comando.equalsIgnoreCase("sair")) {
                break;
            }
            invocador.executarComando(comando);
        }
        scanner.close();
    }
}
