package projetoUp.dados;

import projetoUp.model.Cliente;

public interface IRepositorioCliente {
	
	boolean criarConta(Cliente c);
	
	boolean excluirConta(Cliente c);
	
	boolean loginExiste(String login, String senha);
	
	Cliente buscarCliente(String login, String senha);
	
	Cliente buscarCliente(Cliente c);
	
	
	void salvarArquivo();
	

}
