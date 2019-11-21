package projetoUp.negocio;

import projetoUp.dados.RepositorioFuncionarios;
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
	
	public void adicionarFuncionario(Funcionario f) {
		if(f != null) {
			if(f.getCpf() != null) {
				repositorioFuncionario.addFuncionario(f);
			}
		}
	}
	
	public void removerFuncionario (Funcionario f) {
		if(f != null) {
			repositorioFuncionario.removerFuncionario(f);
		}
	}
	
	public void buscarFuncionario(Funcionario f) {
		if(f != null) {
			repositorioFuncionario.buscarFuncionario(f);
		}
	}
}
