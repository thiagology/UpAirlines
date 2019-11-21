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
		funcionarios.add(new Gerente("gerente@gmail.com", "0000", "Gerente", "09855022231", "8777444", 86525252, endereco,
				LocalDate.of(1992, 5, 10), 2233, LocalDate.of(2019, 3, 15), "Gerente"));	}
	
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
