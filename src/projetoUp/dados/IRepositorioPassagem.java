package projetoUp.dados;


import java.util.List;

import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;

public interface IRepositorioPassagem {
	
	void criarPassagem(Passagem p);
	
	//remove uma passagem do repositorio
	void excluirPassagem(Passagem p);
	
	//retorna se uma passagem ja existe
	boolean codigoExiste(String codigo);
	
	//busca uma passagem pelo codigo
	public Passagem buscarPassagem(String codigo);
	
	public void alterarPassagem(Passagem p);
	
	public List <Passagem> listarPorPassageiro(Passageiro pa);
	
	void salvarArquivo();
	
}
