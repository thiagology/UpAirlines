package projetoUp.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.exceptions.RotaNaoExiste;
import projetoUp.model.Cidades;
import projetoUp.model.Voo;

public class RepositorioVoo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8004505274795423L;
	ArrayList <Voo> voos;
	
	
	private static RepositorioVoo instance;
	
	
	 public static RepositorioVoo getInstance() {
		    if (instance == null) {
		      instance = lerDoArquivo();
		    }
		    return instance;
		  }

   
	private static RepositorioVoo lerDoArquivo() {
	 RepositorioVoo instanciaLocal = null;

	    File in = new File("src/voos.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    ArrayList<Voo> v = new ArrayList<>();
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioVoo) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioVoo(v);
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
		    File out = new File("src/voos.dat");
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
    
    public RepositorioVoo(ArrayList <Voo> voos)
    {
        super();
        this.voos = voos;
    }
    
    	//adiciona um voo ao repositorio
  		public void criarVoo(Voo v) throws JaExisteException, NaoExisteException, RotaNaoExiste{		
  		
  			if (codigoExiste(v.getcodigoVoo()) != true) {
  				 if(v.getDistancia() > 0) {
  					 this.voos.add(v);
  				 }
  				 
  				 else {
  					 throw new RotaNaoExiste(v.getDistancia());
  				 }
  			 }
  			
  			else {
  				throw new JaExisteException(v);
  			}

  		}
  		
  		//remove um voo do repositorio
  		public void removerVoo(Voo v) throws NaoExisteException {	
  		    if (codigoExiste(v.getcodigoVoo()) == true) {
  			   this.voos.remove(v);
  			}else{
  				throw new NaoExisteException(v);
  			}
  		}
  		
  		//retorna se um voo ja existe
  		public boolean codigoExiste(String codigo) throws NaoExisteException {
  			return buscarVoo(codigo) != null;
  		}
  		
  		public Voo buscarVoo(Cidades origem, Cidades destino, LocalDate data)
  		{
  			for (Voo voo : voos) {
				if(voo.getAeroportoDeOrigem() == origem && voo.getAeroportoDeDestino() == destino && voo.getDia() == data)
				{
					return voo;
				}
			}
  			return null;
  		}
  		
  		//busca um voo pelo codigo
  		public Voo buscarVoo(String codigo) throws NaoExisteException {
  			for(Voo v: this.voos) {
  				if(v.getcodigoVoo() == codigo) {
  					return v;
  				}else{
  	  				throw new NaoExisteException(v);
  	  			}
  			}
  			
  			return null;
  		}
  		
  		public void alterarVoo(Voo v) throws NaoExisteException {
  			if(voos.contains(v)) {
  				int indice = this.voos.indexOf(v);
  				this.voos.set(indice, v);
  			}else{
  				throw new NaoExisteException(v);
  			}
  		}
  		
  		public List<Voo> listar(){
  			return this.voos;
  		}
    
}
