package projetoUp.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	public void criarPassagem(String codigo, Passageiro p, Voo v, int AssentoLinha, int AssentoColuna, String idA) {
		if(p != null && codigo != null && v != null && AssentoColuna != 0 && AssentoLinha != 0 ) {
			if(v.getHorarioDeSaida().isAfter(v.getHorarioDeChegada())) {
				if(p.getCpf() != null || p.getRg() != null) {
					Passagem pas = new Passagem(codigo, p, v);
					p.setAssento(pas.getVoo().reservarAssento(idA));
					repositorioPassagem.criarPassagem(pas);
				}
			}
		}
	}
	
	public void excluirPassagem(Passagem p) {
		if(p!= null) {
			if(p.getVoo().getHorarioDeSaida().isAfter(LocalDateTime.now())); //se o voo já partiu
			//libera o assento de volta no voo
			
			p.getVoo().liberarAssento(p.getPassageiro().getAssento().getId());
		
			repositorioPassagem.excluirPassagem(p);
		}
	}
	
	public void alterarPassagem(Passagem p, int idAssento) {
		if(p != null) {
			//verificar disponibilidade do assento
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
