package projetoUp.model;

import java.time.LocalDate;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String rg;
	private int telefone;
	private String endereco;
	private LocalDate nascimento;
	private boolean adm = false;

	public Pessoa(String nome, String cpf, String rg, int telefone, String string, LocalDate nascimento, boolean adm) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = string;
		this.nascimento = nascimento;
		this.adm = adm;
	}
	
	public Pessoa() {
		super();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void String(String endereco) {
		this.endereco = endereco;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public boolean isAdm() {
		return this.adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	
	
}
