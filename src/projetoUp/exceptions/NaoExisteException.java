package projetoUp.exceptions;

public class NaoExisteException extends Exception {
	private Object objeto;
	
	public NaoExisteException(Object obj) {
		super("Elemento n�o existente");
		this.objeto = obj;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
	
}
