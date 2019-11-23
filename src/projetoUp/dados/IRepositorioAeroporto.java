package projetoUp.dados;

import java.util.Map;

import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;

public interface IRepositorioAeroporto {

	void salvarArquivo();
	
	void addAeroporto(Aeroporto aeroporto);
	
	boolean aeroportoExiste(Aeroporto aeroporto);
	
	Aeroporto buscarAeroporto(Cidades cidade);
	
	Map<Cidades, Aeroporto> getAeroportos();
	
	void apagarAeroporto(Aeroporto a) ;
	
	
	
}
