package projetoUp.negocio;

import java.time.LocalDate;

import projetoUp.dados.RepositorioFuncionarios;
import projetoUp.model.Endereco;
import projetoUp.model.Funcionario;

public class ControladorFuncionario {
	private RepositorioFuncionarios repositorioFuncionario;
	private static ControladorFuncionario instance;
	
	public static ControladorFuncionario getInstance() {
		if(instance == null) {
			instance = new ControladorFuncionario();
		}
		return instance;
	}
	
	public void adicionarFuncionario(String nome, String cpf, String rg,
									 int telefone, Endereco endereco,
									 LocalDate nascimento, int id, 
									 LocalDate contratacao, String funcao) {
		if(cpf != null || rg != null) { //alguma identificacao nao nula
			if(contratacao.isBefore(LocalDate.now())) { //contratacao antes da data atual
				Funcionario novo = new Funcionario(nome, cpf, rg, telefone, endereco,
												nascimento, id, contratacao, funcao);
				this.repositorioFuncionario.addFuncionario(novo);
				this.repositorioFuncionario.salvarArquivo();
			}
		}
	}
	
	public void removerFuncionario (Funcionario f) {
		if(f != null) {
			this.repositorioFuncionario.removerFuncionario(f);
			this.repositorioFuncionario.salvarArquivo();
		}
	}
	
	public void buscarFuncionario(Funcionario f) {
		if(f != null) {
			repositorioFuncionario.buscarFuncionario(f);
		}
	}
}
