package projetoUp.model;

import java.time.LocalDate;

public class Passageiro extends Pessoa {
	
	private Assento assento;

	public Passageiro(String nome, String cpf, String rg, int telefone, Endereco endereco, LocalDate nascimento) {
		super(nome, cpf, rg, telefone, endereco, nascimento);
		// TODO Auto-generated constructor stub
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
	
	
}
