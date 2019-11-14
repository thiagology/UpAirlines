package com.mycompany.empresaaerea;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private int id;
	private LocalDate contratacao;
	private String funcao;
	
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
