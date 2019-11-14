
package projetoUp.model;


public class Aviao {
    
	private String modelo;
	private Assento[][] assentos;
	private int lin;
	private int col;
	private boolean noAeroporto;
	
	
	public Aviao()
	{
		this.lin = 15;
		this.col = 4;
		this.modelo = "ERJ-145";
		this.assentos = new Assento[lin][col];
		this.noAeroporto = true;
		int qA = 1;
		for(int i = 0; i < lin; i++)
		{
			for(int j = 0; j < col; j++)
			{
				switch (j) {
				case 0:
					
					this.getAssentos()[i][j].setId("A" + "-" + qA);
					break;
				case 1:
					this.getAssentos()[i][j].setId("B" + "-" + qA);
					break;
				case 2:
					this.getAssentos()[i][j].setId("C" + "-" + qA);
					break;
				case 3:
					this.getAssentos()[i][j].setId("D" + "-" + qA);
					break;

				default:
					break;
				}
				qA++;
			}
		}
	}
	

	public String getModelo()
	{
		return this.modelo;
	}


	public Assento[][] getAssentos() {
		return assentos;
	}
	
	public void reservarAssento(int linha, int coluna)
	{
		this.assentos[linha][coluna].reservar();
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
	
	public char[][] mapaAssentos()
	{
		
		char[][] mapAssentos = new char[lin][col];
		
		for(int i = 0; i < lin; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(this.assentos[i][j].getOcupado())
				{
					mapAssentos[i][j] = 'O';
				}
				else
				{
					mapAssentos[i][j] = 'V';
				}
			}
	    }
	
		return mapAssentos;	
	}
	
}
