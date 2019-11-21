package projetoUp.model;

import java.time.LocalDate;

public class Gerente extends Funcionario implements Login{
	private String email;
	private String senha;
	
	public Gerente(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	public Gerente(String email, String senha, String nome, String cpf, String rg, int telefone, Endereco endereco, LocalDate nascimento,
			int id, LocalDate contratacao, String funcao) {
		super(nome, cpf, rg, telefone, endereco, nascimento, id, contratacao, funcao);
		
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
	
	@Override
	public void fazerLogin() {
	}
	
	
	
}
