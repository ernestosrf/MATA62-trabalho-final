//package command;
//
//import gerenciador.Gerenciador;
//import model.Livro;
//import observer.ProfessorObservador;
//
//public class ObservarComando implements IComando {
//    @Override
//    public void executar(String[] args) {
//        int codigoUsuario = Integer.parseInt(args[1]);
//        int codigoLivro = Integer.parseInt(args[2]);
//
//        Gerenciador gerenciador = Gerenciador.getInstance(null);
//        Livro livro = gerenciador.buscarLivro(codigoLivro);
//
//        if (livro == null) {
//            System.out.println("model.Livro não encontrado.");
//            return;
//        }
//
//        ProfessorObservador observador = new ProfessorObservador(codigoUsuario);
//        livro.adicionarObservador(observador);
//
//        System.out.println("model.Professor " + codigoUsuario + " registrado como observador do livro " + livro.getTitulo() + ".");
//    }
//}