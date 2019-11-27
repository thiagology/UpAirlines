package projetoUp.dados;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cliente;

public interface IRepositorioCliente {
	
	boolean criarConta(Cliente c) throws JaExisteException, NaoExisteException;
	
	boolean excluirConta(Cliente c) throws NaoExisteException;
	
	boolean loginExiste(String login, String senha) throws NaoExisteException;
	
	Cliente buscarCliente(String login, String senha) throws NaoExisteException;
	
	Cliente buscarCliente(Cliente c) throws NaoExisteException;
	
	
	void salvarArquivo();
	

}
