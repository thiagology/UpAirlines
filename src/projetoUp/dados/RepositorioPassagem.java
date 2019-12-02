package projetoUp.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;

public class RepositorioPassagem implements IRepositorioPassagem, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2454901913668053290L;
	ArrayList <Passagem> passagens;

	private static RepositorioPassagem instance;
	
	
	 public static RepositorioPassagem getInstance() {
		    if (instance == null) {
		      instance = lerDoArquivo();
		    }
		    return instance;
		  }
	 
	 private static RepositorioPassagem lerDoArquivo() {
		 RepositorioPassagem instanciaLocal = null;

		    File in = new File("passagens.dat");
		    FileInputStream fis = null;
		    ObjectInputStream ois = null;
		    ArrayList<Passagem> pass = new ArrayList<>();
		    try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (RepositorioPassagem) o;
		    } catch (Exception e) {
		      instanciaLocal = new RepositorioPassagem(pass);
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
	 
		    
		   
	
	public RepositorioPassagem(ArrayList<Passagem> passagens) {
		super();
		this.passagens = passagens;
	}
	
		//adiciona uma passagem ao repositorio
		public void criarPassagem(Passagem p) throws JaExisteException {		
			 if (codigoExiste(p.getCodigo()) != true) {
				 this.passagens.add(p);
			 }
		}
		
		//remove uma passagem do repositorio
		public void excluirPassagem(Passagem p) {	
		    if (codigoExiste(p.getCodigo()) == true) {
			   this.passagens.remove(p);
			}
		}
		
		//retorna se uma passagem ja existe
		public boolean codigoExiste(String codigo) {
			return buscarPassagem(codigo) != null;
		}
		
		//busca uma passagem pelo codigo
		public Passagem buscarPassagem(String codigo) {
			for(Passagem p: this.passagens) {
				if(p.getCodigo() == codigo) {
					return p;
				}
			}
			
			return null;
		}
		
		public void alterarPassagem(Passagem p) throws NaoExisteException{
			if(passagens.contains(p)) {
				int i = this.passagens.indexOf(p);
				this.passagens.set(i, p);
			}
		}
		
		public List <Passagem> listarPorPassageiro(Passageiro pa){
			List <Passagem> lista = new ArrayList<Passagem>();
			for(Passagem p : passagens) {
				if(p.getPassageiro().equals(pa)) {
					lista.add(p);
				}
			}
			return lista;
		}


		@Override
		public void salvarArquivo() {
			if (instance == null) {
			      return;
			    }
			    File out = new File("passagens.dat");
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
}
