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
	private Assento[][] assentos;
	List <Passageiro> passageiros;
	private Aviao aviao;
        private String codigoVoo;
        private Conexoes conexao;
        private int distancia;
        
        
	
	public Voo(Aeroporto aeroportoDeOrigem, Aeroporto aeroportoDeDestino, Funcionario piloto, Funcionario coPiloto,
			Funcionario comissario, LocalDateTime horarioDeSaida, LocalDateTime horarioDeChegada,
			List<Passageiro> passageiros, Aviao aviao, String codigoVoo, int distancia) {
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
		this.assentos = new Assento[this.aviao.getLin()][this.aviao.getCol()];
		this.codigoVoo = codigoVoo;
		this.mapearAssentos();
		this.setDistancia(conexao.getDistancia(this.aeroportoDeOrigem.getCidade(), this.aeroportoDeDestino.getCidade()));
		
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
	
	public Assento[][] getAssentos() {
		return assentos;
	}
	
	
	public String getcodigoVoo()
        {
            return codigoVoo;
        }
        
        public void setcodigoVoo (String codigoVoo)
        {
            this.codigoVoo = codigoVoo;
        }
      
    public void mapearAssentos()
    {
    	int qA = 1;
		for(int i = 0; i < this.aviao.getLin(); i++)
		{
			for(int j = 0; j < this.aviao.getCol(); j++)
			{
				switch (j) {
				case 0:
					
					this.getAssentos()[i][j].setId("A" + "-" + qA);
					break;
				case 1:
					this.getAssentos()[i][j].setId("B" + "-" + qA);
					break;
				case 2:
					this.getAssentos()[i][j].setId("C" + "-" + qA);
					break;
				case 3:
					this.getAssentos()[i][j].setId("D" + "-" + qA);
					break;

				default:
					break;
				}
				qA++;
			}
		}

    }
        
    public void reservarAssento(int linha, int coluna)
    	{
    		this.assentos[linha][coluna].reservar();
    	}
    
	
    public char[][] mapaAssentos()
	{
		
		char[][] mapAssentos = new char[this.aviao.getLin()][this.aviao.getCol()];
		
		for(int i = 0; i < this.aviao.getLin(); i++)
		{
			for(int j = 0; j < this.aviao.getCol(); j++)
			{
				if(this.assentos[i][j].getOcupado())
				{
					mapAssentos[i][j] = 'O';
				}
				else
				{
					mapAssentos[i][j] = 'V';
				}
			}
	    }
	
		return mapAssentos;	
	}
    
    public void setDistancia(int distancia)
    {
    	this.distancia = distancia;
    }

}
