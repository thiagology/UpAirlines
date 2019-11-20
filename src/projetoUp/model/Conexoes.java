package projetoUp.model;

public class Conexoes {
	
	private int nCidades = 27;
	private int conexoes[][] = new int[nCidades][nCidades];
	
	
	
	
	public Conexoes()
	{
		
		this.inserirDistancia( Cidades.RECIFE , Cidades.FORTALEZA , 628);
		this.inserirDistancia( Cidades.RECIFE , Cidades.MACEIO , 200);
		this.inserirDistancia( Cidades.RECIFE , Cidades.NATAL , 254);
		this.inserirDistancia( Cidades.RECIFE , Cidades.JAOAO_PESSOA , 105);
		this.inserirDistancia( Cidades.RECIFE , Cidades.ARACAJU , 398);
		this.inserirDistancia( Cidades.RECIFE , Cidades.SAO_LUIS , 1210);
		this.inserirDistancia( Cidades.RECIFE , Cidades.TERERESINA , 934);
		this.inserirDistancia( Cidades.RECIFE , Cidades.SALVADOR ,675 );
		this.inserirDistancia( Cidades.RECIFE , Cidades.SAO_PAULO , 2128);
		this.inserirDistancia( Cidades.RECIFE , Cidades.RIO_DE_JANEIRO , 1874);
	}
	
	public void inserirDistancia(Cidades cidade1, Cidades cidade2, double distancia)
	{
		conexoes[cidade1.getOrdem()][cidade2.getOrdem()] = (int)distancia;
	}
	
	public int getDistancia(Cidades cidade1, Cidades cidade2)
	{
		return this.conexoes[cidade1.getOrdem()][cidade2.getOrdem()];
	}
	
	

}
