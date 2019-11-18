package projetoUp.dados;

import java.util.ArrayList;
import projetoUp.model.Passagem;

public class RepositorioPassagem {
	ArrayList <Passagem> passagens;

	public RepositorioPassagem(ArrayList<Passagem> passagens) {
		super();
		this.passagens = passagens;
	}
	
		//adiciona uma passagem ao repositorio
		public boolean criarPassagem(Passagem p) {		
			 if (codigoExiste(p.getCodigo()) != true) {
				 this.passagens.add(p);
				 return true;
			 }
			return false;
		}
		
		//remove uma passagem do repositorio
		public boolean excluirPassagem(Passagem p) {	
		    if (codigoExiste(p.getCodigo()) == true) {
			   this.passagens.remove(p);
			   return true;
			}
		   return false;
		}
		
		//retorna se uma passagem ja existe
		private boolean codigoExiste(String codigo) {
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
		
		//public boolean alterarPassagem
}
