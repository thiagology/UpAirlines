package projetoUp.model;

public class Passagem {
	private String codigo;
	private Passageiro passageiro;
	private Voo voo;
	private float preco;
	
	public Passagem(String codigo, Passageiro passageiro, Voo voo) {
		super();
		this.codigo = codigo;
		this.passageiro = passageiro;
		this.voo = voo;
		this.setPreco();
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
	
	public void setPreco()
	{
		float tPreco;
		
		if(this.voo.getDistancia() <= 200 && this.voo.getDistancia() > 0)
		{
			tPreco = 200.00f;
		}
		
		else if(this.voo.getDistancia() > 200 && this.voo.getDistancia() <= 500)
		{
			tPreco = 450f;
		}
		
		else if(this.voo.getDistancia() > 500 && this.voo.getDistancia() <= 800)
		{
			tPreco = 650f;
		}
		
		else if(this.voo.getDistancia() > 800 && this.voo.getDistancia() <= 1500)
		{
			tPreco = 900f;
		}
		
		else if(this.voo.getDistancia() > 1500 && this.voo.getDistancia() <= 2500)
		{
			tPreco = 1300f;
		}
		
		else if(this.voo.getDistancia() > 2500 && this.voo.getDistancia() <= 4000)
		{
			tPreco = 1500f;
		}
		
		else
		{
			tPreco = 2500f;
		}
		
		this.preco = tPreco;
	}
	
	public float getPreco()
	{
		return this.preco;
	}
	
	
}
