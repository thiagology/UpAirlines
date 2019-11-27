package projetoUp.dados;


import java.util.List;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;

public interface IRepositorioPassagem {
	
	void criarPassagem(Passagem p) throws JaExisteException;
	
	//remove uma passagem do repositorio
	void excluirPassagem(Passagem p);
	
	//retorna se uma passagem ja existe
	boolean codigoExiste(String codigo);
	
	//busca uma passagem pelo codigo
	public Passagem buscarPassagem(String codigo);
	
	public void alterarPassagem(Passagem p)throws NaoExisteException;
	
	public List <Passagem> listarPorPassageiro(Passageiro pa);
	
	void salvarArquivo();
	
}
