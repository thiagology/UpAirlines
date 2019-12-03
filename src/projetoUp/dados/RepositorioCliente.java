package projetoUp.dados;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cliente;

public class RepositorioCliente implements Serializable {

	
	private static final long serialVersionUID = 523021474381236478L;



	ArrayList <Cliente> clientes;



	

	public RepositorioCliente() {
		
		this.lerLista();
	}


	//METODO PARA GRAVAR CLIENTES NO ARQUIVO
			public void gravaLista(){
				try{
					FileOutputStream arqG2 = new FileOutputStream("clientes.dat");
					ObjectOutputStream objG2 = new ObjectOutputStream(arqG2);
					objG2.writeObject(clientes);
					arqG2.flush();
					objG2.flush();
					arqG2.close();
					objG2.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			//METODO PARA LER O ARQUIVO DOS CLIENTES
			public void lerLista(){		
				try {
					FileInputStream arqL2 = new FileInputStream("clientes.dat");
					ObjectInputStream objL2 = new ObjectInputStream(arqL2);
					clientes = (ArrayList<Cliente>) objL2.readObject();
					arqL2.close();
					objL2.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				
			}


	//adiciona uma conta de cliente ao repositorio
	public void criarConta(Cliente c) throws JaExisteException {		
		this.lerLista();
			this.clientes.add(c);
		this.gravaLista();
	}
	
	//remove uma conta do repositorio
	public void excluirConta(Cliente c) throws NaoExisteException{	
		this.lerLista();
			this.clientes.remove(c);
		this.gravaLista();
	}

	//retorna se um email existe
	public boolean loginExiste(String login, String senha) throws NaoExisteException {
		return buscarCliente(login, senha) != null;
	}

	//busca um cliente pelo email
	public Cliente buscarCliente(String login, String senha) throws NaoExisteException{
		for(Cliente c: this.clientes) {
			if(c.getEmail().equals(login) && c.getSenha().equals(senha)) {
				return c;
			}
		}

		return null;
	}

	public Cliente buscarCliente(Cliente cliente) {
		for(Cliente c: this.clientes) {
			if(c.equals(cliente)) {
				return c;
			}
		}

		return null;
	}
}

