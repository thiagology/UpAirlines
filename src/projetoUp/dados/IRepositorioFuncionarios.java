package projetoUp.dados;

import projetoUp.model.Funcionario;

public interface IRepositorioFuncionarios {
	
	void salvarArquivo();
	Funcionario buscarFuncionario(Funcionario funcionario);
	boolean funcionarioExiste(Funcionario funcionario);
	boolean addFuncionario(Funcionario fun);
	void removerFuncionario(Funcionario funcionario);

}
