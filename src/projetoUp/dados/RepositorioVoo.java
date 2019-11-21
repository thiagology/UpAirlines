package projetoUp.dados;

import java.util.ArrayList;
import java.util.List;

import projetoUp.model.Voo;

public class RepositorioVoo {
    ArrayList <Voo> voos;
    
    public RepositorioVoo(ArrayList <Voo> voos)
    {
        super();
        this.voos = voos;
    }
    
    	//adiciona um voo ao repositorio
  		public void criarVoo(Voo v) {		
  			 if (codigoExiste(v.getcodigoVoo()) != true) {
  				 this.voos.add(v);
  			 }
  		}
  		
  		//remove um voo do repositorio
  		public void removerVoo(Voo v) {	
  		    if (codigoExiste(v.getcodigoVoo()) == true) {
  			   this.voos.remove(v);
  			}
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
  		
  		public void alterarVoo(Voo v) {
  			if(voos.contains(v)) {
  				int indice = this.voos.indexOf(v);
  				this.voos.set(indice, v);
  			}
  		}
  		
  		public List<Voo> listar(){
  			return this.voos;
  		}
    
}
