package ufba;

import java.util.ArrayList;

public class BD implements IBancoDeDados {

	@Override
	public void cadastrarDados() {
		Gerenciador gerenciador = Fabrica.getInstanciaGerenciador();
		
		// cadastrando usuarios		
		gerenciador.adicionarUsuario(new AlunoGraduacao("123", "João da Silva", false));
        gerenciador.adicionarUsuario(new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues",true));
        gerenciador.adicionarUsuario(new Professor("100", "Carlos Lucena",false));
        
        // cadastrando livros e exemplares
        
        ArrayList<Autor> autores1 = new ArrayList<>();
        ArrayList<Autor> autores2 = new ArrayList<>();
        ArrayList<Autor> autores3 = new ArrayList<>();
        
        ArrayList<Exemplar> exemplares1 = new ArrayList<>();
        ArrayList<Exemplar> exemplares2 = new ArrayList<>();
        ArrayList<Exemplar> exemplares3 = new ArrayList<>();
        
        autores1.add(new Autor("Ian Sommervile"));
        autores2.add(new Autor("James Rumbaugh"));
        autores2.add(new Autor("Ivar Jacobson"));
        autores3.add(new Autor("Steve McConnell"));
        
        exemplares1.add(new Exemplar("01",true,"Engenharia de Software"));
        exemplares1.add(new Exemplar("02",true,"Engenharia de Software"));
        
        exemplares2.add(new Exemplar("03",true,"UML - Guia do Usuário"));
        
        exemplares3.add(new Exemplar("04",false,"Code Complete"));
        
        gerenciador.adicionarLivro(new Livro("100","Engenharia de Software","Addison Wesley",autores1,"6ª","2000",exemplares1));
        gerenciador.adicionarLivro(new Livro("101","UML - Guia do Usuário","Campus Grady Booch",autores2,"7ª","2000",exemplares2));
        gerenciador.adicionarLivro(new Livro("200","Code Complete","Microsoft Press",autores3,"2ª","2014",exemplares3));

        
	}

}
