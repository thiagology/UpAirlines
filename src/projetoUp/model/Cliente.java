package projetoUp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Cliente extends Pessoa implements Login, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6542277849222379451L;
	private float renda;
	private float limite;
	private List<Passagem> passagens;
	private String email;
	private String senha;
	
	public Cliente(String nome,
					String cpf,
					String rg,
					int telefone,
					Endereco endereco,
					LocalDate nascimento,
					float renda, float limite,
					List<Passagem> passagens,
					String email, String senha) {
		
		super(nome, cpf, rg, telefone, endereco, nascimento);
		this.renda = renda;
		this.limite = limite;
		this.passagens = passagens;
		this.email = email;
		this.senha = senha;
	}

	public float getRenda() {
		return renda;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public List<Passagem> getPassagens() {
		return passagens;
	}

	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
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
		//funcao de login
	}

	public float calcularLimite(float renda){
            limite = 2*(renda/3);
            return 0;
	}
	

}
