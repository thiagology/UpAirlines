package projetoUp.dados;
import java.util.Map;


import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;


public class RepositorioAeroporto implements Serializable{

	
	private Map<Cidades, Aeroporto> aeroportos;
	
	public RepositorioAeroporto( Map<Cidades, Aeroporto> aeroportos)
	{
		
		this.aeroportos = aeroportos;
	}
	
	public void addAeroporto(Aeroporto aeroporto) {
		
		if(this.aeroportoExiste(aeroporto) != true)
		{
			this.aeroportos.put(aeroporto.getCidade(), aeroporto);
		}
	}
	
	public boolean aeroportoExiste(Aeroporto aeroporto)
	{
		if(this.buscarAeroporto(aeroporto.getCidade()) != null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public Aeroporto buscarAeroporto(Cidades cidade)
	{
		return this.aeroportos.get(cidade);
	}
	
	public Map<Cidades, Aeroporto> retornarAeroportos()
	{
		return this.aeroportos;
	}
	
	public void apagarAeroporto(Aeroporto a) 
	{
		if(this.aeroportoExiste(a) == true) {
			this.aeroportos.remove(a.getCidade());
		}
	}
	
	public void abrirArquivo()
	{
		
	}
}
