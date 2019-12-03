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
			String endereco,
			LocalDate nascimento,
			float renda, float limite,
			String login, String senha) {
		super(nome,cpf,
				rg, telefone, endereco, nascimento,
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


	public boolean equals(Passageiro pass){
		if(pass != null) {

			if(this.getCpf().equals(pass.getCpf()) && this.getNome().equals(pass.getNome()))
			{
				return true;
			}

			else {
				return false;
			}
		}
		else return false;
	}

}
