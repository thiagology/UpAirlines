package projetoUp.dados;
import java.util.Map;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class RepositorioAeroporto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5343691457407554092L;

	private Map<Cidades, Aeroporto> aeroportos;
	
	private static RepositorioAeroporto instance;
	
	

	
	
	public RepositorioAeroporto( Map<Cidades, Aeroporto> aeroportos)
	{
		
		this.aeroportos = aeroportos;
	}
	
	
	 public static RepositorioAeroporto getInstance() {
		    if (instance == null) {
		      instance = lerDoArquivo();
		    }
		    return instance;
		  }
	
	private static RepositorioAeroporto lerDoArquivo() {
		 RepositorioAeroporto instanciaLocal = null;

		    File in = new File("src/aeroportos.dat");
		    FileInputStream fis = null;
		    ObjectInputStream ois = null;
		    Map<Cidades, Aeroporto> aero = null;
		    try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (RepositorioAeroporto) o;
		    } catch (Exception e) {
		      instanciaLocal = new RepositorioAeroporto(aero);
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
	    File out = new File("src/aeroportos.dat");
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

	
	public boolean addAeroporto(Aeroporto aeroporto)throws JaExisteException {
		
		try {
			if(this.aeroportoExiste(aeroporto) != true)
			{
				this.aeroportos.put(aeroporto.getCidade(), aeroporto);
				return true;
			}
		} catch (NaoExisteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean aeroportoExiste(Aeroporto aeroporto)throws NaoExisteException
	{
		if(this.buscarAeroporto(aeroporto.getCidade()) != null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public Aeroporto buscarAeroporto(Cidades cidade) throws NaoExisteException
	{
		return this.aeroportos.get(cidade);
	}
	
	public Map<Cidades, Aeroporto> getAeroportos()
	{
		return this.aeroportos;
	}
	
	public void apagarAeroporto(Aeroporto a) throws NaoExisteException
	{
		if(this.aeroportoExiste(a) == true) {
			this.aeroportos.remove(a.getCidade());
		}
	}
	


	
}
