package projetoUp.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Funcionario;

public class RepositorioFuncionarios implements IRepositorioFuncionarios, Serializable {
	
	private static final long serialVersionUID = -3139706214755251108L;
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	
	private static RepositorioFuncionarios instance;
	
	
	 public static IRepositorioFuncionarios getInstance() {
		    if (instance == null) {
		      instance = lerDoArquivo();
		    }
		    return instance;
		  }
	 
	 private static RepositorioFuncionarios lerDoArquivo() {
		 RepositorioFuncionarios instanciaLocal = null;

		    File in = new File("funcionarios.dat");
		    FileInputStream fis = null;
		    ObjectInputStream ois = null;
		    ArrayList<Funcionario> func = new ArrayList<>();
		    try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (RepositorioFuncionarios) o;
		    } catch (Exception e) {
		      instanciaLocal = new RepositorioFuncionarios(func);
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
	    File out = new File("funcionarios.dat");
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
	
	public RepositorioFuncionarios(ArrayList<Funcionario> funcionarios)
	{
		this.funcionarios = funcionarios;
		
	}
	
	public Funcionario buscarFuncionario(Funcionario funcionario) throws NaoExisteException
	{
		for (Funcionario f : funcionarios) {
			if(f.equals(funcionario))
			{
				return f;
			}
		}
		
		return null;
	}
	
	public boolean funcionarioExiste(Funcionario funcionario) throws NaoExisteException
	{
		if(this.buscarFuncionario(funcionario) != null)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean addFuncionario(Funcionario fun)
	{
		if(this.funcionarioExiste(fun) != true)
		{
			this.funcionarios.add(fun);
			return true;
		}
		
		return false;	
	}
	
	public void removerFuncionario(Funcionario funcionario) throws NaoExisteException
	{
		if(this.funcionarioExiste(funcionario) == true) {
			this.funcionarios.remove(funcionario);
		}
	}
	
	
	

}
