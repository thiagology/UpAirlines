package projetoUp.exceptions;

public class RotaNaoExiste extends Exception {

	private static final long serialVersionUID = 1L;
	private int distancia;
	
	public RotaNaoExiste(int distancia) {
		super();
		this.distancia = distancia;
	}
	
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	
	public String toString() {
		return "RotaNaoExiste! Favor escolher outra rota!";
	}
	
	
	
	
}
