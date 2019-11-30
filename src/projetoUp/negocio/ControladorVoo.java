package projetoUp.negocio;

import projetoUp.dados.RepositorioVoo;
import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Cidades;
import projetoUp.model.Conexoes;
import projetoUp.model.Voo;
import java.time.LocalDate;


public class ControladorVoo {

    private static ControladorVoo instance;
    private RepositorioVoo repositorioVoo;
    private Conexoes rota;

    public static ControladorVoo getInstance() {
        if (instance == null) {
            instance = new ControladorVoo();
        }
        return instance;
    }


    public void criarVoo(Voo v) {
        if (v != null && this.rota.getDistancia(v.getAeroportoDeOrigem(), v.getAeroportoDeDestino()) > 0) {
            if (v.getHorarioDeSaida().isAfter(v.getHorarioDeChegada())) { //hora de saida nao pode ser antes da de chegada
                if (!(v.getAeroportoDeDestino().equals(v.getAeroportoDeOrigem()))) {
                    try {
                        this.repositorioVoo.criarVoo(v);
                        this.repositorioVoo.salvarArquivo();
                    } catch (JaExisteException e) {

                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void removerVoo(Voo v) {
        if (v != null) {
            if (v.getPassageiros() == null) {
                //se nao houver passagens vendidas
                this.repositorioVoo.removerVoo(v);
                this.repositorioVoo.salvarArquivo();
            }
        }
    }

    public void alterarVoo(Voo v) {
        if (v != null) {
            //atualiza s� a hora de chegada e s� se ela for depois da de saida
            try {
                this.repositorioVoo.alterarVoo(v);
                this.repositorioVoo.salvarArquivo();
            } catch (NaoExisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void listar() {
        repositorioVoo.listar();
    }

    public Voo buscarVoo(String codigo) {
        if (codigo != null) {
            return repositorioVoo.buscarVoo(codigo);
        }
        return null;
    }

    public Voo buscarVoo(Cidades origem, Cidades destino, LocalDate data) {
        return this.repositorioVoo.buscarVoo(origem, destino, data);

    }


}
