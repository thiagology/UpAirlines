package projetoUp.negocio;

import java.time.LocalDate;

import projetoUp.dados.RepositorioFuncionarios;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Funcionario;

public class ControladorFuncionario {

    private RepositorioFuncionarios repositorioFuncionario;
    private static ControladorFuncionario instance;
    
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
            LocalDate contratacao, String funcao, String login, String senha) throws NaoExisteException {
        if (cpf != null || rg != null) { //alguma identificacao nao nula
            if (contratacao.isBefore(LocalDate.now())) { //contratacao antes da data atual
                Funcionario novo = new Funcionario(nome, cpf, rg, telefone, endereco,
                        nascimento, id, contratacao, funcao, login, senha);
                this.repositorioFuncionario.addFuncionario(novo);
                this.repositorioFuncionario.salvarArquivo();
            }
        }
    }

    public void removerFuncionario(Funcionario f) throws NaoExisteException {
        if (!f.isAdm()) {
                this.repositorioFuncionario.removerFuncionario(f);
                this.repositorioFuncionario.salvarArquivo();
        }
    }

    public Funcionario buscarFuncionario(String CPF) throws NaoExisteException {
        if(CPF != null) {
               return repositorioFuncionario.buscarFuncionario(CPF);
        }
        return null;
    }


}
