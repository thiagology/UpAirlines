package projetoUp.negocio;

import java.time.LocalDate;
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
        this.controladorFuncionario = ControladorFuncionario.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    //GERENTE	
    
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

    public Voo buscarVoo(String codigo) {
        return controladorVoo.buscarVoo(codigo);
    }

    public void adicionarFuncionario(String nome, String cpf, String rg,
            int telefone, Endereco endereco,
            LocalDate nascimento, int id,
            LocalDate contratacao, String funcao, String login, String senha) {
        controladorFuncionario.adicionarFuncionario(nome, cpf, rg, telefone, endereco,
                nascimento, id, contratacao, funcao, login, senha);
    }

    public void removerFuncionario(Funcionario f) {
        controladorFuncionario.removerFuncionario(f);
    }

    public void buscarFuncionario(Funcionario f) {
        controladorFuncionario.buscarFuncionario(f);
    }

    public void novoAeroporto(String nome, String sigla, Cidades cidade) {
        controladorAeroporto.novoAeroporto(nome, sigla, cidade);
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
    public boolean fazerLogin(String usuario, String senha) {
        return controladorCliente.fazerLogin(usuario, senha);
    }

    public boolean criarConta(Cliente c) {
        return controladorCliente.criarConta(c);
    }

    public boolean cadastrarConta(String nome, String cpf, String rg, int telefone, Endereco endereco,
            LocalDate nascimento, Passagem passagens, String login, String senha) {
        return controladorCliente.cadastrarConta(nome, cpf, rg, telefone, endereco, nascimento, passagens, login,
                senha);
    }

    public void excluirConta(Cliente c) {
        controladorCliente.excluirConta(c);
    }

    public boolean checkIn(String codigoVoo, String id) {
        return controladorCliente.checkIn(codigoVoo, id);
    }

    public Cliente buscarConta(String login, String senha) {
        return controladorCliente.buscarConta(login, senha);
    }

    public void comprarPassagem(Cidades origem, Cidades destino, LocalDate data) {
        controladorCliente.comprarPassagem(origem, destino, data);
    }

    public void criarPassagem(String codigo, Passageiro p, Voo v) {
        controladorPassagem.criarPassagem(codigo, p, v);
    }

    public void excluirPassagem(Passagem p) {
        controladorPassagem.excluirPassagem(p);
    }

    public void alterarPassagem(Passagem p, String idAssento) {
        controladorPassagem.alterarPassagem(p, idAssento);
    }

    public void buscarPassagem(String c) {
        controladorPassagem.buscarPassagem(c);
    }

    public List<Passagem> listarPorPassageiro(Passageiro pa) {
        return controladorPassagem.listarPorPassageiro(pa);
    }

    public void promoverFuncionario(Funcionario funcionario) {
        this.controladorFuncionario.tornarGerente(funcionario);

    }
}
