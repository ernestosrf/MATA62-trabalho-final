package ufba;
import java.util.HashMap;
import java.util.Map;

class Invocador {
    
	private Map<String, IComando> comandos;
	
	public Invocador() {
        comandos = new HashMap<>();
        comandos.put("emp", new emprestarComando());
        comandos.put("dev", new devolverComando());
        comandos.put("res", new reservarComando());
        comandos.put("obs", new observarComando());
        comandos.put("liv", new consultarLivroComando());
        comandos.put("usu", new consultarUsuarioComando());
        comandos.put("ntf", new consultarNotificacoesComando());
    }
	
	public void executarComando(String comando) {
        String[] partes = comando.split(" ");
        String acao = partes[0];
        
    }

	public Map<String, IComando> getComandos() {
		return comandos;
	}

	public void setComandos(Map<String, IComando> comandos) {
		this.comandos = comandos;
	}
}

