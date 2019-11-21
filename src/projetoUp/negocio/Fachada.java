package projetoUp.negocio;

import java.util.List;

import projetoUp.model.Cliente;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;
import projetoUp.model.Voo;

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
	public void criarVoo(Voo v) {
		controladorVoo.criarVoo(v);
	}

	public void removerVoo(Voo v) {
		controladorVoo.removerVoo(v);
	}

	public void alterarVoo(Voo v) {
		controladorVoo.alterarVoo(v);
	}

	public void listar() {
		controladorVoo.listar();
	}

	public void buscarVoo(String codigo) {
		controladorVoo.buscarVoo(codigo);
	}
	
	
	
	//cliente
	
	public void criarConta(Cliente c) {
		controladorCliente.criarConta(c);
	}

	public void excluirConta(Cliente c) {
		controladorCliente.excluirConta(c);
	}

	public void buscarConta(String email) {
		controladorCliente.buscarConta(email);
	}

	
	
	public void criarPassagem(Passagem p) {
		controladorPassagem.criarPassagem(p);
	}

	public void excluirPassagem(Passagem p) {
		controladorPassagem.excluirPassagem(p);
	}

	public void alterarPassagem(Passagem p) {
		controladorPassagem.alterarPassagem(p);
	}
	
	public void buscarPassagem(String c) {
		controladorPassagem.buscarPassagem(c);
	}

	public List<Passagem> listarPorPassageiro(Passageiro pa) {
		return controladorPassagem.listarPorPassageiro(pa);
	}
}
