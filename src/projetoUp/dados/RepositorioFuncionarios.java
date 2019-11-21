package projetoUp.dados;

import java.util.ArrayList;
import projetoUp.model.Funcionario;

public class RepositorioFuncionarios {
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	
	
	public RepositorioFuncionarios(ArrayList<Funcionario> funcionarios)
	{
		this.funcionarios = funcionarios;
		
	}
	
	public Funcionario buscarFuncionario(Funcionario funcionario)
	{
		for (Funcionario f : funcionarios) {
			if(f.equals(funcionario))
			{
				return f;
			}
		}
		
		return null;
	}
	
	public boolean funcionarioExiste(Funcionario funcionario)
	{
		if(this.buscarFuncionario(funcionario) != null)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean addFuncionario(Funcionario fun)
	{
		if(this.funcionarioExiste(fun) != true)
		{
			this.funcionarios.add(fun);
			return true;
		}
		
		return false;	
	}
	
	public void removerFuncionario(Funcionario funcionario)
	{
		this.funcionarios.remove(funcionario);
	}
	
	
	

}
