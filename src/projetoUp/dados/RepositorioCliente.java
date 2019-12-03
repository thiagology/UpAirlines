package projetoUp.dados;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cliente;


public class RepositorioCliente implements Serializable {

	
	private static final long serialVersionUID = 523021474381236478L;
	private static ArrayList <Cliente> clientes;
	private static RepositorioCliente instance;
	
    public static RepositorioCliente getInstance() {
        if (instance == null) {
            instance = new RepositorioCliente();
        }
        return instance;
    }

	

	public RepositorioCliente() {
		
		lerLista();
	}


	//METODO PARA GRAVAR CLIENTES NO ARQUIVO
			public void gravaLista(){
				try{
					FileOutputStream arqG2 = new FileOutputStream("src/clientes.dat");
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
			@SuppressWarnings("unchecked")
			public void lerLista(){		
				try {
					FileInputStream arqL2 = new FileInputStream("src/clientes.dat");
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
		lerLista();
		
		clientes.add(c);
		
		gravaLista();
	}
	
	//remove uma conta do repositorio
	public void excluirConta(Cliente c) throws NaoExisteException{	
		lerLista();
		clientes.remove(c);
		gravaLista();
	}

	//retorna se um email existe
	public boolean loginExiste(String login, String senha) throws NaoExisteException {
		return buscarCliente(login, senha) != null;
	}

	//busca um cliente pelo email
	public Cliente buscarCliente(String login, String senha) throws NaoExisteException{
		for(Cliente c: clientes) {
			if(c.getEmail().equals(login) && c.getSenha().equals(senha)) {
				return c;
			}
		}

		return null;
	}

	public Cliente buscarCliente(Cliente cliente) {
		for(Cliente c: clientes) {
			if(c.equals(cliente)) {
				return c;
			}
		}

		return null;
	}
}

