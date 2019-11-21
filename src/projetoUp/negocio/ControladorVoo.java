package projetoUp.negocio;

import projetoUp.dados.RepositorioVoo;
import projetoUp.model.Voo;
import projetoUp.model.Conexoes;

public class ControladorVoo {
	 private static ControladorVoo instance;
	 private RepositorioVoo repositorioVoo;
	 private Conexoes rota;
	 
	
	public static ControladorVoo getInstance() {
		if(instance == null) {
			instance = new ControladorVoo();
		}
		return instance;
	}
	 
	public void criarVoo(Voo v) {
		if(v != null && this.rota.getDistancia(v.getAeroportoDeOrigem().getCidade(), v.getAeroportoDeDestino().getCidade()) > 0) {
			if(v.getHorarioDeSaida().isAfter(v.getHorarioDeChegada())) {
				if(!(v.getAeroportoDeDestino().equals(v.getAeroportoDeOrigem()))){
					repositorioVoo.criarVoo(v);
				}
			}
		}
	}
	
	public void removerVoo(Voo v) {
		if(v != null) {
			if(v.getPassageiros() == null) {
				repositorioVoo.removerVoo(v);
			}
		}
	}
	
	
	public void alterarVoo(Voo v) {
		if(v != null) {
			repositorioVoo.alterarVoo(v);
		}
	}
	
	public void listar() {
		repositorioVoo.listar();
	}
	
	public void buscarVoo(String codigo) {
		if(codigo != null) {
			repositorioVoo.buscarVoo(codigo);
		}
	}
	 
	 
}
