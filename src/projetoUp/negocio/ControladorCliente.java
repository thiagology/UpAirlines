package projetoUp.negocio;

import projetoUp.dados.RepositorioCliente;

public class ControladorCliente {
	private RepositorioCliente repositorioCliente;
	
	private static ControladorCliente instance;
	
	public static ControladorCliente getInstance() {
		if(instance == null) {
			instance = new ControladorCliente();
		}
		return instance;
	}
}
