package projetoUp.dados;

import java.util.ArrayList;
import java.util.List;

import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;

public class RepositorioPassagem {
	ArrayList <Passagem> passagens;

	public RepositorioPassagem(ArrayList<Passagem> passagens) {
		super();
		this.passagens = passagens;
	}
	
		//adiciona uma passagem ao repositorio
		public void criarPassagem(Passagem p) {		
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
		
		public void alterarPassagem(Passagem p) {
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
}
