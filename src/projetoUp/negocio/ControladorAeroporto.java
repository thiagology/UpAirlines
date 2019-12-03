package projetoUp.negocio;

import projetoUp.dados.RepositorioAeroporto;
import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Aeroporto;
import projetoUp.model.Cidades;

public class ControladorAeroporto {

    private RepositorioAeroporto repositorioAeroporto;

    private static ControladorAeroporto instance;

    public static ControladorAeroporto getInstance() {
        if (instance == null) {
            instance = new ControladorAeroporto();
        }
        return instance;
    }
    

    private ControladorAeroporto() {
		super();
		this.repositorioAeroporto = RepositorioAeroporto.getInstance();
	}


	public void novoAeroporto(String nome, String sigla, Cidades cidade) {
        try {

            this.adicionarAeroporto(new Aeroporto(nome, sigla, cidade));

        } catch (Exception e) {
            System.out.println("Aeroporto já existe");
        }

    }

    public boolean adicionarAeroporto(Aeroporto a) {
        if (a != null) {
            if (a.getCidade() != null) {
                try {
                    this.repositorioAeroporto.addAeroporto(a);
                    this.repositorioAeroporto.salvarArquivo();
                    return true;
                } catch (JaExisteException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return false;
    }

    public void removerAeroporto(Aeroporto a) {
        if (a != null) {
            //se nao tiver voos pra esse aeroporto
            try {
                this.repositorioAeroporto.apagarAeroporto(a);
            } catch (NaoExisteException e) {
                e.printStackTrace();
            }
            this.repositorioAeroporto.salvarArquivo();
        }
    }

    public Aeroporto buscarAeroporto(Cidades cidade) {
        if (cidade != null) {
            try {
                return this.repositorioAeroporto.buscarAeroporto(cidade);
            } catch (NaoExisteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
