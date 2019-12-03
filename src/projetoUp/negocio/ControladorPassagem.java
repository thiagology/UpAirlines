package projetoUp.negocio;

import java.time.LocalTime;
import java.util.List;

import projetoUp.dados.RepositorioPassagem;
import projetoUp.exceptions.JaExisteException;
import projetoUp.exceptions.NaoExisteException;
import projetoUp.model.Passageiro;
import projetoUp.model.Passagem;
import projetoUp.model.Voo;

public class ControladorPassagem {

    private RepositorioPassagem repositorioPassagem;

    private static ControladorPassagem instance;

    public static ControladorPassagem getInstance() {
        if (instance == null) {
            instance = new ControladorPassagem();
        }
        return instance;
    }
    
    

    public ControladorPassagem() {
		super();
		this.repositorioPassagem = RepositorioPassagem.getInstance();
	}



	public void criarPassagem(String codigo, Passageiro p, Voo v) throws JaExisteException, NaoExisteException {
        if (p != null) {
            if (v.getHorarioDeSaida().isAfter(v.getHorarioDeChegada())) {
                if (p.getCpf() != null || p.getRg() != null) {
                    Passagem pas = new Passagem(codigo, p, v);
                    p.setCodigoVoo(pas.getVoo().getcodigoVoo());
                    v.setPassageiro(p);
                        repositorioPassagem.criarPassagem(pas);
                        repositorioPassagem.salvarArquivo();
                }
            }
        }
    }

    public void excluirPassagem(Passagem p) throws NaoExisteException {
        if (p != null) {
            if (p.getVoo().getHorarioDeSaida().isAfter(LocalTime.now())); //se o voo j� partiu
            p.getVoo().liberarAssento(p.getPassageiro().getAssento().getId());//libera o assento de volta no voo
            repositorioPassagem.excluirPassagem(p);
            repositorioPassagem.salvarArquivo();
        }
    }

    public void alterarPassagem(Passagem p, String idAssento) throws NaoExisteException {
        if (p != null) {
            //verificar disponibilidade do assento
            if (p.getVoo().buscarAssento(idAssento).getOcupado() == false) {
                p.getVoo().liberarAssento(p.getPassageiro().getAssento().getId());//libera o assento antigo
            }
            p.getPassageiro().setAssento(p.getVoo().reservarAssento(idAssento));//muda assento	

                repositorioPassagem.alterarPassagem(p);
                repositorioPassagem.salvarArquivo();

        }
    }

    public Passagem buscarPassagem(String c) throws NaoExisteException{
        if (c != null) {
           return repositorioPassagem.buscarPassagem(c);
        }
        return null;
    }

    public List<Passagem> listarPorPassageiro(Passageiro pa) {
        return repositorioPassagem.listarPorPassageiro(pa);
    }

}
