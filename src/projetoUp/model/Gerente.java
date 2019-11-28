package projetoUp.model;


public class Gerente extends Funcionario implements Login{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6080475143461416360L;
	
	public Gerente() {
		super();
		this.setAdm(true);
	}
	
	@Override
	public void fazerLogin() {
	}
	
	
	
}
