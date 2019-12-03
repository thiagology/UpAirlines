package projetoUp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6542277849222379451L;
	
	private String login;
	private String senha;
	
	public Cliente(String nome,
					String cpf,
					String rg,
					int telefone,
					String string,
					LocalDate nascimento,
					String login, String senha) {
		
		super(nome, cpf, rg, telefone, string, nascimento, false);
		
		this.login = login;
		this.senha = senha;
	}

		

	public String getEmail() {
		return login;
	}

	public void setEmail(String email) {
		this.login = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean equals(Cliente cliente) {
		if(this.getNome().equals(cliente.getNome()) && this.getCpf().equals(cliente.getCpf()))
		{
			return true;
		}
		else {
			return false;
		}
	}

}
