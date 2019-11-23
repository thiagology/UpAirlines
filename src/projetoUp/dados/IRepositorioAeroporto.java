package projetoUp.dados;

import java.util.Map;

import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;

public interface IRepositorioAeroporto {

	public void salvarArquivo();
	
	public void addAeroporto(Aeroporto aeroporto);
	
	public boolean aeroportoExiste(Aeroporto aeroporto);
	
	public Aeroporto buscarAeroporto(Cidades cidade);
	
	public Map<Cidades, Aeroporto> getAeroportos();
	
	public void apagarAeroporto(Aeroporto a) ;
	
	
}
