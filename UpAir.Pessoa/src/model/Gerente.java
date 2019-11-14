package model;

import java.time.LocalDate;

public class Gerente extends Funcionario {
	private String email;
	private String senha;
	
	public Gerente(int id, LocalDate contratacao, String funcao, String email, String senha) {
		super(id, contratacao, funcao);
		this.email = email;
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
