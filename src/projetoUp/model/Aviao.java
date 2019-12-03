
package projetoUp.model;


public class Aviao {
    
	private String modelo;
	private int lin;
	private int col;
	private int velM;
	private boolean noAeroporto;
	
	
	public Aviao()
	{
		this.lin = 15;
		this.col = 4;
		this.modelo = "ERJ-145";
		this.setVelM(830);
		
		this.noAeroporto = true;
			}
	

	public String getModelo()
	{
		return this.modelo;
	}
	
	public int getLin()
	{
		return this.lin;
	}
	
	public int getCol()
	{
		return this.col;
	}
	
	public boolean isNoAeroporto()
	{
		return this.noAeroporto;
	}
	
	public  void voar()
	{
		this.noAeroporto = false;
	}
	
	public void estacionar()
	{
		this.noAeroporto = true;
	}


	public int getVelM() {
		return velM;
	}


	public void setVelM(int velM) {
		this.velM = velM;
	}
	
	
		
}
