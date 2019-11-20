package projetoUp.negocio;

import projetoUp.dados.RepositorioVoo;
import projetoUp.model.Voo;

public class ControladorVoo {
	 private static ControladorVoo instance;
	 private RepositorioVoo repositorioVoo;
	 
	
	public static ControladorVoo getInstance() {
		if(instance == null) {
			instance = new ControladorVoo();
		}
		return instance;
	}
	 
	public void criarVoo(Voo v) {
		//logica de data e hora
		repositorioVoo.criarVoo(v);
	}
	
	public void removerVoo(Voo v) {
		//logica de data e hora
		repositorioVoo.removerVoo(v);
	}
	
	
	public void alterarVoo(Voo v) {
		//implementar regra 
		repositorioVoo.alterarVoo(v);
	}
	
	 
	 
	 
}
