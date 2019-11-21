package projetoUp.negocio;

import projetoUp.dados.RepositorioAeroporto;

public class ControladorAeroporto {
	private RepositorioAeroporto repositorioAeroporto;
	
	private static ControladorAeroporto instance;
	
	public static ControladorAeroporto getInstance() {
		if(instance == null) {
			instance = new ControladorAeroporto();
		}
		return instance;
	}
}
