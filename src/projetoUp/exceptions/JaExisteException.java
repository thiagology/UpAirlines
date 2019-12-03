package projetoUp.exceptions;

public class JaExisteException extends Exception {
	
	

	private static final long serialVersionUID = 1L;
	private Object objeto;
    
    public JaExisteException(Object obj) {
        super("Elemento j� existe");
        this.objeto = obj;        
    }

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
    
	@Override
	public String toString() {
		return "JaExisteException [objeto=" + objeto + "]";
	}

}
