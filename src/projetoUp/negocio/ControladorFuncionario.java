package projetoUp.negocio;

import java.time.LocalDate;

import projetoUp.dados.RepositorioFuncionarios;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Funcionario;
import projetoUp.model.Gerente;

public class ControladorFuncionario {

    private RepositorioFuncionarios repositorioFuncionario;
    private static ControladorFuncionario instance;
    @SuppressWarnings("unused")
	private Gerente usuario;

    public static ControladorFuncionario getInstance() {
        if (instance == null) {
            instance = new ControladorFuncionario();
        }
        return instance;
    }
    
    

    public ControladorFuncionario() {
		super();
		this.repositorioFuncionario = RepositorioFuncionarios.getInstance();
	}



	public void adicionarFuncionario(String nome, String cpf, String rg,
            int telefone, String endereco,
            LocalDate nascimento, int id,
            LocalDate contratacao, String funcao, String login, String senha) {
        if (cpf != null || rg != null) { //alguma identificacao nao nula
            if (contratacao.isBefore(LocalDate.now())) { //contratacao antes da data atual
                Funcionario novo = new Funcionario(nome, cpf, rg, telefone, endereco,
                        nascimento, id, contratacao, funcao, login, senha);
                this.repositorioFuncionario.addFuncionario(novo);
                this.repositorioFuncionario.salvarArquivo();
            }
        }
    }

    public void removerFuncionario(Funcionario f) {
        if (!f.isAdm()) {
            try {
                this.repositorioFuncionario.removerFuncionario(f);
                this.repositorioFuncionario.salvarArquivo();
            } catch (NaoExisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public Funcionario buscarFuncionario(String CPF) throws NaoExisteException {
        if(CPF != null) {
               return repositorioFuncionario.buscarFuncionario(CPF);
        }
        return null;
    }

    public boolean tornarGerente(Funcionario funcionario) {
        return this.repositorioFuncionario.addGerente(funcionario);
    }

    public boolean logInGerente(String login, String senha) {
        try {
            this.usuario = this.repositorioFuncionario.login(login, senha);
            return true;
        } catch (NaoExisteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
