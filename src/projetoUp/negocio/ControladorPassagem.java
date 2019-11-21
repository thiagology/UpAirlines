package projetoUp.negocio;

import projetoUp.dados.RepositorioPassagem;

public class ControladorPassagem {
	private RepositorioPassagem repositorioPassagem;
	
	private static ControladorPassagem instance;
	
	public static ControladorPassagem getInstance() {
		if(instance == null) {
			instance = new ControladorPassagem();
		}
		return instance;
	}
}
