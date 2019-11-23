package projetoUp.negocio;

import java.util.List;

import projetoUp.dados.RepositorioPassagem;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;
import projetoUp.model.Voo;

public class ControladorPassagem {
	private RepositorioPassagem repositorioPassagem;
	
	private static ControladorPassagem instance;
	
	public static ControladorPassagem getInstance() {
		if(instance == null) {
			instance = new ControladorPassagem();
		}
		return instance;
	}
	
	public void criarPassagem(String codigo, Passageiro p, Voo v) {
		if(p != null && codigo != null && v != null) {
			if(v.getHorarioDeSaida().isAfter(v.getHorarioDeChegada())) {
				if(p.getCpf() != null || p.getRg() != null) {
					//marcar assento
					Passagem pas = null;
					repositorioPassagem.criarPassagem(pas);
				}
			}
		}
	}
	
	public void excluirPassagem(Passagem p) {
		if(p!= null) {
			//se o voo ainda nao partiu
			//libera o assento de volta no voo
			repositorioPassagem.excluirPassagem(p);
		}
	}
	
	public void alterarPassagem(Passagem p) {
		if(p != null) {
			//só o assentopode ser alterado
			//verificar disponibilidade
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
