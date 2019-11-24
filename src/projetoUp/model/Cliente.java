package projetoUp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Cliente extends Pessoa implements Login, Serializable {
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
					Endereco endereco,
					LocalDate nascimento, Passagem passagens,
					String login, String senha) {
		
		super(nome, cpf, rg, telefone, endereco, nascimento, false);
		
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

	
	public void fazerLogin() {
		//funcao de login
	}

	

}
