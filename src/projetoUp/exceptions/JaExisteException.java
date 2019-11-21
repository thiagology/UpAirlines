package projetoUp.exceptions;

public class JaExisteException extends Exception {
	private Object objeto;
    
    public JaExisteException(Object obj) {
        super("Elemento já existe");
        this.objeto = obj;        
    }

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
    
    

}
