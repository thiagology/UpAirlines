package projetoUp.negocio;

import java.util.List;

import projetoUp.dados.RepositorioPassagem;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;

public class ControladorPassagem {
	private RepositorioPassagem repositorioPassagem;
	
	private static ControladorPassagem instance;
	
	public static ControladorPassagem getInstance() {
		if(instance == null) {
			instance = new ControladorPassagem();
		}
		return instance;
	}
	
	public void criarPassagem(Passagem p) {
		if(p != null) {
			if(p.getPassageiro() != null && p.getVoo()!= null) {
				repositorioPassagem.criarPassagem(p);
			}
		}
	}
	
	public void excluirPassagem(Passagem p) {
		if(p!= null) {
			repositorioPassagem.excluirPassagem(p);
		}
	}
	
	public void alterarPassagem(Passagem p) {
		if(p != null) {
			repositorioPassagem.alterarPassagem(p);			
		}
	}
	
	public void buscarPassagem(String c) {
		if(c != null) {
			repositorioPassagem.buscarPassagem(c);
		}
	}

	public List<Passagem> listarPorPassageiro(Passageiro pa) {
		return repositorioPassagem.listarPorPassageiro(pa);
	}
	
	
	
	
	
}
