package projetoUp.dados;

import java.util.Map;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;

public interface IRepositorioAeroporto {

	void salvarArquivo();
	
	boolean addAeroporto(Aeroporto aeroporto) throws JaExisteException;
	
	boolean aeroportoExiste(Aeroporto aeroporto) throws NaoExisteException;
	
	Aeroporto buscarAeroporto(Cidades cidade) throws NaoExisteException;
	
	Map<Cidades, Aeroporto> getAeroportos();
	
	void apagarAeroporto(Aeroporto a) throws NaoExisteException ;
	
	
	
}
