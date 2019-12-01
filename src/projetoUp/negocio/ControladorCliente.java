package projetoUp.negocio;

import java.time.LocalDate;

import projetoUp.dados.RepositorioCliente;
import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cidades;
import projetoUp.model.Cliente;
import projetoUp.model.Passageiro;

public class ControladorCliente {

    private RepositorioCliente repositorioCliente;
    private ControladorPassagem passagens;
    private ControladorVoo voo;
    private Cliente clienteLog = null;

    private static ControladorCliente instance;

    public static ControladorCliente getInstance() {
        if (instance == null) {
            instance = new ControladorCliente();
        }
        return instance;
    }

    public boolean fazerLogin(String usuario, String senha) {
        if (this.buscarConta(usuario, senha) != null) {
            this.clienteLog = this.buscarConta(usuario, senha);
            return true;
        }
        return false;
    }

    public boolean criarConta(Cliente c) {
        if (c != null) {
            if (c.getCpf() != null) {
                try {
                    this.repositorioCliente.criarConta(c);
                    this.repositorioCliente.salvarArquivo();
                    this.clienteLog = c;
                    return true;
                } catch (JaExisteException | NaoExisteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return false;
        }
        return false;
    }

    public boolean cadastrarConta(String nome,
            String cpf,
            String rg,
            int telefone,
            String endereco,
            LocalDate nascimento,
            String login, String senha) {
        Cliente conta = new Cliente(nome, cpf, rg, telefone, endereco, nascimento, login, senha);
        return this.criarConta(conta);
    }

    public void excluirConta(Cliente c) {
        if (c != null) {
            try {
                this.repositorioCliente.excluirConta(c);
                this.repositorioCliente.salvarArquivo();
            } catch (NaoExisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public boolean checkIn(String codigoVoo, String id) {
        if (codigoVoo != null && id != null) {
            this.voo.buscarVoo(codigoVoo).buscarPassageiro(
                    (Passageiro) this.clienteLog).checkIn(
                            this.voo.buscarVoo(codigoVoo).buscarAssento(id));
            return true;
        }
        return false;
    }

    public Cliente buscarConta(String login, String senha) {
        if (login != null && senha != null) {
            try {
                return repositorioCliente.buscarCliente(login, senha);
            } catch (NaoExisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public void comprarPassagem(Cidades origem, Cidades destino, LocalDate data) {
        if (this.voo.buscarVoo(origem, destino, data) != null) {
            this.passagens.criarPassagem(this.voo.buscarVoo(origem, destino, data).getcodigoVoo() + "3366",
                    (Passageiro) this.clienteLog,
                    this.voo.buscarVoo(origem, destino, data));

        }
    }

}
