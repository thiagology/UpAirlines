package projetoUp.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;
import projetoUp.model.Cliente;
import projetoUp.model.Endereco;
import projetoUp.model.Funcionario;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;
import projetoUp.model.Voo;

public class Fachada {
	private static Fachada instance;
	
	private ControladorVoo controladorVoo;
	private ControladorPassagem controladorPassagem;
	private ControladorCliente controladorCliente;
	private ControladorAeroporto controladorAeroporto;
	private ControladorFuncionario controladorFuncionario;
	
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
	

	//GERENTE
	
	public void criarVoo(Cidades cidadeOrigem, Cidades cidadeDestino, Funcionario piloto, Funcionario coPiloto,
			Funcionario comissario, LocalDateTime horarioDeSaida, LocalDateTime horarioDeChegada,
			List<Passageiro> passageiros, String codigoVoo, int distancia, LocalDate data) {
		
		controladorVoo.marcarVoo(cidadeOrigem, cidadeDestino, piloto, coPiloto, comissario, horarioDeSaida, horarioDeChegada, passageiros, codigoVoo, distancia, data);
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
	
	
	

	
	public void adicionarFuncionario(String nome, String cpf, String rg,
			 int telefone, Endereco endereco,
			 LocalDate nascimento, int id, 
			 LocalDate contratacao, String funcao) {
		controladorFuncionario.adicionarFuncionario(nome, cpf, rg, telefone, endereco, nascimento, id, contratacao, funcao);;
	}

	public void removerFuncionario(Funcionario f) {
		controladorFuncionario.removerFuncionario(f);
	}

	public void buscarFuncionario(Funcionario f) {
		controladorFuncionario.buscarFuncionario(f);
	}
	
	
	

	public void adicionarAeroporto(Aeroporto a) {
		controladorAeroporto.adicionarAeroporto(a);
	}

	public void removerAeroporto(Aeroporto a) {
		controladorAeroporto.removerAeroporto(a);
	}

	public void buscarAeroporto(Cidades cidade) {
		controladorAeroporto.buscarAeroporto(cidade);
	}

	//CLIENTE
	
	public void criarConta(Cliente c) {
		controladorCliente.criarConta(c);
	}

	public void excluirConta(Cliente c) {
		controladorCliente.excluirConta(c);
	}

	public void buscarConta(String usuario, String senha) {
		controladorCliente.buscarConta(usuario, senha);
	}

	
	
	public void criarPassagem(Passagem p) {
		//controladorPassagem.criarPassagem(p); mudar argumentos
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
