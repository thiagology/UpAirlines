package projetoUp.negocio;

import projetoUp.dados.RepositorioAeroporto;
import projetoUp.model.Aeroporto;

public class ControladorAeroporto {
	private RepositorioAeroporto repositorioAeroporto;
	
	private static ControladorAeroporto instance;
	
	public static ControladorAeroporto getInstance() {
		if(instance == null) {
			instance = new ControladorAeroporto();
		}
		return instance;
	}
	
	public void adicionarAeroporto(Aeroporto a) {
		if(a != null) {
			if( a.getCidade() != null) {
				this.repositorioAeroporto.addAeroporto(a);
				this.repositorioAeroporto.salvarArquivo();
			}
		}
	}
	
	public void removerAeroporto(Aeroporto a) {
		if(a != null) {
			//se nao tiver voos pra esse aeroporto
			this.repositorioAeroporto.apagarAeroporto(a);
			this.repositorioAeroporto.salvarArquivo();
			}
		}
	
	public void buscarAeroporto(Aeroporto a) {
		if(a != null) {
			this.repositorioAeroporto.buscarAeroporto(a.getCidade());
			}
		}
	
	
}
