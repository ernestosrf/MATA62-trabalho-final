//package command;
//
//import gerenciador.Gerenciador;
//import model.Livro;
//
//public class ConsultarLivroComando implements IComando {
//    @Override
//    public void executar(String[] args) {
//        int codigoLivro = Integer.parseInt(args[1]);
//
//        Gerenciador gerenciador = Gerenciador.getInstance(null);
//        Livro livro = gerenciador.buscarLivro(codigoLivro);
//
//        if (livro == null) {
//            System.out.println("model.Livro não encontrado.");
//            return;
//        }
//
//        System.out.println("Título: " + livro.getTitulo());
//        System.out.println("Reservas: " + gerenciador.getReservasPorLivro(codigoLivro).size());
//        // Exibir mais detalhes conforme necessário
//    }
//}