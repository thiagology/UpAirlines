package projetoUp.dados;

import java.util.ArrayList;

import projetoUp.model.Cliente;

public class RepositorioCliente {
	ArrayList <Cliente> clientes;

	public RepositorioCliente(ArrayList<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}
	
	//adiciona uma conta de cliente ao repostorio
	public boolean criarConta(Cliente c) {		
		 if (emailExiste(c.getEmail()) != true) {
			 this.clientes.add(c);
			 return true;
		 }
		return false;
	}
	
	//remove uma conta de cliente ao repositoria
	public boolean excluirConta(Cliente c) {	
	    if (emailExiste(c.getEmail()) == true) {
		   this.clientes.remove(c);
		   return true;
		}
	   return false;
	}
	
	//retorna se um email existe
	private boolean emailExiste(String email) {
		return buscarCliente(email) != null;
	}
	
	//busca um cliente pelo email
	public Cliente buscarCliente(String email) {
		for(Cliente c: this.clientes) {
			if(c.getEmail() == email) {
				return c;
			}
		}	
		return null;
	}
}

