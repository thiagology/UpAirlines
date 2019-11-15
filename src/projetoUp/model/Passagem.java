package projetoUp.model;

public class Passagem {
	private String codigo;
	private Passageiro passageiro;
	private Voo voo;
	
	public Passagem(String codigo, Passageiro passageiro, Voo voo) {
		super();
		this.codigo = codigo;
		this.passageiro = passageiro;
		this.voo = voo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
	
}
