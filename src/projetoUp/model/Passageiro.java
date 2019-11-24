package projetoUp.model;

import java.time.LocalDate;

public class Passageiro extends Cliente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5857614249938529733L;
	private Assento assento;
	private boolean checkIn = false;
	private String codigoVoo;

	public Passageiro(String nome,
			String cpf,
			String rg,
			int telefone,
			Endereco endereco,
			LocalDate nascimento,
			float renda, float limite,Passagem passagens,
			String login, String senha) {
		super(nome,cpf,
				rg, telefone, endereco, nascimento,passagens,
				login, senha);
		// TODO Auto-generated constructor stub
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}

	public String getCodigoVoo() {
		return codigoVoo;
	}

	public void setCodigoVoo(String codigoVoo) {
		this.codigoVoo = codigoVoo;
	}
	
	public void checkIn()
	{
		this.setCheckIn(true);
	}
	
}
