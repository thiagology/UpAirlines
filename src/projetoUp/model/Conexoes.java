package projetoUp.model;



public class Conexoes {
	
	private int nCidades = 27;
	private int conexoes[][] = new int[nCidades][nCidades];
	
	
	
	
	
	public Conexoes()
	{
		
		
		this.inserirDistancia( Cidades.RECIFE , Cidades.FORTALEZA , 628);
		this.inserirDistancia( Cidades.RECIFE , Cidades.MACEIO , 200);
		this.inserirDistancia( Cidades.RECIFE , Cidades.NATAL , 254);
		this.inserirDistancia( Cidades.RECIFE , Cidades.JOAO_PESSOA , 105);
		this.inserirDistancia( Cidades.RECIFE , Cidades.ARACAJU , 398);
		this.inserirDistancia( Cidades.RECIFE , Cidades.SAO_LUIS , 1210);
		this.inserirDistancia( Cidades.RECIFE , Cidades.TERERESINA , 934);
		this.inserirDistancia( Cidades.RECIFE , Cidades.SALVADOR ,675 );
		this.inserirDistancia( Cidades.RECIFE , Cidades.SAO_PAULO , 2128);
		this.inserirDistancia( Cidades.RECIFE , Cidades.RIO_DE_JANEIRO , 1874);
		this.inserirDistancia( Cidades.RECIFE , Cidades.CURITIBA , 2461);
		this.inserirDistancia( Cidades.FORTALEZA , Cidades.BELO_HORIZONTE , 2528);
		this.inserirDistancia( Cidades.FORTALEZA , Cidades.BOA_VISTA , 6548);
		this.inserirDistancia( Cidades.FORTALEZA , Cidades.SALVADOR , 1389);
		this.inserirDistancia( Cidades.SAO_LUIS , Cidades.FORTALEZA , 1070);
		this.inserirDistancia( Cidades.FLORIANOPOLIS , Cidades.SALVADOR , 2682);
		this.inserirDistancia( Cidades.BELEM , Cidades.ARACAJU , 2079);
		this.inserirDistancia( Cidades.BELO_HORIZONTE , Cidades.BELEM , 2824);
		this.inserirDistancia( Cidades.BOA_VISTA , Cidades.BELO_HORIZONTE , 4736);
		this.inserirDistancia( Cidades.BRASILIA , Cidades.BELO_HORIZONTE , 716);
		this.inserirDistancia( Cidades.BRASILIA , Cidades.CUIABA , 1081);
		this.inserirDistancia( Cidades.BRASILIA , Cidades.PORTO_VELHO , 1907);
		this.inserirDistancia( Cidades.CAMPO_GRANDE , Cidades.BELEM , 2942);
		this.inserirDistancia( Cidades.CAMPO_GRANDE , Cidades.BELO_HORIZONTE , 1594);
		this.inserirDistancia( Cidades.GOIANIA , Cidades.CUIABA , 934);
		this.inserirDistancia( Cidades.GOIANIA , Cidades.BRASILIA , 209);
		this.inserirDistancia( Cidades.JOAO_PESSOA , Cidades.ARACAJU , 611);
		this.inserirDistancia( Cidades.JOAO_PESSOA , Cidades.CURITIBA , 3188);
		this.inserirDistancia( Cidades.MACEIO , Cidades.ARACAJU , 294);
		this.inserirDistancia( Cidades.MANAUS , Cidades.FORTALEZA , 5763);
		this.inserirDistancia( Cidades.MANAUS , Cidades.BRASILIA , 5490);
		this.inserirDistancia( Cidades.MANAUS , Cidades.RIO_DE_JANEIRO , 4374);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.CUIABA , 2566);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.BRASILIA , 1446);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.PORTO_VELHO , 2811);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.FORTALEZA , 1027);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.CAMPO_GRANDE , 1905);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.RIO_DE_JANEIRO , 1211);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.MACEIO , 476);
		this.inserirDistancia( Cidades.SALVADOR , Cidades.CUIABA , 2566);
		this.inserirDistancia( Cidades.NATAL , Cidades.PALMAS , 1524);
		this.inserirDistancia( Cidades.MANAUS , Cidades.BELEM , 1293);
		this.inserirDistancia( Cidades.MANAUS , Cidades.BOA_VISTA , 785);
		this.inserirDistancia( Cidades.PORTO_ALEGRE , Cidades.RECIFE , 2979);
		this.inserirDistancia( Cidades.PORTO_ALEGRE , Cidades.SAO_PAULO , 853);
		this.inserirDistancia( Cidades.PORTO_ALEGRE , Cidades.FLORIANOPOLIS , 457);
		this.inserirDistancia( Cidades.MACAPA , Cidades.MANAUS , 1055);
		this.inserirDistancia( Cidades.PALMAS , Cidades.SAO_PAULO , 1773);
		this.inserirDistancia( Cidades.PALMAS , Cidades.MANAUS , 1511);
		this.inserirDistancia( Cidades.TERERESINA , Cidades.FORTALEZA , 498);
		this.inserirDistancia( Cidades.TERERESINA , Cidades.SAO_LUIS , 328);
		this.inserirDistancia( Cidades.TERERESINA , Cidades.SAO_PAULO , 2655);
		this.inserirDistancia( Cidades.TERERESINA , Cidades.BRASILIA , 1313);
		
		this.espelhar();
									
	}
	
	public void inserirDistancia(Cidades cidade1, Cidades cidade2, double distancia)
	{
		conexoes[cidade1.getOrdem()][cidade2.getOrdem()] = (int)distancia;
	}
	
	public int getDistancia(Cidades cidade1, Cidades cidade2)
	{
		if(this.conexoes[cidade1.getOrdem()][cidade2.getOrdem()] > 0)
		{
			return this.conexoes[cidade1.getOrdem()][cidade2.getOrdem()];
		}
		
		else
		{
			return 0;
		}
	}
	
	public void espelhar()
	{
		for(int i = 0; i < nCidades; i++)
		{
			for(int j = 0; j < this.nCidades; j++)
			{
				if(this.conexoes[i][j] != 0 || this.conexoes[j][i] != 0)
				{
					if(this.conexoes[i][j] > 0)
					{
						this.conexoes[j][i] = this.conexoes[i][j];
					}
					else
					{
						this.conexoes[i][j] = this.conexoes[j][i];
					}
				}
			}
		}
		
	}
	
	public long tempoViagem(Cidades origem, Cidades destino,Aviao aviao)
	{
		int tempo = (this.conexoes[origem.getOrdem()][destino.getOrdem()]/aviao.getVelM());
		return (long)tempo;
	}
}
	
	