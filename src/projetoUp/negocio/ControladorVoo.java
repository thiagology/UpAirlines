package projetoUp.negocio;

import projetoUp.dados.RepositorioVoo;
import projetoUp.model.Cidades;
import projetoUp.model.Conexoes;
import projetoUp.model.Funcionario;
import projetoUp.model.Passageiro;
import projetoUp.model.Voo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class ControladorVoo {
	 private static ControladorVoo instance;
	 private RepositorioVoo repositorioVoo;
	 private ControladorAeroporto aeroportos;
	 private Conexoes rota;
	 
	
	public static ControladorVoo getInstance() {
		if(instance == null) {
			instance = new ControladorVoo();
		}
		return instance;
	}
	
	public void marcarVoo(Cidades cidadeOrigem, Cidades cidadeDestino, Funcionario piloto, Funcionario coPiloto,
			Funcionario comissario, LocalDateTime horarioDeSaida, LocalDateTime horarioDeChegada,
			List<Passageiro> passageiros, String codigoVoo, int distancia, LocalDate data)
	{
		if(rota.getDistancia(cidadeOrigem, cidadeDestino) > 0)
		{
			Voo voo = new Voo(aeroportos.buscarAeroporto(cidadeOrigem), aeroportos.buscarAeroporto(cidadeDestino),
					piloto, coPiloto, comissario, horarioDeSaida, horarioDeChegada, passageiros,
					codigoVoo, distancia, data);
			this.criarVoo(voo);
		}
	}
	
	private void criarVoo(Voo v) {
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
	
	public Voo buscarVoo(Cidades origem, Cidades destino, LocalDate data) 
	{
		return this.repositorioVoo.buscarVoo(origem, destino, data);
		
	}
	 
	 
}
