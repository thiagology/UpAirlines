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
	private ArrayList <Cliente> clientes;
	private static RepositorioCliente instance;
	
	 public static RepositorioCliente getInstance() {
		    if (instance == null) {
		      instance = lerDoArquivo();
		    }
		    return instance;
		  }

	

	 public RepositorioCliente(ArrayList<Cliente> clientes) {
			super();
			this.clientes = clientes;
	}


	 private static RepositorioCliente lerDoArquivo() {
		 RepositorioCliente instanciaLocal = null;

		    File in = new File("src/clientes.dat");
		    FileInputStream fis = null;
		    ObjectInputStream ois = null;
		    ArrayList<Cliente> clien = new ArrayList<>();
		    try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (RepositorioCliente) o;
		    } catch (Exception e) {
		      instanciaLocal = new RepositorioCliente(clien);
		    } finally {
		      if (ois != null) {
		        try {
		          ois.close();
		        } catch (IOException e) {/* Silent exception */
		        }
		      }
		    }

		    return instanciaLocal;
		  }
	
	public void salvarArquivo() {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("src/clientes.dat");
	    FileOutputStream fos = null;
	    ObjectOutputStream oos = null;

	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instance);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (oos != null) {
	        try {
	          oos.close();
	        } catch (IOException e) {
	          /* Silent */}
	      }
	    }
	  }


	//adiciona uma conta de cliente ao repositorio
	public boolean criarConta(Cliente c) {		
			 this.clientes.add(c);
		return true;
	}
	
	//remove uma conta do repositorio
	public boolean excluirConta(Cliente c) throws NaoExisteException {	
	    if (this.loginExiste(c.getEmail(), c.getSenha()) == true) {
		   this.clientes.remove(c);
		   return true;
		}
	   return false;
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

