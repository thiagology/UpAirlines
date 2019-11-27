package projetoUp.negocio;

import java.time.LocalDate;

import projetoUp.dados.RepositorioFuncionarios;
import projetoUp.exceptions.NaoExisteException;
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
		if(!f.isAdm()) {
			try {
				this.repositorioFuncionario.removerFuncionario(f);
				this.repositorioFuncionario.salvarArquivo();
			} catch (NaoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void buscarFuncionario(Funcionario f) {
		if(f != null) {
			try {
				repositorioFuncionario.buscarFuncionario(f);
			} catch (NaoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean tornarGerente(Funcionario funcionario, String login, String senha)
	{
		return this.repositorioFuncionario.addGerente(funcionario, login, senha);
	}
}
