package projetoUp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2762605090549207325L;
	private int id;
	private LocalDate contratacao;
	private String funcao;
	private String usuario;
	private String senha;

	public Funcionario(String nome, String cpf, String rg, int telefone, String endereco, LocalDate nascimento,
			int id, LocalDate contratacao, String funcao, String login, String senha) {
		super(nome, cpf, rg, telefone, endereco, nascimento, false);
		this.id = id;
		this.contratacao = contratacao;
		this.funcao = funcao;
	}
	
	public Funcionario()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getContratacao() {
		return contratacao;
	}
	public void setContratacao(LocalDate contratacao) {
		this.contratacao = contratacao;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
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
	
	public boolean equals(Funcionario func)
	{
		if(this.id == func.id && this.getNome().equals(func.getNome()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
