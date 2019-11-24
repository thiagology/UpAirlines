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
			if(v.getHorarioDeSaida().isAfter(v.getHorarioDeChegada())) { //hora de saida nao pode ser antes da de chegada
				if(!(v.getAeroportoDeDestino().equals(v.getAeroportoDeOrigem()))){
					this.repositorioVoo.criarVoo(v);
					this.repositorioVoo.salvarArquivo();
				}
			}
		}
	}
	
	public void removerVoo(Voo v) {
		if(v != null) {
			if(v.getPassageiros() == null) {
				//se nao houver passagens vendidas
				this.repositorioVoo.removerVoo(v);
				this.repositorioVoo.salvarArquivo();
			}
		}
	}
	
	
	public void alterarVoo(Voo v) {
		if(v != null) {
			//atualiza só a hora de chegada e só se ela for depois da de saida
			this.repositorioVoo.alterarVoo(v);
			this.repositorioVoo.salvarArquivo();
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
