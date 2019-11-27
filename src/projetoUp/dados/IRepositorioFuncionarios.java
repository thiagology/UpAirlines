package projetoUp.dados;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Funcionario;
import projetoUp.model.Gerente;

public interface IRepositorioFuncionarios {
	
	void salvarArquivo();
	Funcionario buscarFuncionario(Funcionario funcionario) throws NaoExisteException;
	boolean funcionarioExiste(Funcionario funcionario) throws NaoExisteException;
	boolean addFuncionario(Funcionario fun) throws JaExisteException;
	void removerFuncionario(Funcionario funcionario) throws NaoExisteException;
	public boolean addGerente(Funcionario funcionario);
	public Gerente logIn(String login, String senha)throws NaoExisteException;

}
