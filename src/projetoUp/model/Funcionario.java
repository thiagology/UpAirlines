package projetoUp.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private int id;
	private LocalDate contratacao;
	private String funcao;

	private Funcionario(String nome, String cpf, String rg, int telefone, Endereco endereco, LocalDate nascimento,
			int id, LocalDate contratacao, String funcao) {
		super(nome, cpf, rg, telefone, endereco, nascimento);
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
	
	
}
