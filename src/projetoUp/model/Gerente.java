package projetoUp.model;


public class Gerente extends Funcionario implements Login{
	private String email;
	private String senha;
	
	private Gerente(String email, String senha) {
		super();
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
