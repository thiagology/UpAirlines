package projetoUp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Voo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -31560859852008073L;
	private Cidades aeroportoDeOrigem;
	private Cidades aeroportoDeDestino;
	private LocalTime horarioDeSaida;
	private LocalTime horarioDeChegada;
	private LocalDate data;
	private Assento[][] assentos;
	private List <Passageiro> passageiros;
	private Aviao aviao;
	private String codigoVoo;
	private Conexoes conexao;
	private int distancia;



	public Voo(Cidades cidades, Cidades cidades2, LocalTime horarioDeSaida,
			List<Passageiro> passageiros, String codigoVoo, LocalDate data) {
		super();
		this.aeroportoDeOrigem = cidades;
		this.aeroportoDeDestino = cidades2;
		this.horarioDeSaida = horarioDeSaida;
		this.horarioDeChegada = this.horarioDeSaida.plusHours(this.conexao.tempoViagem(this.aeroportoDeOrigem, 
				this.aeroportoDeDestino, this.aviao));
		this.passageiros = passageiros;
		this.assentos = new Assento[this.aviao.getLin()][this.aviao.getCol()];
		this.codigoVoo = codigoVoo;
		this.mapearAssentos();
		this.setDistancia(conexao.getDistancia(this.aeroportoDeOrigem, this.aeroportoDeDestino));
		this.setDia(data);


	}


	public Cidades getAeroportoDeOrigem() {
		return aeroportoDeOrigem;
	}



	public void setAeroportoDeOrigem(Cidades aeroportoDeOrigem) {
		this.aeroportoDeOrigem = aeroportoDeOrigem;
	}



	public Cidades getAeroportoDeDestino() {
		return aeroportoDeDestino;
	}



	public void setAeroportoDeDestino(Cidades aeroportoDeDestino) {
		this.aeroportoDeDestino = aeroportoDeDestino;
	}

	public LocalTime getHorarioDeSaida() {
		return horarioDeSaida;
	}

	public void setHorarioDeSaida(LocalTime horarioDeSaida) {
		this.horarioDeSaida = horarioDeSaida;
	}

	public LocalTime getHorarioDeChegada() {
		return horarioDeChegada;
	}

	public void setHorarioDeChegada(LocalTime horarioDeChegada) {
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

	public Passageiro buscarPassageiro(Passageiro p)
	{
		for (Passageiro passageiro : passageiros) {
			if (passageiro.equals(p))
			{
				return passageiro;
			}
		}
		return null;
	}

	public String getcodigoVoo()
	{
		return codigoVoo;
	}

	public void setcodigoVoo (String codigoVoo)
	{
		this.codigoVoo = codigoVoo;
	}

	public boolean setPassageiro(Passageiro passageiro)
	{
		return this.passageiros.add(passageiro);
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

	public Assento buscarAssento(String id)
	{
		for(int i = 0; i < this.aviao.getLin(); i++)
		{
			for(int j = 0; j < this.aviao.getCol(); j++)
			{
				if(this.assentos[i][j].getId() == id)
				{
					return assentos[i][j];
				}
			}
		}

		return null;
	}

	public Assento reservarAssento(String id){


		if(this.buscarAssento(id) != null)
		{
			this.buscarAssento(id).reservar();

			return this.buscarAssento(id);
		}
		return null;	
	}

	public void liberarAssento(String id){
		this.buscarAssento(id).cancelarReserva();
	}


	public String[][] mapaAssentos()
	{

		String[][] mapAssentos = new String[this.aviao.getLin()][this.aviao.getCol()];

		for(int i = 0; i < this.aviao.getLin(); i++)
		{
			for(int j = 0; j < this.aviao.getCol(); j++)
			{
				if(this.assentos[i][j].getOcupado())
				{
					mapAssentos[i][j] = assentos[i][j].getId() + " O  ";
				}
				else
				{
					mapAssentos[i][j] =  assentos[i][j].getId() + " V  ";
				}
			}
		}

		return mapAssentos;	
	}

	public void setDistancia(int distancia)
	{
		this.distancia = distancia;
	}

	public int getDistancia()
	{
		return this.distancia;
	}

	public LocalDate getDia() {
		return data;
	}

	public void setDia(LocalDate dia) {
		this.data = dia;
	}

	public boolean equals(Voo voo)
	{
		if(voo != null)
		{
			if(this.aeroportoDeOrigem.equals(voo.aeroportoDeOrigem) && this.aeroportoDeDestino.equals(voo.aeroportoDeDestino) &&
					this.data.equals(voo.data) && this.horarioDeSaida.equals(voo.getHorarioDeSaida()))
			{
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}



}
