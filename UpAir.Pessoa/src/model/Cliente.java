package model;

import java.time.LocalDate;

public class Cliente extends Pessoa {

	public Cliente(String nome, String cpf, String rg, int telefone, Endereco endereco, LocalDate nascimento) {
		super(nome, cpf, rg, telefone, endereco, nascimento);
		// TODO Auto-generated constructor stub
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

}
