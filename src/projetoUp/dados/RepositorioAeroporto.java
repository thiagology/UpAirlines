package projetoUp.dados;
import java.util.Map;


import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class RepositorioAeroporto implements IRepositorioAeroporto ,Serializable{

	private static final long serialVersionUID = 1L;
	private Map<Cidades, Aeroporto> aeroportos;
	
	private static RepositorioAeroporto instance;
	
	

	
	
	public RepositorioAeroporto( Map<Cidades, Aeroporto> aeroportos)
	{
		
		this.aeroportos = aeroportos;
	}
	
	
	 public static IRepositorioAeroporto getInstance() {
		    if (instance == null) {
		      instance = lerDoArquivo();
		    }
		    return instance;
		  }
	
	private static RepositorioAeroporto lerDoArquivo() {
		 RepositorioAeroporto instanciaLocal = null;

		    File in = new File("aeroportos.dat");
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
	    File out = new File("aeroportos.dat");
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

	
	public void addAeroporto(Aeroporto aeroporto) {
		
		if(this.aeroportoExiste(aeroporto) != true)
		{
			this.aeroportos.put(aeroporto.getCidade(), aeroporto);
		}
	}
	
	public boolean aeroportoExiste(Aeroporto aeroporto)
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
	
	public Aeroporto buscarAeroporto(Cidades cidade)
	{
		return this.aeroportos.get(cidade);
	}
	
	public Map<Cidades, Aeroporto> getAeroportos()
	{
		return this.aeroportos;
	}
	
	public void apagarAeroporto(Aeroporto a) 
	{
		if(this.aeroportoExiste(a) == true) {
			this.aeroportos.remove(a.getCidade());
		}
	}
	


	
}
