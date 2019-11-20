package projetoUp.dados;

import java.util.ArrayList;
import projetoUp.model.Voo;

public class RepositorioVoo {
    ArrayList <Voo> voos;
    
    public RepositorioVoo(ArrayList <Voo> voos)
    {
        super();
        this.voos = voos;
    }
    
    	//adiciona um voo ao repositorio
  		public boolean criarVoo(Voo v) {		
  			 if (codigoExiste(v.getcodigoVoo()) != true) {
  				 this.voos.add(v);
  				 return true;
  			 }
  			return false;
  		}
  		
  		//remove um voo do repositorio
  		public boolean removerVoo(Voo v) {	
  		    if (codigoExiste(v.getcodigoVoo()) == true) {
  			   this.voos.remove(v);
  			   return true;
  			}
  		   return false;
  		}
  		
  		//retorna se um voo ja existe
  		private boolean codigoExiste(String codigo) {
  			return buscarVoo(codigo) != null;
  		}
  		
  		//busca um voo pelo codigo
  		public Voo buscarVoo(String codigo) {
  			for(Voo v: this.voos) {
  				if(v.getcodigoVoo() == codigo) {
  					return v;
  				}
  			}
  			
  			return null;
  		}
  		
  		public boolean alterarVoo(Voo v) {
  			if(voos.contains(v)) {
  				int indice = this.voos.indexOf(v);
  				this.voos.set(indice, v);
  				//verificar logica
  			}
  			
  			
  			return false;
  		}
    
}
