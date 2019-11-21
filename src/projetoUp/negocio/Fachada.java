package projetoUp.negocio;

public class Fachada {
	private static Fachada instance;
	
	private ControladorVoo controladorVoo;
	private ControladorPassagem controladorPassagem;
	private ControladorCliente controladorCliente;
	private ControladorAeroporto controladorAeroporto;
	
	
	private static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
}
