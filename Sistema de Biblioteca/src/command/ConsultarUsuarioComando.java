//package command;
//
//import gerenciador.Gerenciador;
//import model.Usuario;
//
//public class ConsultarUsuarioComando implements IComando {
//    @Override
//    public void executar(String[] args) {
//        int codigoUsuario = Integer.parseInt(args[1]);
//
//        Gerenciador gerenciador = Gerenciador.getInstance(null);
//        Usuario usuario = gerenciador.buscarUsuario(codigoUsuario);
//
//        if (usuario == null) {
//            System.out.println("Usuário não encontrado.");
//            return;
//        }
//
//        System.out.println("Nome: " + usuario.getNome());
//        System.out.println("Empréstimos: " + gerenciador.getEmprestimosPorUsuario(codigoUsuario));
//        System.out.println("Reservas: " + gerenciador.getReservasPorUsuario(codigoUsuario));
//    }
//}