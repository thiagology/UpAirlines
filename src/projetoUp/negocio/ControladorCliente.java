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
				this.repositorioCliente.criarConta(c);
				this.repositorioCliente.salvarArquivo();
			}
		}
	}
	
	public void excluirConta(Cliente c) {
		if(c != null) {
			this.repositorioCliente.excluirConta(c);
			this.repositorioCliente.salvarArquivo();
		}
	}
	
	public void buscarConta(String email) {
		if(email != null) {
			repositorioCliente.buscarCliente(email);
		}
	}
}
