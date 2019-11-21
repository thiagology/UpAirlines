package projetoUp.negocio;

import projetoUp.dados.RepositorioCliente;
import projetoUp.model.Cliente;

public class ControladorCliente {
	private RepositorioCliente repositorioCliente;
	
	private static ControladorCliente instance;
	
	public static ControladorCliente getInstance() {
		if(instance == null) {
			instance = new ControladorCliente();
		}
		return instance;
	}
	
	public void criarConta(Cliente c) {
		if(c != null) {
			if(c.getCpf() != null ) {
				repositorioCliente.criarConta(c);
			}
		}
	}
	
	public void excluirConta(Cliente c) {
		if(c != null) {
			repositorioCliente.excluirConta(c);
		}
	}
	
	public void buscarConta(String email) {
		if(email != null) {
			repositorioCliente.buscarCliente(email);
		}
	}
}
