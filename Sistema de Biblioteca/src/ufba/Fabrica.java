package ufba;

public class Fabrica {
	public static Invocador getInstanciaInvocador() {
		return new Invocador();
	}
	public static IBancoDeDados getInstanciaBancoDeDados() {
		return new BD();
	}
	public static Gerenciador getInstanciaGerenciador() {
		return Gerenciador.getInstance();
	}
}
