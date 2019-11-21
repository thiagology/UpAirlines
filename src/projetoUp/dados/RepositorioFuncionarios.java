package projetoUp.dados;

import java.time.LocalDate;
import java.util.ArrayList;

import projetoUp.model.Endereco;
import projetoUp.model.Funcionario;
import projetoUp.model.Gerente;

public class RepositorioFuncionarios {
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	
	public RepositorioFuncionarios(ArrayList<Funcionario> funcionarios)
	{
		this.funcionarios = funcionarios;
		Endereco endereco = new Endereco("Recife", "Pernambuco", "Brasil", 54500000);
		funcionarios.add(new Gerente("gerente@gmail.com", "0000", "Fulano Silva", "998.666.542-30", "8.656.474", 86529539, endereco, LocalDate.of(2019, 4, 6), "Gerente" ));
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
