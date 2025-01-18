import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        GerenciadorUsuarios gerenciadorUsuarios = GerenciadorUsuarios.getInstance();
        GerenciadorLivros gerenciadorLivros = GerenciadorLivros.getInstance();

        // Adicionando alguns usuários e livros de exemplo
        gerenciadorUsuarios.adicionarUsuario(new AlunoGraduacao("123", "João"));
        gerenciadorUsuarios.adicionarUsuario(new AlunoPosGraduacao("124", "Maria"));
        gerenciadorUsuarios.adicionarUsuario(new Professor("125", "Dr. Silva"));

        gerenciadorLivros.adicionarLivro(new Livro("001", "Introdução à Programação", 3));
        gerenciadorLivros.adicionarLivro(new Livro("002", "Algoritmos Avançados", 1));

        ProcessadorComandos processador = new ProcessadorComandos();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Biblioteca. Digite um comando ou 'sair' para encerrar:");
        while (true) {
            System.out.print("> ");
            String comando = scanner.nextLine();
            if (comando.equalsIgnoreCase("sair")) {
                break;
            }
            processador.executarComando(comando);
        }
        scanner.close();
    }
}
