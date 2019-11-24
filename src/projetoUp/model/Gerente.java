package projetoUp.model;

import java.time.LocalDate;

public class Gerente extends Funcionario implements Login{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6080475143461416360L;
	private String usuario;
	private String senha;
	
	public Gerente(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.setAdm(true);
	}
	
	public Gerente(String usuario, String senha, String nome, String cpf, String rg, int telefone, Endereco endereco, LocalDate nascimento,
			int id, LocalDate contratacao, String funcao) {
		super(nome, cpf, rg, telefone, endereco, nascimento, id, contratacao, funcao);
		
		this.usuario = usuario;
		this.senha = senha;
		this.setAdm(true);
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
