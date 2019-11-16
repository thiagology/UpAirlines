package projetoUp.model;

import java.time.LocalDateTime;
import java.util.List;

public class Voo {
	private Aeroporto aeroportoDeOrigem;
	private Aeroporto aeroportoDeDestino;
	private Funcionario piloto;
	private Funcionario coPiloto;
	private Funcionario comissario;
	private LocalDateTime horarioDeSaida;
	private LocalDateTime horarioDeChegada;
	List <Passageiro> passageiros;
	private Aviao aviao;
        private String codigoVoo;
	
	public Voo(Aeroporto aeroportoDeOrigem, Aeroporto aeroportoDeDestino, Funcionario piloto, Funcionario coPiloto,
			Funcionario comissario, LocalDateTime horarioDeSaida, LocalDateTime horarioDeChegada,
			List<Passageiro> passageiros, Aviao aviao, String codigoVoo) {
		super();
		this.aeroportoDeOrigem = aeroportoDeOrigem;
		this.aeroportoDeDestino = aeroportoDeDestino;
		this.piloto = piloto;
		this.coPiloto = coPiloto;
		this.comissario = comissario;
		this.horarioDeSaida = horarioDeSaida;
		this.horarioDeChegada = horarioDeChegada;
		this.passageiros = passageiros;
		this.aviao = aviao;
                this.codigoVoo = codigoVoo;
	}

	public Aeroporto getAeroportoDeOrigem() {
		return aeroportoDeOrigem;
	}

	public void setAeroportoDeOrigem(Aeroporto aeroportoDeOrigem) {
		this.aeroportoDeOrigem = aeroportoDeOrigem;
	}

	public Aeroporto getAeroportoDeDestino() {
		return aeroportoDeDestino;
	}

	public void setAeroportoDeDestino(Aeroporto aeroportoDeDestino) {
		this.aeroportoDeDestino = aeroportoDeDestino;
	}

	public Funcionario getPiloto() {
		return piloto;
	}

	public void setPiloto(Funcionario piloto) {
		this.piloto = piloto;
	}

	public Funcionario getCoPiloto() {
		return coPiloto;
	}

	public void setCoPiloto(Funcionario coPiloto) {
		this.coPiloto = coPiloto;
	}

	public Funcionario getComissario() {
		return comissario;
	}

	public void setComissario(Funcionario comissario) {
		this.comissario = comissario;
	}

	public LocalDateTime getHorarioDeSaida() {
		return horarioDeSaida;
	}

	public void setHorarioDeSaida(LocalDateTime horarioDeSaida) {
		this.horarioDeSaida = horarioDeSaida;
	}

	public LocalDateTime getHorarioDeChegada() {
		return horarioDeChegada;
	}

	public void setHorarioDeChegada(LocalDateTime horarioDeChegada) {
		this.horarioDeChegada = horarioDeChegada;
	}

	public List<Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
	
	public String getcodigoVoo()
        {
            return codigoVoo;
        }
        
        public void setcodigoVoo (String codigoVoo)
        {
            this.codigoVoo = codigoVoo;
        }
	
	
}
