package projetoUp.negocio;

public class Fachada {
	private static Fachada instance;
	
	private ControladorVoo controladorVoo;
	private ControladorPassagem controladorPassagem;
	private ControladorCliente controladorCliente;
	private ControladorAeroporto controladorAeroporto;
	
	private Fachada() {
		this.controladorVoo = ControladorVoo.getInstance();
		this.controladorCliente = ControladorCliente.getInstance();
		this.controladorPassagem = ControladorPassagem.getInstance();
		this.controladorAeroporto = ControladorAeroporto.getInstance();
	}
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	

	//gerente
	
	//cliente
}
