package projetoUp.dados;

import projetoUp.model.Cliente;

public interface IRepositorioCliente {
	
	boolean criarConta(Cliente c);
	
	boolean excluirConta(Cliente c);
	
	boolean emailExiste(String email);
	
	Cliente buscarCliente(String email);
	
	void salvarArquivo();
	

}
