package projetoUp.dados;


import java.time.LocalDate;
import java.util.List;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cidades;
import projetoUp.model.Voo;

public interface IRepositorioVoo {
	
		void salvarArquivo();
	
    	//adiciona um voo ao repositorio
  		void criarVoo(Voo v) throws JaExisteException;
  		
  		//remove um voo do repositorio
  		void removerVoo(Voo v);
  		
  		//retorna se um voo ja existe
  		boolean codigoExiste(String codigo);
  		
  		//busca um voo pelo codigo
  		Voo buscarVoo(String codigo);
  		
  		public void alterarVoo(Voo v) throws NaoExisteException;
  		
  		public List<Voo> listar();
  		
  		public Voo buscarVoo(Cidades origem, Cidades destino, LocalDate data);
    

}
