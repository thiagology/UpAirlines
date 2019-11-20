package projetoUp.dados;
import java.util.Map;


import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;

public class RepositorioAeroporto {

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
	
	public void novoAeroporto(String nome, String sigla, Cidades cidade)
	{
		Aeroporto aeroporto = new Aeroporto(nome, sigla, cidade);
		this.addAeroporto(aeroporto);
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
	
	public void apagarAeroporto(Cidades cidade) 
	{
		this.aeroportos.remove(cidade);
	}
}
