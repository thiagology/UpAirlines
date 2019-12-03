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
			tPreco = 450.00f;
		}
		
		else if(this.voo.getDistancia() > 500 && this.voo.getDistancia() <= 800)
		{
			tPreco = 650.00f;
		}
		
		else if(this.voo.getDistancia() > 800 && this.voo.getDistancia() <= 1500)
		{
			tPreco = 900.00f;
		}
		
		else if(this.voo.getDistancia() > 1500 && this.voo.getDistancia() <= 2500)
		{
			tPreco = 1300.00f;
		}
		
		else if(this.voo.getDistancia() > 2500 && this.voo.getDistancia() <= 4000)
		{
			tPreco = 1500.00f;
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
	
	public boolean equals(Passagem pa)
	{
		if(this.passageiro.equals(pa.passageiro) && this.preco == pa.preco)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
}
