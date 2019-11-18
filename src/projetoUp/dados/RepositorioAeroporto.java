package projetoUp.dados;
import java.util.ArrayList;

import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;

public class RepositorioAeroporto {

	private ArrayList<Aeroporto> aeroportos = new ArrayList<>();
	
	public RepositorioAeroporto(ArrayList<Aeroporto> aeroportos)
	{
		
		this.aeroportos = aeroportos;
	}
	
	public void addAeroporto(Aeroporto aeroporto) {
		this.aeroportos.add(aeroporto);
	}
	
	public void novoAeroporto(String nome, String sigla, Cidades cidade)
	{
		this.aeroportos.add(new Aeroporto(nome, sigla, cidade));
	}
	
	public Aeroporto buscarAeroporto(Cidades cidade)
	{
		return this.aeroportos.get(cidade.getOrdem() - 1);
	}
	
	public ArrayList<Aeroporto> retornarAeroportos()
	{
		return this.aeroportos;
	}
}
