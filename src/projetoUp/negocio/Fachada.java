package projetoUp.negocio;

import java.time.LocalDate;
import java.util.List;

import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cidades;
import projetoUp.model.Cliente;
import projetoUp.model.Funcionario;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;
import projetoUp.model.Voo;

public class Fachada {
	
    private static Fachada instance;

    private ControladorVoo controladorVoo;
    private ControladorPassagem controladorPassagem;
    private ControladorCliente controladorCliente;
    private ControladorFuncionario controladorFuncionario;

    private Fachada() {
        this.controladorVoo = ControladorVoo.getInstance();
        this.controladorCliente = ControladorCliente.getInstance();
        this.controladorPassagem = ControladorPassagem.getInstance();
        this.controladorFuncionario = ControladorFuncionario.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    //GERENTE	
    
    public void criarVoo(Voo v) throws NaoExisteException, JaExisteException {
    	controladorVoo.criarVoo(v);
    }

    public void removerVoo(Voo v) throws NaoExisteException {
        controladorVoo.removerVoo(v);
    }

    public void alterarVoo(Voo v) throws NaoExisteException {
        controladorVoo.alterarVoo(v);
    }

    public void listar() {
        controladorVoo.listar();
    }

    public Voo buscarVoo(String codigo) throws NaoExisteException {
        return controladorVoo.buscarVoo(codigo);
    }

    public void adicionarFuncionario(String nome, String cpf, String rg,
            int telefone, String endereco,
            LocalDate nascimento, int id,
            LocalDate contratacao, String funcao, String login, String senha) throws NaoExisteException {
        controladorFuncionario.adicionarFuncionario(nome, cpf, rg, telefone, endereco,
                nascimento, id, contratacao, funcao, login, senha);
    }

    public void removerFuncionario(Funcionario f) throws NaoExisteException {
        controladorFuncionario.removerFuncionario(f);
    }

    public Funcionario buscarFuncionario(String cpf) throws NaoExisteException {
        return controladorFuncionario.buscarFuncionario(cpf);
    }

    //CLIENTE
    public boolean fazerLogin(String usuario, String senha) throws NaoExisteException {
        return controladorCliente.fazerLogin(usuario, senha);
    }

    public boolean criarConta(Cliente c) throws JaExisteException, NaoExisteException {
        return controladorCliente.criarConta(c);
    }


    public void excluirConta(Cliente c) throws NaoExisteException {
        controladorCliente.excluirConta(c);
    }

    public Cliente buscarConta(String login, String senha) throws NaoExisteException {
        return controladorCliente.buscarConta(login, senha);
    }

    public void comprarPassagem(Cidades origem, Cidades destino, LocalDate data) throws JaExisteException, NaoExisteException {
        controladorCliente.comprarPassagem(origem, destino, data);
    }

    public void criarPassagem(String codigo, Passageiro p, Voo v) throws JaExisteException, NaoExisteException {
        controladorPassagem.criarPassagem(codigo, p, v);
    }

    public void excluirPassagem(Passagem p) throws NaoExisteException {
        controladorPassagem.excluirPassagem(p);
    }

    public void alterarPassagem(Passagem p, String idAssento) throws NaoExisteException {
        controladorPassagem.alterarPassagem(p, idAssento);
    }

    public Passagem buscarPassagem(String c) throws NaoExisteException {
		return controladorPassagem.buscarPassagem(c);
    }

    public List<Passagem> listarPorPassageiro(Passageiro pa) {
        return controladorPassagem.listarPorPassageiro(pa);
    }

	public Cliente getClienteLog() {
		return controladorCliente.getClienteLog();
	}
    
    

}
